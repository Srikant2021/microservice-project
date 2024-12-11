package com.utb.userService.services;

import java.util.List;

import com.utb.userService.entities.User;

public interface UserServices {
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
}
