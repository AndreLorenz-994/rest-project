package com.myblog.rest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.rest.model.Authority;
import com.myblog.rest.model.AuthorityName;
import com.myblog.rest.model.User;
import com.myblog.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	
	public boolean findByUsername(User user) {
		User findByUsername = userRepository.findByUsername(user.getUsername());
		return findByUsername != null;
	}
	
	public void register(User registration) {
	    User user = new User();
	    user.setUsername(registration.getUsername()); 
	    user.setPassword(passwordEncoder.encode(registration.getPassword()));
	    user.setEnabled(true);
	    user.setAuthorities(Arrays.asList(new Authority(AuthorityName.ROLE_USER)));
		userRepository.save(user);
	}
}
