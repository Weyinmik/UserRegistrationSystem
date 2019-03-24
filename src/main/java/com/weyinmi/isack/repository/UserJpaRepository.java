package com.weyinmi.isack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weyinmi.isack.UserRegistrationSystem.UserDTO;

public interface UserJpaRepository extends JpaRepository<UserDTO, Long> {
	UserDTO findByName(String name);

}
