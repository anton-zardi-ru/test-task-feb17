package ru.zardi.tests.feb17.service;

import ru.zardi.tests.feb17.domain.Application;
import ru.zardi.tests.feb17.domain.Contact;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 18:45
 * Date: 2018-02-17.
 */
public interface ApplicationService {
    Optional<Application> findLatestForContact(Contact contact);
}
