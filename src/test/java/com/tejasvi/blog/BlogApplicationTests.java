package com.tejasvi.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tejasvi.blog.repository.UserRepository;

@SpringBootTest
class BlogApplicationTests {
@Autowired
private UserRepository userrepo;
	@Test
	void contextLoads() {
	}

	
	@Test
	public void repoTest(){
		String ClassName=this.userrepo.getClass().getName();
		String PackName=this.userrepo.getClass().getPackageName();
		System.out.println(ClassName);
		System.out.println(PackName);
	}
}
