package com.rajiv.spring.security.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rajiv.spring.security.demo.model.User;

@Service
public class HardCodedUserService {

	List<User> list = new ArrayList<>();

	public HardCodedUserService() {
		list.add(new User("1", "abc", "abc", "abc@gmail.com", "NORMAL"));
		list.add(new User("2", "def", "def", "def@gmail.com", "Admin"));
	}

	public List<User> getAllUser() {
		return this.list;
	}

	public User getUser(String username) {
		return this.list.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findAny().orElse(null);
	}

	public User addUser(User user) {

		this.list.add(user);
		return user;
	}
}
