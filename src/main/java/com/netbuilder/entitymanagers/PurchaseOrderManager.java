package com.netbuilder.entitymanagers;

import java.util.Date;
import java.util.List;

import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderStatus;
import com.netbuilder.entities.Supplier;

public interface PurchaseOrderManager {
	//CREATE
	public void persistPurchaseOrder (PurchaseOrder pO);
	public void persistPurchaseOrders (List<PurchaseOrder> pO);
	
	//READ
	public PurchaseOrder findbyID(int pID);
	public List<PurchaseOrder> getPurchaseOrders();
	public List<PurchaseOrder> findByStatus(int pOS);
	public List<PurchaseOrder> findByEmployee(Employee e);
	public List<PurchaseOrder> findBySupplier(Supplier s);
	public List<PurchaseOrder> findByItem(Item i);
	
	//UPDATE
	public void updateDateExpected(Date dE);
	public void updatePurchaseOrderStatus(PurchaseOrderStatus pOS);
	public void updateEmployee(Employee e);
	
	//DELETE
	//Do not delete orders from record
}
