package com.tejasvi.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejasvi.blog.payloads.ApiResponse;
import com.tejasvi.blog.payloads.UserDto;
import com.tejasvi.blog.service.Userservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	//post user
	@PostMapping("/adduser")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userDto){
		UserDto createuser=this.userservice.createUser(userDto);
		return new ResponseEntity<UserDto>(createuser,HttpStatus.CREATED);
		
	}

	//put user
	
  @PutMapping("/update/{userid}")
  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userdto,@PathVariable("userid") Integer userid){
	  UserDto update=this.userservice.updateUser(userdto,userid);
	return ResponseEntity.ok(update);
  }

	
	//delete user
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<ApiResponse> deleteuser(@PathVariable("userid") Integer userid){
		this.userservice.deleteUser(userid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true ), HttpStatus.OK);
	
}

	//get all user
@GetMapping("/getAlldata")
public ResponseEntity<List<UserDto>> getAllusers(){
	return ResponseEntity.ok(this.userservice.getAllusers());
	
}
@GetMapping("/getsingledata/{userid}")
public ResponseEntity<UserDto> getsingleuser(@PathVariable Integer userid){
	return ResponseEntity.ok(this.userservice.getUserById(userid));
}
	
	
	
	

}
