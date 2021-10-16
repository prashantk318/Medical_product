package com.prashant.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.model.Role;
import com.prashant.model.User;
import com.prashant.model.UserRole;
import com.prashant.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		//encoding  password with bcryptPasswordEncoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole>roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.service.createUser(user, roles);
		
}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username")String username) {
		return this.service.getUser(username);
		
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long userId) {
		this.service.deleteUser(userId);
		
	}
}
