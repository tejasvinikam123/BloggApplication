package com.tejasvi.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejasvi.blog.exception.ResourceNotFoundException;
import com.tejasvi.blog.module.Category;
import com.tejasvi.blog.payloads.CategoryDto;
import com.tejasvi.blog.repository.CategoryRepository;
import com.tejasvi.blog.service.Categoryservice;

@Service
public class Categoryserviceimpl implements Categoryservice {

	@Autowired
	private CategoryRepository categoryrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	@Override
	public CategoryDto createCategory(CategoryDto categorydeto)  {
		Category cat=this.modelmapper.map(categorydeto,Category.class);
		Category addedcat=this.categoryrepo.save(cat);
		
		return this.modelmapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updatecaterory(CategoryDto categorydto, Integer categoryId) {
		Category cat=this.categoryrepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","category id",categoryId));
		cat.setCategoryTitle(categorydto.getCategoryTitle());
		cat.setCategoryDescription(categorydto.getCategoryDescription());
		Category updatedcat=this.categoryrepo.save(cat);
		return this.modelmapper.map(updatedcat,CategoryDto.class);
	}

	@Override
	public CategoryDto getcategory(Integer categoryId) {
		Category cat=this.categoryrepo.findById(categoryId).orElseThrow(() ->new ResourceNotFoundException("Category", "categoy id", categoryId) );
		return this.modelmapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getcategories() {
		List<Category> categories=this.categoryrepo.findAll();
		List<CategoryDto> catdtos=categories.stream().map((cat)->this.modelmapper.map(cat, CategoryDto.class)).collect(Collectors.toList())	;		
		return catdtos;
	}

	@Override
	public void deletecategory(Integer categoryId) {
	
		Category cat=this.categoryrepo.findById(categoryId).orElseThrow(() ->new ResourceNotFoundException("Category", "category id", categoryId));
		this.categoryrepo.delete(cat);
		
	}

	

}
