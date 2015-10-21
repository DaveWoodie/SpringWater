package com.netbuilder.entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderLine;

/**
 * Interface to hold the find methods for purchase order line
 * 
 * @author cboucher
 * @date 07/10/2015
 */

@Repository
public interface PurchaseOrderLineRepository extends CrudRepository<PurchaseOrderLine, Integer> {
	public List<PurchaseOrder> findByID(int id);
}