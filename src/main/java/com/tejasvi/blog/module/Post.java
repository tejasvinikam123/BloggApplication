package com.tejasvi.blog.module;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY )
	private Integer postid;
    @Column(name="post_title",length=100,nullable=false)
	private String title;
    @Column(name="post_content",length=4000,nullable=false)
	private String content;
    @Column(name="image_name")
	private String imagename;
	private Date addeddate;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	private User user;
	
}
