package com.rajiv.spring.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajiv.spring.security.demo.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
