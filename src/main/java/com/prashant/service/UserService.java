package com.prashant.service;

import java.util.Set;

import com.prashant.model.User;
import com.prashant.model.UserRole;

public interface UserService {
	//creating users
	
	public User createUser(User user, Set<UserRole>userRole) throws Exception;
//get user by username
	public User getUser(String username);
	public void deleteUser(Long userId);
}
