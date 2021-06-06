package com.amit.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;


@SpringBootApplication
public class SpringSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		//To generate the hash from the password to store inside db for user password
		// since bcrypt encoder is invalidating the plain text password
		// will comment once create user api is done
		String pw_hash = BCrypt.hashpw("12345", BCrypt.gensalt());
		System.out.println("pw_hash...."+pw_hash);
	}
}
