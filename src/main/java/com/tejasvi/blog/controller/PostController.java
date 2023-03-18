 package com.tejasvi.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tejasvi.blog.payloads.PostDto;
import com.tejasvi.blog.service.Postservice;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private Postservice postservice;
	
	
//create
	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createpost(@RequestBody PostDto postdto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		
		PostDto createpost=this.postservice.createPost(postdto, userId, categoryId);
		return new ResponseEntity<PostDto>(createpost,HttpStatus.CREATED);
		
	}
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId)
	{
		List<PostDto> postdtos=this.postservice.getPostByCategory(userId);
		return new ResponseEntity<List<PostDto>>(postdtos,HttpStatus.OK);
		
	}
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> postdtos=this.postservice.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postdtos,HttpStatus.OK);
		
	}
}
