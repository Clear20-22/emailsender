package com.emailsender.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailsenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailsenderApplication.class, args);
		System.out.println("Email Sender Application started successfully!");
		System.out.println("Access the web interface at: http://localhost:8080");
	}

}
