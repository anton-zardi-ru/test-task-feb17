package ru.zardi.tests.feb17.dto;

import ru.zardi.tests.feb17.domain.Application;

/**
 * Created by Anton Petrov
 * Time: 19:34
 * Date: 2018-02-17.
 */
public class ResponseFacade {
    public static ResultDTO create(Application application) {
        return new ResultDTO(application.getApplicationId(),
                             application.getDateCreated(),
                             application.getProductName(),
                             application.getContact().getContactId());
    }
}
