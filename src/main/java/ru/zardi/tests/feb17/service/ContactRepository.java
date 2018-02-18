package ru.zardi.tests.feb17.service;

import org.springframework.data.repository.Repository;
import ru.zardi.tests.feb17.domain.Contact;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 17:15
 * Date: 2018-02-17.
 */
interface ContactRepository extends Repository<Contact, Long> {
    Optional<Contact> findByContactId(String contactId);
}
