package com.pool;

import com.pool.models.Users;
import com.pool.services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConnectionPoolExampleApplicationTests {

	@Autowired
	private UserServices userServices;
	@Test
	public void insertTest() {
		Users user = userServices.saveUser(new Users(12, "Raushan kumar", "Software Engineer"));
		System.out.println(user.getId() + " : " + user.getName());
	}

	@Test
	public void allUserTest(){
		userServices.getAllUsers().forEach(users -> {
			System.out.println(users.getName());
		});
	}

	@Test
	public void getSingleUserTest(){
		Users user = userServices.getUserById(4);
		System.out.println(user.getName());
	}

	@Test
	public void deleteUserTest(){
		userServices.deleteUser(4);
	}

}
