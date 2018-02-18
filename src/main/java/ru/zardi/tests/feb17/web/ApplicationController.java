package ru.zardi.tests.feb17.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zardi.tests.feb17.domain.Application;
import ru.zardi.tests.feb17.domain.Contact;
import ru.zardi.tests.feb17.dto.ResponseFacade;
import ru.zardi.tests.feb17.dto.ResultDTO;
import ru.zardi.tests.feb17.service.ApplicationService;
import ru.zardi.tests.feb17.service.ContactService;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 17:22
 * Date: 2018-02-17.
 */
@RestController
public class ApplicationController {
    public static final String CONTACT_ID_GENERATES_EXCEPTIONS = "contactIdGeneratesException";

    private final ContactService contactService;

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ContactService contactService, ApplicationService applicationService) {
        this.contactService = contactService;
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/latestApplication", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO> findLastApplication(@RequestParam(value = "contactId") String contactId) {
        if (CONTACT_ID_GENERATES_EXCEPTIONS.equals(contactId)) {
            throw new RuntimeException("test exception");
        }

        final Optional<Contact> contactOptional = contactService.findByContactId(contactId);
        if (!contactOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }

        final Optional<Application> applicationOptional = applicationService.findLatestForContact(contactOptional.get());
        return applicationOptional.map(application -> new ResponseEntity<>(ResponseFacade.create(application),
                                                                           HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
