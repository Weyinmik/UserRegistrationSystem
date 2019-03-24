package com.weyinmi.isack.Rest;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weyinmi.isack.dto.UsersDTO;
import com.weyinmi.isack.repository.UserJpaRepository;



@RestController
@RequestMapping("/api")

public class UserRegistrationRestController {
	public static final Logger logger = 
			LoggerFactory.getLogger(UserRegistrationRestController.class);
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}
	
	//	Fetch all users 
	@GetMapping("/user")
	public ResponseEntity<List<UsersDTO>> listAllUsers() {
		List<UsersDTO> users = userJpaRepository.findAll();
		return new ResponseEntity<List<UsersDTO>>(users, HttpStatus.OK);
	}
	
	//	Add a user to UserRegistrationSystem by implementing the POST verb functionality.
	@PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersDTO> createUser(@RequestBody final UsersDTO user){
		return new ResponseEntity<UsersDTO>(user, HttpStatus.CREATED);
		
	}
	
}
