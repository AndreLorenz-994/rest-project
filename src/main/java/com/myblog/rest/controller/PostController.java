package com.myblog.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.rest.model.Post;
import com.myblog.rest.service.PostService;

@RestController
public class PostController {

	@Autowired
	PostService postService;

	@RequestMapping(value = "protected/create", method = RequestMethod.POST)
	public String createPost(@RequestParam String postTitle, @RequestParam String postDesc) {
		postService.createPost(postTitle, postDesc);
		return "Post saved";
	}
	
	@RequestMapping(value="protected/posts", method = RequestMethod.GET)
	public @ResponseBody List<Post> getPosts() {
	    return postService.getAllPost();
	}	

}
