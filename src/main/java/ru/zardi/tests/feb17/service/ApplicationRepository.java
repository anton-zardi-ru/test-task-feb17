package ru.zardi.tests.feb17.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.zardi.tests.feb17.domain.Application;
import ru.zardi.tests.feb17.domain.Contact;

/**
 * Created by Anton Petrov
 * Time: 17:15
 * Date: 2018-02-17.
 */
interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {
    Page<Application> findByContact(Contact contact, Pageable pageable);
}
