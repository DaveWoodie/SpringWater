package com.netbuilder.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.netbuilder.entities.CustomerOrder;

/**
 * Interface to hold the find methods for customer order line
 * 
 * @author cboucher
 * @date 07/10/2015
 */

public interface CustomerOrderLineRepository {
	public List<CustomerOrder> findByID(int id);
}