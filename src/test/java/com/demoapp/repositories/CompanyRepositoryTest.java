package com.demoapp.repositories;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demoapp.model.Company;
import com.demoapp.model.Owner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository companyRepository;

	@Test
	public void addCompanyTest(){
		
		Company c = new Company();
		c.setName("Grameen Communication");
		c.setCity("Dhaka");
		c.setAddress("Mirpur");
		c.setPhone("7884415");
		c.setCountry("Bnagladesh");
		Owner owner = new Owner();
		owner.setOwnerName("Owner 1");
		Set<Owner> owners = new HashSet<Owner>();
		owners.add(owner);
		c.setOwners(owners);
		try{
		c = companyRepository.save(c);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(c.toString());
		Iterable<Company> iter =  companyRepository.findAll();
		int count = 0;
		for (Company company : iter) {
			count++;
			System.out.println("Company name: "+company.getName());
		}
        //assertEquals(count, 1);
	}
		
}
