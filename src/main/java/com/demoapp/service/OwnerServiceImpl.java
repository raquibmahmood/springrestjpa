package com.demoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demoapp.model.Owner;
import com.demoapp.repositories.OwnerRepository;

@Component
@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository; 
	
	@Override
	public List<Owner> findAll() throws Exception{
		Iterable<Owner> iterable = ownerRepository.findAll();
		List<Owner> owners = new ArrayList<Owner>();
		for (Owner owner : iterable) {
			owners.add(owner);
		}
		return owners;
	}

	@Override
	public void createOwner(Owner owner) throws Exception{
		// TODO Auto-generated method stub
		ownerRepository.save(owner);
	}

}
