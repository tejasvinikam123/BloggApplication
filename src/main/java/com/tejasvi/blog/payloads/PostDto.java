package com.tejasvi.blog.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
private String title;
private String content;
//private String imageName="default.png";
private String imageName;
private Date addedDate;
private CategoryDto category;
private UserDto user;
}
