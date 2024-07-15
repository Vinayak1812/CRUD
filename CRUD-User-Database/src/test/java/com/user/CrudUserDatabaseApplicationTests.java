package com.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.model.User;
import com.user.repository.UserRepository;

@SpringBootTest
class CrudUserDatabaseApplicationTests {
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void testCreate () {
		User u1 = new User();
		u1.setName("Aman");
		u1.setEmail("aman100@gmail.com");
		u1.setMobileNo("9874563211");
		
		userRepo.save(u1);
		System.out.println(u1);
		assertNotNull(userRepo.findById(1L).get());
	}
	
	@Test
	public void testReadAll() {
		List<User> list = userRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

}
