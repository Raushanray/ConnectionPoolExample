package com.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ConnectionPoolExampleApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConnectionPoolExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App started");
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from users");
		queryForList.forEach((item)->{
			System.out.println("id: " + item.get("id"));
			System.out.println("name: " + item.get("name"));
			System.out.println("about: " + item.get("about"));
			System.out.println("=====================================");
		});
	}
}
