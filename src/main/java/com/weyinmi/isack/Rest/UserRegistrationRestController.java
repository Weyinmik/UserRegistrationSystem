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

import com.weyinmi.isack.dto.UserDTO;
import com.weyinmi.isack.repository.UserJpaRepository;



@RestController
@RequestMapping("/api/user")

public class UserRegistrationRestController {
	public static final Logger logger = 
			LoggerFactory.getLogger(UserRegistrationRestController.class);
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> listAllUsers(){
		List<UserDTO> users = userJpaRepository.findAll();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@PostMapping(value= "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO user){
		userJpaRepository.save(user);
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}

}
