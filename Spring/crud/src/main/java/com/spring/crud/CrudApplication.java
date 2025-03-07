package com.spring.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {
	static {
		try {
			String url = System.getenv("DB_URL");
			System.out.println("DB_URL: " + url);
			System.setProperty("DB_URL", url);
		} catch (Exception e) {
			System.out.println("missing url");
		}

		try {
			String user = System.getenv("DB_USER");
			System.out.println("DB_USER: " + user);
			System.setProperty("DB_USER", user);
		} catch (Exception e) {
			System.out.println("missing user");
		}

		try {
			String password = System.getenv("DB_PASSWORD");
			System.out.println("DB_PASSWORD: " + password);
			System.setProperty("DB_PASSWORD", password);
		} catch (Exception e) {
			System.out.println("missing password");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
