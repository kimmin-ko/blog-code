package com.mins.fetchjoin.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<Department> departments = new ArrayList<>();

}