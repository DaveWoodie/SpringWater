/**
 * @author dwoodward
 * @date 07/10/2015
 */
package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.PurchaseOrderStatus;

public interface PurchaseOrderStatusRepository extends CrudRepository<PurchaseOrderStatus, Integer> {

	public PurchaseOrderStatus findByID (int i);
	public PurchaseOrderStatus findByStatus (String s);
}
