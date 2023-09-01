package com.uppercaseband;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class Spring6ReactiveUppercaseBandWebappApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		log.debug("Spring6UppercaseBandWebApplication context loaded");
		// perform a sanity check to verify that the beans were loaded (not null)
		assertNotNull(Spring6ReactiveUppercaseBandWebappApplication.class);
		assertNotNull(context);
	}

}
