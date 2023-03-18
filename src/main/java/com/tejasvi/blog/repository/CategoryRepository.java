package com.tejasvi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejasvi.blog.module.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
