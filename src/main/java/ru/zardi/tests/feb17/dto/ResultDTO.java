package ru.zardi.tests.feb17.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Anton Petrov
 * Time: 19:24
 * Date: 2018-02-17.
 */
@SuppressWarnings("unused")
@JacksonXmlRootElement(localName = "LATEST_APPLICATION_OF_CONTACT")
public class ResultDTO {
    @JsonProperty("APPLICATION_ID")
    private String applicationId;

    @JsonProperty("DT_CREATED")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z")
    private Date dateCreated;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    @JsonProperty("CONTACT_ID")
    private String contactId;

    public ResultDTO() {
    }

    public ResultDTO(String applicationId,
                     Date dateCreated,
                     String productName,
                     String contactId) {
        this.applicationId = applicationId;
        this.dateCreated = dateCreated;
        this.productName = productName;
        this.contactId = contactId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getProductName() {
        return productName;
    }

    public String getContactId() {
        return contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO resultDTO = (ResultDTO) o;
        return Objects.equals(applicationId,
                              resultDTO.applicationId) &&
                Objects.equals(dateCreated,
                               resultDTO.dateCreated) &&
                Objects.equals(productName,
                               resultDTO.productName) &&
                Objects.equals(contactId,
                               resultDTO.contactId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(applicationId,
                            dateCreated,
                            productName,
                            contactId);
    }
}
