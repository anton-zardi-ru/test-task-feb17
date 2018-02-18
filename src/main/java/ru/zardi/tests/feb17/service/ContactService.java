package ru.zardi.tests.feb17.service;

import ru.zardi.tests.feb17.domain.Contact;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 17:24
 * Date: 2018-02-17.
 */
public interface ContactService {
    Optional<Contact> findByContactId(String contactId);
}
