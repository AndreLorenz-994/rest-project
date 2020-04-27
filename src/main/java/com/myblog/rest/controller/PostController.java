package com.myblog.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.rest.model.Post;
import com.myblog.rest.model.User;
import com.myblog.rest.service.PostService;
import com.myblog.rest.service.UserService;

@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "protected/create", method = RequestMethod.POST)
	public String createPost(@RequestBody Post post ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		post.setUser(user);
		//Post currentPost = postService.createPost(post);
		userService.addPosts(user, post);
		return "Post saved";
	}
	
	@RequestMapping(value="protected/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> getPosts() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());		
	    return postService.getAllPost(user);
	}	

}
