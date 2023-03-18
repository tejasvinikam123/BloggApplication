package com.tejasvi.blog.module;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer categoryId;
@NotBlank
@Column(name="title", length=100, nullable=false)
@Size(min=4,message="min size of category title is 4")
 private String categoryTitle;
@NotBlank
@Column(name="Description")
@Size(min=5,message="min size of category title is 5")
 private String categoryDescription;

@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Post> posts =new ArrayList();

}
