package com.demoapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

}
