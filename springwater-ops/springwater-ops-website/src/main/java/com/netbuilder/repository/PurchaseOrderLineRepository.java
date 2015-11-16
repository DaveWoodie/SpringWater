package com.netbuilder.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.netbuilder.entities.PurchaseOrder;

/**
 * Interface to hold the find methods for purchase order line
 * 
 * @author cboucher
 * @date 07/10/2015
 */

public interface PurchaseOrderLineRepository {
	public List<PurchaseOrder> findByID(int id);
}