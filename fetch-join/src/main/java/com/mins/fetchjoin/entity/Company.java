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
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company")
    private List<Department> departments = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }
}