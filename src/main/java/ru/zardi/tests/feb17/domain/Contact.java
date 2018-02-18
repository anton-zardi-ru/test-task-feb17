package ru.zardi.tests.feb17.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * Created by Anton Petrov
 * Time: 15:57
 * Date: 2018-02-17.
 */
@SuppressWarnings("unused")
@Entity
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "contact_generator", sequenceName = "contact_sequence")
    @GeneratedValue(generator = "contact_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String contactId;

    public Contact() {
    }

    public Contact(String contactId) {
        this.contactId = contactId;
    }

    public Long getId() {
        return id;
    }

    public String getContactId() {
        return contactId;
    }
}
