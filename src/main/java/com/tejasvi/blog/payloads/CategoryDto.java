package com.tejasvi.blog.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	private Integer categoryId;
	
	 private String categoryTitle;
	
	 private String categoryDescription;
}
