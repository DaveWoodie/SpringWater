package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netbuilder.entities.Supplier;
import com.netbuilder.entityrepository.SupplierRepository;

public class SupplierController {

	private List<Supplier> suppliers;
	private Supplier singleSupplier;
	
	@Autowired
	SupplierRepository supplierRepository;
	ArrayList<Supplier> supplierList;
	
	public List<Supplier> getSuppliers() {
		suppliers = (List<Supplier>) supplierRepository.findAll();
		return suppliers;
	}
	
}
