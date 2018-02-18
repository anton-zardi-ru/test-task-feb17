package ru.zardi.tests.feb17.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Anton Petrov
 * Time: 16:02
 * Date: 2018-02-17.
 */
@SuppressWarnings("unused")
@Entity
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "application_generator", sequenceName = "application_sequence")
    @GeneratedValue(generator = "application_generator")
    private Long id;

    @Column(nullable = false, unique = true)
    private String applicationId;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private String productName;

    @ManyToOne(optional = false)
    private Contact contact;

    public Application() {
    }

    public Application(String applicationId, Date dateCreated, String productName, Contact contact) {
        this.applicationId = applicationId;
        this.dateCreated = dateCreated;
        this.productName = productName;
        this.contact = contact;
    }

    public Long getId() {
        return id;
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

    public Contact getContact() {
        return contact;
    }


}
