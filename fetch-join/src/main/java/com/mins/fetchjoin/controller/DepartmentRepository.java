package com.mins.fetchjoin.controller;

import com.mins.fetchjoin.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}