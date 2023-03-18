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
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;


private String name;

@Column(name="username",nullable=false,length=100)
private String email;

private String password;
private String about;
@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Post> posts =new ArrayList();


}
