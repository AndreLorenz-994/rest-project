package com.myblog.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.rest.model.Post;
import com.myblog.rest.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(String postTitle, String postDesc) {
		return postRepository.save(new Post(postTitle, postDesc));
	}
	
	public List<Post> getAllPost(){
		return postRepository.findAll();
	}

}
