package com.netbuilder.entityrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.Supplier;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer>{
	
	public PurchaseOrder findbyID(int pID);
	
	public List<PurchaseOrder> findByStatus(int pOS);
	public List<PurchaseOrder> findByEmployee(Employee e);
	public List<PurchaseOrder> findBySupplier(Supplier s);
	public List<PurchaseOrder> findByDateExpected(Date dE);
	public List<PurchaseOrder> findByItem(Item i);
}
