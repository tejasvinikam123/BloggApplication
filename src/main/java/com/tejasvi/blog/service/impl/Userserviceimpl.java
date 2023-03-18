package com.tejasvi.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejasvi.blog.exception.*;
import com.tejasvi.blog.module.User;
import com.tejasvi.blog.payloads.UserDto;
import com.tejasvi.blog.repository.UserRepository;
import com.tejasvi.blog.service.Userservice;

@Service
public class Userserviceimpl implements Userservice {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user = this.DtotoUser(userdto);
		User saveduser = this.userrepo.save(user);
		return this.UserToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userId) {
		User user = this.userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updateduser = this.userrepo.save(user);
		UserDto usersto1 = this.UserToDto(updateduser);
		return usersto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllusers() {
		List<User> users = this.userrepo.findAll();
		List<UserDto> userdtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userrepo.delete(user);

	}

	private User DtotoUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

// User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getPassword());
//		user.setPassword(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
		return user;
	}

	private UserDto UserToDto(User user) {

		//UserDto userDto=this.modelMapper.map(user, UserDto.class);)
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		UserDto userdto = new UserDto();
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setEmail(user.getEmail());
//		userdto.setPassword(user.getPassword());
//		userdto.setAbout(user.getAbout());
		return userDto;
	}
}
