package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Supplier;
import entityrepository.SupplierRepository;

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
