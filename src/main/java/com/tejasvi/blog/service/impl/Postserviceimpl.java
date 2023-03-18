package com.tejasvi.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejasvi.blog.exception.ResourceNotFoundException;
import com.tejasvi.blog.module.Category;
import com.tejasvi.blog.module.Post;
import com.tejasvi.blog.module.User;
import com.tejasvi.blog.payloads.PostDto;
import com.tejasvi.blog.repository.CategoryRepository;
import com.tejasvi.blog.repository.PostRepository;
import com.tejasvi.blog.repository.UserRepository;
import com.tejasvi.blog.service.Postservice;

@Service
public class Postserviceimpl implements Postservice {

	
	@Autowired
	private PostRepository postrepo;
	@Autowired
	private ModelMapper modelmapper;
	@Autowired
	private CategoryRepository categoryrepo;
	
	@Autowired
	private UserRepository userrepository;
	@Override
	public PostDto createPost(PostDto postdto,Integer userId,Integer categoryId) {
		User user=this.userrepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user id", userId));
		Category category=this.categoryrepo.findById(categoryId).orElseThrow(() ->new ResourceNotFoundException("Category","category id",categoryId));
		Post post=this.modelmapper.map(postdto ,Post.class);
		post.setImagename("default.png");
		post.setAddeddate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost=this.postrepo.save(post);
		return this.modelmapper.map(newPost,PostDto.class);
	}

	@Override
	public PostDto updatepost(PostDto postdto, Integer PostId) {
	
		return null;
	}

	@Override
	public void deletepost(Integer postId) {
		
		
	}

	@Override
	public List<Post> getAllpost() {
	
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer CategoryId) {
		Category cat=this.categoryrepo.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("category","category Id",CategoryId));
		List<Post> posts=this.postrepo.findByCategory(cat);
		List<PostDto> postdtos=posts.stream().map((Post)-> this.modelmapper.map(Post,PostDto.class)).collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public List<PostDto> getPostByAllUser(Integer UserId) {
		User user=this.userrepository.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", UserId));
		List<Post> posts=this.postrepo.findByUser(user); 
		List<PostDto> postdtos=posts.stream().map((Post)->this.modelmapper.map(Post, PostDto.class)).collect(Collectors.toList());				
		return postdtos;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		
		return null;
	}

}
