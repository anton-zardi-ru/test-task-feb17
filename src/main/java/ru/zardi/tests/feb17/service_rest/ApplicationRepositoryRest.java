package ru.zardi.tests.feb17.service_rest;

import org.springframework.data.repository.CrudRepository;
import ru.zardi.tests.feb17.domain.Application;

/**
 * Created by Anton Petrov
 * Time: 16:11
 * Date: 2018-02-17.
 *
 *
 */
/*
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>

	    Google don't know, how to disable HAL output
 */
//@RepositoryRestResource(collectionResourceRel = "applications", path = "applications")
interface ApplicationRepositoryRest extends CrudRepository<Application, Long> {
}
