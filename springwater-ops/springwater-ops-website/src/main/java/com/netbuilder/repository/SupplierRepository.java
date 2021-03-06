package com.netbuilder.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.netbuilder.entities.Supplier;

/**
 * 
 * Repository for the Supplier entity
 * @author tstacey
 * @date 07/10/2015
 */

/**#
 * Modified to change the naming convention slightly.
 * @author dwoodward
 *
 */

public interface SupplierRepository extends CrudRepository<Supplier, String> {
	public Supplier findSupplierByName(String supplierName);
}