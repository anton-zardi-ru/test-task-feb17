package ru.zardi.tests.feb17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.zardi.tests.feb17.domain.Contact;

import java.util.Optional;

/**
 * Created by Anton Petrov
 * Time: 17:28
 * Date: 2018-02-17.
 */
@Component("contactService")
@Transactional
class ContactServiceImpl implements ContactService {
    private final
    ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Optional<Contact> findByContactId(String contactId) {
        return contactRepository.findByContactId(contactId);
    }
}
