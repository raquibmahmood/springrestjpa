package com.demoapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demoapp.model.Owner;


public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
