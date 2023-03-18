package com.tejasvi.blog.service;

import java.util.List;

import com.tejasvi.blog.module.Post;
import com.tejasvi.blog.payloads.PostDto;

public interface Postservice {
   //create
	PostDto createPost(PostDto postdto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatepost(PostDto postdto,Integer PostId);
	
	//delete
	void deletepost(Integer postId);
	
	//get all post
	List<Post> getAllpost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get allpost by category
	List<PostDto> getPostByCategory(Integer CategoryId);
	
	//get all post by user
	List<PostDto> getPostByAllUser(Integer UserId);
	
	//search post
	List<Post> searchPost(String keyword);
}
