package com.netbuilder.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.netbuilder.entities.Item;

/**
 * Repository containing CRUD methods for the Item entity
 * @author jforster
 * @date 07/10/2015
 */

public interface ItemRepository extends MongoRepository<Item, String> {
	public Item findByItemID (int iID);
	public List<Item> findByItemName (String name);
	public List<Item> findByDiscontinued (boolean discontinued);
	public List<Item> findByPorousware (boolean pW);
	public List<Item> findBySalesRate (double a);
}