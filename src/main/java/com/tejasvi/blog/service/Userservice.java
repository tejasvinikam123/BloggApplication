package com.tejasvi.blog.service;

import java.util.List;

import com.tejasvi.blog.payloads.UserDto;

public interface Userservice {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllusers();
	void deleteUser(Integer userId);
	
}
