package com.weyinmi.isack.Rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weyinmi.isack.repository.UserJpaRepository;


@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	private UserJpaRepository userJpaRepository;

}
