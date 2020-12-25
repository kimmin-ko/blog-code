package com.mins.fetchjoin.employee;

import com.mins.fetchjoin.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {

    @Query("select e from Employee e join fetch e.department")
    List<Employee> findAllWithDepartment();

}