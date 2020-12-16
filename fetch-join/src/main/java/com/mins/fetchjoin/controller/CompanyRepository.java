package com.mins.fetchjoin.controller;

import com.mins.fetchjoin.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
