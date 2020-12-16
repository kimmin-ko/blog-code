package com.mins.fetchjoin.controller;

import com.mins.fetchjoin.entity.Company;
import com.mins.fetchjoin.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Rollback(false)
class DepartmentRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager em;

    @Test
    void save() {
        // given
        Company kakao = new Company("Kakao");
        Company naver = new Company("Naver");
        companyRepository.save(kakao);
        companyRepository.save(naver);

        Department kakaoDevelopment = new Department("Development", kakao);
        Department kakaoDesign = new Department("Design", kakao);
        Department naverPlanning = new Department("Planning", naver);

        // when

        // then

    }

}