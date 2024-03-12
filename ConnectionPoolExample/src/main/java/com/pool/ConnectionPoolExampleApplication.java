package com.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class ConnectionPoolExampleApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConnectionPoolExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App started");
		jdbcTemplate.update("insert into users(id,name,about) values(3,'Narayani', 'Product Manager')");
		System.out.println("data added");

		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from users");
		queryForList.forEach((item)->{
			System.out.println("id: " + item.get("id"));
			System.out.println("name: " + item.get("name"));
			System.out.println("about: " + item.get("about"));
			System.out.println("=====================================");
		});
	}
}
