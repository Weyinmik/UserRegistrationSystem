package com.weyinmi.isack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.weyinmi.isack.dto.UserDTO;


@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO, Long> {
	
	UserDTO findByName(String name);
	
	

}
