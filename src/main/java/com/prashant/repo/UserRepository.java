package com.prashant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}
