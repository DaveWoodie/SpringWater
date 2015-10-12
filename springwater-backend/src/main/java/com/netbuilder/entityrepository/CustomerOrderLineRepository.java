package com.netbuilder.entityrepository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;

/**
 * Interface to hold the find methods for customer order line
 * 
 * @author cboucher
 * @date 07/10/2015
 */
public interface CustomerOrderLineRepository extends
		CrudRepository<CustomerOrderLine, Integer> {
	public List<CustomerOrder> findByID(int id);

}