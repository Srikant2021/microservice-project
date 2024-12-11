package com.utb.userService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utb.userService.entities.User;
import com.utb.userService.exception.ResourceNotFoundException;
import com.utb.userService.repositoreis.UserRepository;
import com.utb.userService.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with the provided id "+userId));
	}

}
