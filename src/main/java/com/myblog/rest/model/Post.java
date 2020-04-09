package com.myblog.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Posts")
public class Post {

	@Id
	private String id;
	
	private String postTitle;
	
	private String postDesc;
	
	public Post() {}	
	
	public Post(String postTitle, String postDesc) {
		this.postTitle = postTitle;
		this.postDesc = postDesc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
		
}
