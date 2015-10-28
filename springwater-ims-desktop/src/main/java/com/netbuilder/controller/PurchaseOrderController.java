/**
 * @author jforster
 * @date 20/10/2015
 */
package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Employee;
import entities.Item;
import entities.PurchaseOrder;
import entities.Supplier;
import entityrepository.PurchaseOrderRepository;

/**
 * Controller for the purchase order entities for the Java Application.
 * @author jforster
 *
 */
public class PurchaseOrderController {
	
	private PurchaseOrder purchaseOrder;
	//link to the purchase order repository
	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;
	ArrayList<PurchaseOrder> purchaseOrderList;
	
	/**
	 * Search function to find a specific purchase order for the individual order GUI
	 * @param id int to identify the purchase order
	 * @return a single PurchaseOrder object
	 */
	public PurchaseOrder getPurchaseOrder(int id) {
		purchaseOrder = purchaseOrderRepository.findbyPurchaseOrderID(id);
		return purchaseOrder;
	}
	
	/**
	 * Search function to find all purchase orders for the Purchase Orders GUI.
	 * @return an ArrayList of all PurchaseOrder objects
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseOrderRepository.findAll();
		return purchaseOrderList;
	}
	
	/**
	 * Search function to find all purchase orders that contain a specific item.
	 * @param item to search by 
	 * @return an ArrayList of all relevant PurchaseOrder objects
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderByItemID(Item item) {
		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseOrderRepository.findByItem(item);
		return purchaseOrderList;
	}
	
	/**
	 * Search function to find all purchase orders that are to a specific supplier.
	 * @param supplier to search by
	 * @return an ArrayList of all relevant PurchaseOrder objects
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderBySupplier (Supplier supplier) {
		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseOrderRepository.findBySupplier(supplier);
		return purchaseOrderList;
	}
	
	/**
	 * Search function to find all purchase orders that are to arrive on a specific date.
	 * @param dateExpected to search by
	 * @return an ArrayList of all relevant PurchaseOrder objects
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderByDateExpected (Date dateExpected) {
		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseOrderRepository.findByDateExpected(dateExpected);
		return purchaseOrderList;
	}
	
	/**
	 * Search function to find all purchase orders that are registered to a specific employee.
	 * @param employee to search by
	 * @return an ArrayList of all relevant PurchaseOrder objects
	 */
	public ArrayList<PurchaseOrder> getPurchaseOrderByEmployee (Employee employee) {
		purchaseOrderList = (ArrayList<PurchaseOrder>) purchaseOrderRepository.findByEmployee(employee);
		return purchaseOrderList;
	}
	
}
