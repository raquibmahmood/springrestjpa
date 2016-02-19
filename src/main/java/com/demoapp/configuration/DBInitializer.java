package com.demoapp.configuration;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.demoapp.model.Owner;
import com.demoapp.repositories.CompanyRepository;
import com.demoapp.repositories.OwnerRepository;

@Component
public class DBInitializer implements ApplicationListener<ContextRefreshedEvent>{

	private Logger log = Logger.getLogger(DBInitializer.class);
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		Owner owner = new Owner();
		owner.setOwnerName("Owner 1");
		ownerRepository.save(owner);
		
		log.debug("Owner id: "+owner.getOwnerId());
		
		Owner owner1 = new Owner();
		owner1.setOwnerName("Owner 2");
		ownerRepository.save(owner1);
		
		log.debug("Owner id: "+owner1.getOwnerId());
		
		Set<Owner> owners = new HashSet<Owner>();
		owners.add(owner);
				
//		Company c = new Company();
//		c.setCompanyId(1L);
//		c.setName("Grameen");
//		c.setCity("Dhaka");
//		c.setAddress("Dhaka");
//		c.setPhone("7884415");
//		c.setCountry("Bnagladesh");		
//		c.setOwners(owners);
//		companyRepository.save(c);
//		companyRepository.deleteAll();
	}
	
	
}
