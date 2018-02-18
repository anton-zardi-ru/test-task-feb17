package ru.zardi.tests.feb17.service_rest;

import org.springframework.data.repository.CrudRepository;
import ru.zardi.tests.feb17.domain.Contact;

/**
 * Created by Anton Petrov
 * Time: 16:11
 * Date: 2018-02-17.
 */
//@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
interface ContactRepositoryRest extends CrudRepository<Contact, String> {
//    List<Contact> findByContactId(@Param("contactId") String contactId);
}
