package com.mins.fetchjoin.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

}