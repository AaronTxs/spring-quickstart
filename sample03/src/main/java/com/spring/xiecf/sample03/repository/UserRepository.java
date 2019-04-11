package com.spring.xiecf.sample03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.xiecf.sample03.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}