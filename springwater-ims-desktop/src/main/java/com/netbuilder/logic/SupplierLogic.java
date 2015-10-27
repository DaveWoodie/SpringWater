/**
 * @author abutcher
 * @date 26/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;

import com.netbuilder.connections.MongoPull;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.Supplier;
import com.netbuilder.loaders.AddressLoader;
import com.netbuilder.loaders.ItemLoader;
import com.netbuilder.loaders.SupplierLoader;

public class SupplierLogic {	
	private Object[][] supplierList;
	SupplierLoader sLoader = new SupplierLoader();
	private ArrayList<Supplier> sList;
	private AddressLoader aL = new AddressLoader();
	private ItemLoader iL = new ItemLoader();

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
	public Object[][] fetchSupplierByID(int id) {
		sList = new ArrayList<Supplier>(sLoader.getSupplierListByID(id));
		
		formatTable();
		
		return supplierList;
	}
	
	/**
	 * @author abutcher
	 * Method to load and format the entity of a single supplier by name for the GUI
	 * @param name of supplier to be displayed
	 * @return the array of data to display the supplier in the GUI
	 */
	public Object[][] fetchSupplierByName(String name) {
		sList = new ArrayList<Supplier>(sLoader.getSupplierListByName(name));
		
		formatTable();
		
		return supplierList;
	}
	
	/**
	 * @author abutcher
	 * Method to load and format the entity of a single supplier by product id for the GUI
	 * @param id of the product to find the supplier to be displayed
	 * @return the array of data to display the supplier in the GUI
	 */
	public Object[][] fetchSupplierByProductID(String id) {
		sList = new ArrayList<Supplier>(sLoader.getSupplierListByProductID((Integer.parseInt(id))));
		
		formatTable();
		
		return supplierList;
	}
	
//	/**
//	 * @author abutcher
//	 * @param supplierID
//	 * @return
//	 */
//	public Object [][] fetchProducts(int supplierID) {
//		///TODO
//		ArrayList<Item> pList = new ArrayList<Item>();
//		iL.loadItemByID(supplierID);
//	}
	
	/**
	 * @author abutcher
	 * @param supplierDetails
	 * @return
	 */
	public ArrayList<String> getAddress(int supplierDetails) {
		ArrayList<String> address = new ArrayList<String>();
		Address a = aL.loadAddressByID(supplierDetails).get(0);
		for (String s:a.getAddressLines()) {
			address.add(s);
		}
		
		address.add(a.getCity());
		if(a.getCounty().isEmpty()) {
			address.add(a.getCounty());
		}
		address.add(a.getPostCode());
		return address;
	}
	
	/**
	 * Method to format the purchase order entities' data into a format for the GUI
	 */
	private void formatTable() {
		supplierList = new Object[sList.size()][7];
		for (int i = 0; i < sList.size(); i++) {
			supplierList[i][0] = sList.get(i).getSupplierID();
			supplierList[i][1] = sList.get(i).getSupplierName();
			supplierList[i][2] = sList.get(i).getTelephone();
			supplierList[i][3] = sList.get(i).getEmail();
			supplierList[i][4] = sList.get(i).getAddressID();
			supplierList[i][5] = sList.get(i).getAverageDeliveryTime();
			supplierList[i][6] = "placeholder.png";
		}
		
	}




}
