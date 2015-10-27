package entitiyrepositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.CustomerOrder;
import entities.CustomerOrderLine;

/**
 * Interface to hold the find methods for customer order line
 * 
 * @author cboucher
 * @date 07/10/2015
 */

public interface CustomerOrderLineRepository {
	public List<CustomerOrder> findByID(int id);
}