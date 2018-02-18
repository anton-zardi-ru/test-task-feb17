package ru.zardi.tests.feb17;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.zardi.tests.feb17.dto.ResultDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationFeb17Tests {
    private final static ObjectMapper jsonMapper = new ObjectMapper();

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z");

    private final XmlMapper xmlMapper = new XmlMapper();


    @Autowired
    private WebApplicationContext context;


    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetLatestApplication() throws Exception {
        assertGoodRequest(new ResultDTO("APPLICATION 2",
                                        dateFormat.parse("2018-02-02 02:02:00 +0000"),
                                        "PRODUCT NAME 2",
                                        "CONTACT 1"));

        assertGoodRequest(new ResultDTO("APPLICATION 3",
                                        dateFormat.parse("2018-03-03 03:03:00 UTC"),
                                        "PRODUCT NAME 1",
                                        "CONTACT 2"));


        assertBadRequest("CONTACT 3",
                         status().isNotFound());

        assertBadRequest("CONTACT 4",
                         status().isFailedDependency());
    }

    @Test
    public void testGetLatestApplicationXml() throws Exception {
        ResultDTO expected = new ResultDTO("APPLICATION 2",
                                           dateFormat.parse("2018-02-02 02:02:00 +0000"),
                                           "PRODUCT NAME 2",
                                           "CONTACT 1");
        final String result =
                this.mvc.perform(get("/lastApplication?contactId=" + expected.getContactId()).accept(MediaType.APPLICATION_XML))
                        .andExpect(status().isOk()).andReturn().getResponse()
                        .getContentAsString();
        ResultDTO response = xmlMapper.readValue(result,
                                                  ResultDTO.class);
        Assert.assertEquals(expected, response);
    }

    private void assertGoodRequest(ResultDTO expected) throws Exception {
        final String result =
                this.mvc.perform(get("/lastApplication?contactId=" + expected.getContactId())).andExpect(status().isOk()).andReturn().getResponse()
                        .getContentAsString();
        ResultDTO response = jsonMapper.readValue(result,
                                                  ResultDTO.class);
        Assert.assertEquals(expected,
                            response);
    }

    private void assertBadRequest(String contactId, ResultMatcher expectedStatus) throws Exception {
        this.mvc.perform(get("/lastApplication?contactId=" + contactId)).andExpect(expectedStatus);
    }
}
