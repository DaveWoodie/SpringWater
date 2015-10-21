package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.PurchaseOrderStatus;

/**
 * @author dwoodward
 * @date 07/10/2015
 */

@Repository
public interface PurchaseOrderStatusRepository extends CrudRepository<PurchaseOrderStatus, Integer> {
	public PurchaseOrderStatus findByID (int i);
	public PurchaseOrderStatus findByStatus (String s);
}