package com.netbuilder.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
import com.netbuilder.entities.WishList;

/**
 * Interface to hold the find the wish list lines
 * @author ccooper
 * @date 07/10/2015
 */

public interface WishListRepository {
	public WishList findByCustomerID(int customerID);
}