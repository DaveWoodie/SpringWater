/**
 * @author dwoodward
 * @date 07/10/2015
 */
package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.CustomerOrderStatus;

@Repository
public interface CustomerOrderStatusRepository extends CrudRepository<CustomerOrderStatus, Integer> {
	public CustomerOrderStatus findByID (int i);
	public CustomerOrderStatus findByStatus (String s);
}