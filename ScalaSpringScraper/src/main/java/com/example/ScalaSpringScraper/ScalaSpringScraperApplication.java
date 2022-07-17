package com.example.ScalaSpringScraper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ScalaSpringScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScalaSpringScraperApplication.class, args);
	}

	@Bean public CommandLineRunner commandLineRunner(JdbcTemplate jdbcTemplate){
		return args -> {
			String sql = "INSERT INTO testtable values(1,'dorian','dolz');";
			String sql2 = "DELETE FROM testtable WHERE ID = 1;";
			String sql3 = "SELECT * from testtable;";
			int rows = jdbcTemplate.update(sql);
		};
	}


}
