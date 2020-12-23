package com.mins.fetchjoin.employee;

import com.mins.fetchjoin.department.DepartmentRepository;
import com.mins.fetchjoin.entity.Department;
import com.mins.fetchjoin.entity.Employee;
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
        for (int i = 0; i < 50; i++) {
            employeeRepository.save(new Employee("직원" + (i + 1), findDepartments.get(i % 10)));
        }

        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("X To One 관계에서 지연 로딩으로 조회하기")
    void v1() {
        List<Employee> findEmployees = employeeRepository.findAll();

        // 조회한 Employee의 Department는 Proxy 객체로 저장됩니다.
        System.out.println("getDepartment().getClass() = " + findEmployees.get(0).getDepartment().getClass());

        for (Employee findEmployee : findEmployees) {
            // Department Proxy 객체 생성
            System.out.println("findEmployee = " + findEmployee.getName());

            // id를 조회할 땐 지연로딩이 발생하지 않음
            System.out.println("findEmployee.getDepartment().getId() = " + findEmployee.getDepartment().getId());

            // 지연 로딩 발생 !!!!!
            System.out.println("findEmployee.getDepartment().getName() = " + findEmployee.getDepartment().getName());
        }
    }

    @Test
    @DisplayName("X To One 관계에서 페치 조인으로 조회하기")
    void v2() {
        // 페치 조인으로 한번에 가져오기
        List<Employee> findEmployees = employeeRepository.findAllWithDepartment();

        for (Employee findEmployee : findEmployees) {
            System.out.println("findEmployee = " + findEmployee.getName());
            System.out.println("findEmployee.getDepartment().getName() = " + findEmployee.getDepartment().getName());
        }
    }

}




































