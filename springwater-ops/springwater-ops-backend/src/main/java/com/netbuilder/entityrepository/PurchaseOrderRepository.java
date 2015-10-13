package com.netbuilder.entityrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderStatus;
import com.netbuilder.entities.Supplier;

/**
 * Repository containing CRUD methods for the PurchaseOrder entity
 * @author jforster
 *
 */
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer>{
	
	public PurchaseOrder findbyPurchaseOrderID(int pOID);
	
	public List<PurchaseOrder> findByStatus(PurchaseOrderStatus pOS);
	public List<PurchaseOrder> findByEmployee(Employee e);
	public List<PurchaseOrder> findBySupplier(Supplier s);
	public List<PurchaseOrder> findByDateExpected(Date dE);
	public List<PurchaseOrder> findByItem(Item i);
}