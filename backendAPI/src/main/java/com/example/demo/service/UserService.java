package com.example.demo.service;

import com.example.demo.dao.UserDB;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class UserService {

	private final UserDB userDb;
	
	@Autowired
	public UserService(@Qualifier("userDb") UserDB userDb) {
		this.userDb=userDb;
	}
	
	public int addUser(User user) {
		return userDb.insertUser(user);
	}
	
	public List<User> getAllUser(){
		return userDb.selectAllUser();
	}
	
	public Optional<User> getUserById(UUID id){
		return userDb.selectUserById(id);
	}
	
	public User UserLoginRequest(String email,String password){
		
		return userDb.loggedinUser(email,password);

	}
	
	public int UserLogoutRequest(UUID id,User user) {
		return userDb.loggedoutUser(id, user);
	}
	public int deleteUser(UUID id) {
		return userDb.deleteUserByID(id);
	}
	
	public int updateUser(UUID id,User user) {
		return userDb.updateUserByID(id, user);
	}
}
