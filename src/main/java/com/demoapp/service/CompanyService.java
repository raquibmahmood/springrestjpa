package com.demoapp.service;

import java.util.List;

import com.demoapp.model.Company;



public interface CompanyService {
	
	Company findById(Long id);
	
	Company findByName(String name);
	
	Company saveCompany(Company Company)throws Exception;
	
	Company updateCompany(Company Company)throws Exception;
	
	void deleteCompanyById(Long id) throws Exception;
	
	void deleteAllCompanies()throws Exception;

	List<Company> findAllCompanys(); 

}
