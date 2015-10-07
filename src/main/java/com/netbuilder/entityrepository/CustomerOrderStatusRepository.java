/**
 * @author dwoodward
 * @date 07/10/2015
 */
package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.CustomerOrderStatus;

public interface CustomerOrderStatusRepository extends CrudRepository<CustomerOrderStatus, Integer> {

	public CustomerOrderStatus findByID (int i);
	public CustomerOrderStatus findByStatus (String s);
	
}
