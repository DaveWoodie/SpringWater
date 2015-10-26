/**
 * @author abutcher
 * @date 26/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;

import com.netbuilder.entities.Supplier;
import com.netbuilder.loaders.SupplierLoader;

public class SupplierLogic {	
	private Object[][] supplierList;
	SupplierLoader sLoader = new SupplierLoader();
	private ArrayList<Supplier> sList;

	/**
	 * Method to load and format the entities for the GUI for all Suppliers
	 * @return the array of data to be displayed by the GUI
	 */
	public Object [][] fetchSuppliers() {
		sList = new ArrayList<Supplier>(sLoader.getSupplierList());
		
		formatTable();
		
		return supplierList;
	}

	/**
	 * Method to load and format the entity of a single supplier for the GUI
	 * @param id of the supplier to be displayed
	 * @return the array of data to display the supplier in the GUI
	 */
//	public Object[][] fetchPurchaseOrdersByID(int id) {
//		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderByID(id));
//		
//		formatTable();
//		
//		return purchaseOrderList;
//	}
	
	/**
	 * Method to format the purchase order entities' data into a format for the GUI
	 */
	private void formatTable() {
		supplierList = new Object[sList.size()][2];
		for (int i = 0; i < sList.size(); i++) {
			supplierList[i][0] = sList.get(i).getSupplierID();
			supplierList[i][1] = sList.get(i).getSupplierName();
		}
		
	}
}
