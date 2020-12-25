package com.mins.fetchjoin.employee;

import com.mins.fetchjoin.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    private final EntityManager em;

    public List<Employee> findAllWithDepartment() {
        return em.createQuery(
                "select e from Employee e" +
                        " join fetch e.department d", Employee.class)
                .getResultList();
    }

}