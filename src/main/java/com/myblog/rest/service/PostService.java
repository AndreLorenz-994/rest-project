package com.myblog.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.rest.model.Post;
import com.myblog.rest.model.User;
import com.myblog.rest.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public List<Post> getAllPost(User user){
		return user.getPosts();
	}

}
