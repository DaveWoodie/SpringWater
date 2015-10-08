/**
 * @author ccooper
 * @date 07/10/2015
 */
package com.netbuilder.entityrepository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.netbuilder.entities.WishListLine;
import com.netbuilder.entities.Customer;

/**
 * 
 * Interface to hold the find the wish list lines
 */
public interface WishListLineRepository extends MongoRepository<WishListLine, Integer>{
	
	public List<WishListLine> findByCustomer(Customer c);
}
