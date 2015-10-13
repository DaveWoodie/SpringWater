package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.Supplier;

/**
 * 
 * Repository for the Supplier entity
 * @author tstacey
 * @date 07/10/2015
 */
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
	public Supplier findOneByName(String supplierName);
}