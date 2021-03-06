package com.example.demo.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-security</artifactId>
//</dependency>

public class User {
	
	
	private final UUID id;
	
	@NotBlank(message="please enter your name!")
	@Size(min=3, max=30, message="Please enter your name between 3-30 characters!")
	private final String name;
	
	@Email(message = "please enter a valid email!")
	@NotBlank(message="please enter your email!")
	private final String email;
	
	@NotBlank(message="please enter your password!")
	@Size(min=6, max=30, message="Please enter your password between 6-30 characters!")
	private final String password;	
	
	private boolean isLoggedIn;
	
	public User(@JsonProperty("id") UUID id,
				@JsonProperty("name") String name, 
				@JsonProperty("email") String email, 
				@JsonProperty("password") String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    //String encodedPassword = passwordEncoder.encode(password);
	    this.password = password;
	    this.isLoggedIn = false;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	
	public void setIsLoggedIn(boolean value) {
		this.isLoggedIn=value;
	}
}
