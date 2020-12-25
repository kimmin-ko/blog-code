package com.mins.fetchjoin.employee;

import com.mins.fetchjoin.department.DepartmentRepository;
import com.mins.fetchjoin.entity.Department;
import com.mins.fetchjoin.entity.Employee;
import com.p6spy.engine.spy.appender.CustomLineFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Rollback(false)
@Transactional
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    void setup() {
        // 부서 10개 저장
        for (int i = 0; i < 10; i++)
            departmentRepository.save(new Department("부서" + (i + 1)));

        List<Department> findDepartments = departmentRepository.findAll();

        // 직원 50개 저장
        for (int i = 0; i < 20; i++)
            employeeRepository.save(new Employee("직원" + (i + 1), findDepartments.get(i % 10)));

        em.flush();
        em.clear();
    }

    @Test
    void department_name_조회() {
        List<Employee> findEmployees = employeeRepository.findAll();

        for (Employee findEmployee : findEmployees) {
            System.out.println("employee = " + findEmployee.getName());
            System.out.println("department name = " + findEmployee.getDepartment().getName());
        }
    }

    @Test
    void department_id_조회() {
        List<Employee> findEmployees = employeeRepository.findAll();

        for (Employee findEmployee : findEmployees) {
            System.out.println("employee = " + findEmployee.getName());
            System.out.println("department id = " + findEmployee.getDepartment().getId());
        }
    }

    @Test
    void department_name_조회_fetch_join() {
        List<Employee> findEmployees = employeeRepository.findAllWithDepartment();

        for (Employee findEmployee : findEmployees) {
            System.out.println("employee = " + findEmployee.getName());
            System.out.println("department name = " + findEmployee.getDepartment().getName());
        }
    }

}




































