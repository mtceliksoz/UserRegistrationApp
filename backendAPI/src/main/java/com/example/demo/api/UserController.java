package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.lang.NonNull;
import javax.validation.Valid;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/user")
@RestController
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping
	public void addUser( @Valid @NonNull @RequestBody User user) {
		System.out.println("Post request alındı");
		
		
		this.userService.addUser(user);
		
		System.out.println("Post request response u üretildi");

	}
	
	@GetMapping
	public List<User> getAllUser(){
		System.out.println("Get request alındı");
		return userService.getAllUser();

	}
	
	@PostMapping(path = "/login")
	public User LoginRequest(@RequestBody User user){
		//System.out.println("Get request alındı");
		
		return userService.UserLoginRequest(user.getEmail(),user.getPassword());

	}
	
	@GetMapping(path = "{id}")
	public User getUserById(@PathVariable("id") UUID id){
		return userService.getUserById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteUserById(@PathVariable("id") UUID id){
		userService.deleteUser(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateUserById(@Valid @NonNull @PathVariable("id") UUID id, @RequestBody User user){
		userService.updateUser(id, user);
	}
	@PutMapping(path = "/logout/"+"{id}")
	public void LogoutRequest(@Valid @NonNull @PathVariable("id") UUID id, @RequestBody User user){
		userService.UserLogoutRequest(id, user);
	}
}
