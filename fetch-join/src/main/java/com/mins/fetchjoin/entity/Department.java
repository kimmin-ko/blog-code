package com.mins.fetchjoin.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
    }
}