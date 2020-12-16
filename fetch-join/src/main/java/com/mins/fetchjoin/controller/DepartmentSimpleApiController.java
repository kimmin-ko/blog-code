package com.mins.fetchjoin.controller;

import com.mins.fetchjoin.entity.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DepartmentSimpleApiController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentQueryRepository departmentQueryRepository;

    /**
     * X To One (X대일)
     * Department -> Company
     */

    @GetMapping("/v1/departments")
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

}
