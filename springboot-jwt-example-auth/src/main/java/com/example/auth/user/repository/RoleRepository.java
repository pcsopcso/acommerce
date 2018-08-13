package com.example.auth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.auth.user.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(@Param("name") String name);
}
