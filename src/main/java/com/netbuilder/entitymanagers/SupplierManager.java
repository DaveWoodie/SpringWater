package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.Supplier;

/**
 * Interface for the supplier entity
 * @author tstacey
 *
 */
public interface SupplierManager {
	
	//CREATE
	public void persistSupplier(Supplier s);
	public void persistSuppliers(List<Supplier> supplierList);
	
	//READ
	public Supplier findByID(int supplierID);
	public Supplier findByName(String supplier);
	public List<Supplier> getSupplierList();
	
	//UPDATE
	public void updateSupplier(Supplier s);
	
	//DELETE
	public void removeSupplier(Supplier s);
}
