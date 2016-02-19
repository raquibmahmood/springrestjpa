package com.demoapp.service;

import java.util.List;

import com.demoapp.model.Owner;

public interface OwnerService {
	
	public List<Owner> findAll()throws Exception;
	public void createOwner(Owner owner)throws Exception;
	public void deleteAllOwner()throws Exception;

}
