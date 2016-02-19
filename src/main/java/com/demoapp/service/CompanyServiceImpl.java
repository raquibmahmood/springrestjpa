package com.demoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.demoapp.model.Company;
import com.demoapp.repositories.CompanyRepository;

@Component
@Service("companyService")
@EnableTransactionManagement
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return companyRepository.findOne(id);
	}

	@Override
	public Company findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Company saveCompany(Company company) throws Exception{
		return companyRepository.save(company);
	}

	@Override
	@Transactional
	public Company updateCompany(Company company) throws Exception{
		// TODO Auto-generated method stub				
		return companyRepository.save(company);
	}

	@Override
	public void deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		companyRepository.delete(id);
	}

	@Override
	public List<Company> findAllCompanys() {
		Iterable<Company> iter =  companyRepository.findAll();
		List<Company> companyList = new ArrayList<Company>();
		for (Company company : iter) {
			companyList.add(company);
		}
		return companyList;
	}
	

	@Override
	public void deleteAllCompanies() throws Exception {
		// TODO Auto-generated method stub
		companyRepository.deleteAll();
	}
	
	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
}
