package com.tejasvi.blog.service;

import java.util.List;

import com.tejasvi.blog.module.Category;
import com.tejasvi.blog.payloads.CategoryDto;

public interface Categoryservice {
//create
	CategoryDto createCategory(CategoryDto categorydeto);
	
//update
	CategoryDto updatecaterory(CategoryDto categorydeto,Integer categoryId);
	//get
	public CategoryDto getcategory(Integer categoryId);
	//getall
	public List<CategoryDto> getcategories();
	//delete
	public void deletecategory(Integer categoryId);

	
}
