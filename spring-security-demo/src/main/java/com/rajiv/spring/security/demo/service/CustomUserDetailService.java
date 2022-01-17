package com.rajiv.spring.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rajiv.spring.security.demo.model.CustomUserDetail;
import com.rajiv.spring.security.demo.model.User;
import com.rajiv.spring.security.demo.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getById(username);
		if (user == null) {
			throw new UsernameNotFoundException("No User");
		}

		return new CustomUserDetail(user);
	}

}
