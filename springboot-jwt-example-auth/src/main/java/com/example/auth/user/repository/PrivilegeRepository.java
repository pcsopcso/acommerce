package com.example.auth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.auth.user.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	
	Privilege findByName(@Param("name") String name);
}