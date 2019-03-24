package com.weyinmi.isack.Rest;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		userJpaRepository.save(user);
		return new ResponseEntity<UsersDTO>(user, HttpStatus.CREATED);
		
	}
	
	//	Implement an endpoint to access an individual user by using @GetMapping("/{id}"
	@GetMapping("/user/{id}")
	public ResponseEntity<UsersDTO> getUserById(@PathVariable("id") final Long id){
		UsersDTO user = userJpaRepository.findById(id);
		return new ResponseEntity<UsersDTO>(user, HttpStatus.OK);
		
	}
	
//	Implement an endpoint to update an individual user by using @PutMapping
	@PutMapping(value = "/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsersDTO> updateUser(@PathVariable("id") final Long id, @RequestBody UsersDTO user){
		//	Fetch user based on id and set it to currentUser object of type UsersDTO
		UsersDTO currentUser = userJpaRepository.findById(id);
		
		//	Update currentUser object data with user object data
		currentUser.setName(user.getName());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());
		
		//	Save currentUser object
		userJpaRepository.saveAndFlush(currentUser);
		
		//	Return Repository Object
		return new ResponseEntity<UsersDTO>(currentUser, HttpStatus.OK);
		
	}
	
//	Implement the delete functionality for an endpoint to delete an existing user from the UserRegistrationSystem by using @DeleteMapping
	@DeleteMapping("/user/{id}")
	public ResponseEntity<UsersDTO> deleteUser(@PathVariable("id") final long id){
		userJpaRepository.delete(id);
		return new ResponseEntity<UsersDTO>(HttpStatus.NO_CONTENT);
		
	}
}
