package com.mins.fetchjoin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DepartmentQueryRepository {

    private final EntityManager em;



}
