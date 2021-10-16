package com.prashant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashant.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
