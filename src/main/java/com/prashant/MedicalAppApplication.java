package com.prashant;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prashant.model.Role;
import com.prashant.model.User;
import com.prashant.model.UserRole;
import com.prashant.service.UserService;

@SpringBootApplication
public class MedicalAppApplication implements CommandLineRunner{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(MedicalAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
		User user = new User();
		user.setFirstName("sneha");
		user.setLastName("Kalshetti");
		user.setPassword(this.bCryptPasswordEncoder.encode("sneha"));
		user.setEmail("sneha@gmail.com");
		user.setProfile("default.png");
		user.setUsername("sneha");
		
		
		Role role = new Role();
		role.setRoleId(42L);
		role.setRoleName("ADMIN");
		Set<UserRole>userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		
		User user1 = this.service.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
		
		
	}

}
