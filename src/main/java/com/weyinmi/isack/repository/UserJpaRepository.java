package com.weyinmi.isack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weyinmi.isack.dto.UsersDTO;

@Repository
public interface UserJpaRepository extends JpaRepository<UsersDTO, Long> {

	UsersDTO findByName(String name);
}
