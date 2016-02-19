package com.demoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.model.Owner;
import com.demoapp.service.OwnerService;

@RestController
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@RequestMapping(value = "/owner/", method = RequestMethod.GET)
	public ResponseEntity<List<Owner>> listAllUsers() {
		List<Owner> owners = null;
		try{			
			owners = ownerService.findAll();
			if(owners.isEmpty()){
				return new ResponseEntity<List<Owner>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			}		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}			
		
		return new ResponseEntity<List<Owner>>(owners, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/owner/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Owner owner) {
		
		
		try {
			ownerService.createOwner(owner);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "Application/json");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/owner/" ,method = RequestMethod.DELETE)
	public ResponseEntity<Owner> deleteAll(){
		
		try {
			ownerService.deleteAllOwner();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Owner>(HttpStatus.NO_CONTENT);
	}
}
