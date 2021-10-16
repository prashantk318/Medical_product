package com.prashant.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.model.User;
import com.prashant.model.UserRole;
import com.prashant.repo.RoleRepository;
import com.prashant.repo.UserRepository;
import com.prashant.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userrepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("user is already there !!");
			throw new Exception("user already present");
		}else {
			//create user
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userrepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userrepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userrepository.deleteById(userId);
		
	}

}
