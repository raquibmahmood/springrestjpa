package com.demoapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.model.Company;
import com.demoapp.service.CompanyService;



@RestController
public class CompanyController {
	
	private Logger log = Logger.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/company/", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> listAllCompany() {
		List<Company> companies = companyService.findAllCompanys();	
		if(companies.isEmpty()){
			return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
		}
			
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/company/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Company company) {
		log.debug("Creating company " + company.getName());
		
		try {
			company = companyService.saveCompany(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		
		log.debug(company.toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "Application/json");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompany(@PathVariable("id") Long id) {

		Company company = companyService.findById(id);
		if (company == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
				
		Company currentCompany = companyService.findById(id);
		
		if (currentCompany==null) {
			System.out.println("No compnay found with this id: "+id);
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
						
		currentCompany.setCompanyId(id);
		currentCompany.setName(company.getName());
		currentCompany.setAddress(company.getAddress());		
		currentCompany.setCountry(company.getCountry());
		currentCompany.setEmail(company.getEmail());
		currentCompany.setPhone(company.getPhone());
		currentCompany.setOwners(company.getOwners());
		System.out.println("Company after update: "+currentCompany.toString());
		try {
			currentCompany =  companyService.saveCompany(currentCompany);
		} catch (Exception e) {
			log.error(e);
		}
		return new ResponseEntity<Company>(currentCompany, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteCompany(@PathVariable("id") Long id) {
		System.out.println("Fetching & Deleting Company with id " + id);

		Company Company = companyService.findById(id);
		if (Company == null) {
			System.out.println("Unable to delete. Company with id " + id + " not found");
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}

		try {
			companyService.deleteCompanyById(id);
		} catch (Exception e) {
			log.error(e);
		}
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

	

	
	@RequestMapping(value = "/company/", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteAllCompanys() {
		System.out.println("Deleting All Companys");

		try {
			companyService.deleteAllCompanies();
		} catch (Exception e) {
			log.error(e);
		}
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

}
