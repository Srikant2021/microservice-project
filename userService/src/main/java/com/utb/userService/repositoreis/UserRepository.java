package com.utb.userService.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utb.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
