package com.tejasvi.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejasvi.blog.payloads.ApiResponse;
import com.tejasvi.blog.payloads.CategoryDto;
import com.tejasvi.blog.service.Categoryservice;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private Categoryservice categoryservice;
	@PostMapping("/add")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categorydeto){
		CategoryDto creatcategory =this.categoryservice.createCategory(categorydeto);
		return new ResponseEntity<CategoryDto>(creatcategory,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCaterory(@RequestBody CategoryDto categorydeto,@PathVariable Integer catId){
		CategoryDto updatecategory =this.categoryservice.updatecaterory(categorydeto,catId);
		return new ResponseEntity<CategoryDto>(updatecategory,HttpStatus.OK);
		
	}
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> DeleteCategory(@PathVariable Integer catId){
	this.categoryservice.deletecategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted succesfully", false),HttpStatus.OK);
		
	}
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
    CategoryDto categorydto=this.categoryservice.getcategory(catId);
return new ResponseEntity<CategoryDto>(categorydto,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
  List<CategoryDto> categories= this.categoryservice.getcategories();
return ResponseEntity.ok(categories);
		
	}
	
}
