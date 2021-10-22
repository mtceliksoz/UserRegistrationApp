package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Repository("userDb")
public class UserDB {
	
	private static List<User> DB = new ArrayList<>();
	
	public int insertUser(User user) {
		UUID id = UUID.randomUUID();
		DB.add(new User(id,user.getName(),user.getEmail(),user.getPassword()));
		return 1;	
	}
	
	public List<User> selectAllUser(){
		return DB;
	}
	
	public Optional<User> selectUserById(UUID id){
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
	
	public User loggedinUser(String email,String password){
		User usertoCheck = DB.stream().filter(person -> person.getEmail().equals(email)).findFirst().get();
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    //String encodedPassword = passwordEncoder.encode(password);
		if(usertoCheck.getPassword().equals(password)) {
			usertoCheck.setIsLoggedIn(true);
			selectUserById(usertoCheck.getId()).map(usertoUpdate -> {
				int indexofUser = DB.indexOf(usertoUpdate);
				if(indexofUser>=0) {
					DB.set(indexofUser,usertoCheck );
					return usertoCheck;
				}
				else
					return usertoCheck;
			});
			
		}
				return usertoCheck;
	}
	
	public int loggedoutUser(UUID id, User user) {
		//user.setIsLoggedIn(false);
		return updateUserByID(id,user);
	}
	public int deleteUserByID(UUID id) {
		Optional<User> userOptional = selectUserById(id);
		if(userOptional.isEmpty())
			return 0;
		DB.remove(userOptional.get());
		return 1;
	}
	
	public int updateUserByID(UUID id, User user) {
		selectUserById(id).map(usertoUpdate -> {
			int indexofUser = DB.indexOf(usertoUpdate);
			if(indexofUser>=0) {
				DB.set(indexofUser, new User(id,user.getName(),user.getEmail(),user.getPassword()));
				return 1;
			}
			else
				return 0;
		});
		return 0;
	}

}
