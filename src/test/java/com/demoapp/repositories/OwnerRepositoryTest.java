package com.demoapp.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demoapp.model.Owner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class OwnerRepositoryTest {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Test
	public void saveOwnerTest(){
		Owner owner = new Owner();
		owner.setOwnerName("owner1");
		ownerRepository.save(owner);
	}	
}
