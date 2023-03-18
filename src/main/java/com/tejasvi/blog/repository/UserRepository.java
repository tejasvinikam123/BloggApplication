package com.tejasvi.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejasvi.blog.module.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Optional<User> findById(User user);

}
