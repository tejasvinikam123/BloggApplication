package com.tejasvi.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejasvi.blog.module.Category;
import com.tejasvi.blog.module.Post;
import com.tejasvi.blog.module.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
