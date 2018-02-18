package ru.zardi.tests.feb17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.zardi.tests.feb17.domain.Application;
import ru.zardi.tests.feb17.domain.Contact;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 18:58
 * Date: 2018-02-17.
 */
@Component("applicationService")
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Optional<Application> findLatestForContact(Contact contact) {
        Page<Application> page = applicationRepository.findByContact(contact,
                                                                     new PageRequest(0,
                                                                                     1,
                                                                                     Sort.Direction.DESC,
                                                                                     "dateCreated"));
        return page.getTotalElements() > 0 ? Optional.of(page.getContent().get(0)) : Optional.empty();
    }
}
