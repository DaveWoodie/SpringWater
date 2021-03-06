package com.netbuilder.repository;


//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;

import com.netbuilder.entities.Address;

/**
 * Mongo repository for Addresses
 * @author tstacey
 * @date 07/10/2015
 */

public interface AddressRepository {
	
	// READ
	public Address findOneByID(int addressID);
	
	// DELETE
	public void removeAddress(int addressID);
	
	
	
}
