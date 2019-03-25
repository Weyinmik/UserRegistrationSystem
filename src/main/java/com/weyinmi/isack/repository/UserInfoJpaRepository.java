package com.weyinmi.isack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weyinmi.isack.dto.UserInfo;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Long> {

}
