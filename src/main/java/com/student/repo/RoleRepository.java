package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.been.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
