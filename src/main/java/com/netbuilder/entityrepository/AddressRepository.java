package com.netbuilder.entityrepository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.netbuilder.entities.Address;

/**
 * Mongo repository for Addresses
 * @author tstacey
 * @date 07/10/2015
 */
public interface AddressRepository extends MongoRepository<Address, Integer> {

	public Address findOneByID(int addressID);
	
}
