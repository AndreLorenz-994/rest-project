package com.myblog.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.rest.model.Authority;
import com.myblog.rest.model.AuthorityName;
import com.myblog.rest.model.Post;
import com.myblog.rest.model.User;
import com.myblog.rest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	
	public User findByUsername(String user) {
		return userRepository.findByUsername(user);
	}
	
	public void register(User registration) {
	    User user = new User();
	    user.setUsername(registration.getUsername()); 
	    user.setPassword(passwordEncoder.encode(registration.getPassword()));
	    user.setEnabled(true);
	    user.setAuthorities(Arrays.asList(new Authority(AuthorityName.ROLE_USER)));
	    // se non aggiungo riga 35 mi da null pointer exception causato da riga 40
	    user.setPosts(Arrays.asList(new Post()));
		userRepository.save(user);
	}
	
	public void addPosts(User user, Post post) {
		List<Post> posts = user.getPosts();
		posts.add(post);
		//user.getPosts().add(post);
		userRepository.save(user);
		// user not saved receive an error
	}	
}
