package com.mins.fetchjoin.controller;

import com.mins.fetchjoin.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
