package com.tejasvi.blog.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String resourceName, String fieldName, Integer userId) {
		super(String.format("%s not found with %s :%s",resourceName,fieldName,userId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = userId;
	}
	String resourceName;
	String fieldName;
	Integer fieldValue;
}
