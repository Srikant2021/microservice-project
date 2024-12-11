package com.utb.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utb.userService.entities.User;
import com.utb.userService.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}

	@GetMapping("/getSingleUser/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = userServices.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
