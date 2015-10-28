/**
 * @author abutcher
 * @date 26/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;

import com.netbuilder.connections.MongoPull;
import com.netbuilder.connections.MongoPush;
import com.netbuilder.entities.Address;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.Supplier;
import com.netbuilder.loaders.AddressLoader;
import com.netbuilder.loaders.SupplierLoader;

public class SupplierLogic {	
	private Object[][] supplierList;
	private Object[][] pListArray ;
	SupplierLoader sLoader = new SupplierLoader();
	private ArrayList<Supplier> sList;
	private AddressLoader aL = new AddressLoader();
	private MongoPull mp = new MongoPull();
	private MongoPush push = new MongoPush();

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
	
	/**
	 * @author abutcher
	 * @param supplierID
	 * @return
	 */
	public Object [][] fetchProducts(int supplierID) {
		ArrayList<Item> pList = new ArrayList<Item>();
		pList = mp.getItemsBySupplier(supplierID, true);
		pListArray = new Object[pList.size()][2];
	
		for (int i=0 ;i<pList.size();i++) {
			pListArray[i][0] = pList.get(i).getIdItem();
			pListArray[i][1] = pList.get(i).getItemName();
		}
		return pListArray;
	}
	
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
	 * @author abutcher
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

	/**
	 * @author abutcher
	 * @param results
	 */
	public void addNewSupplier(String[] results) {
		Supplier newSP;
		Address address;
		int addressID;
		ArrayList <String> addressLines = new ArrayList<String>();
		
		//add new address
		for (int i = 6 ; i < results.length; i++) {
			addressLines.add(results[i]);
		}
		if (results[4].isEmpty()) {
			address = new Address(addressLines, results[3], results[5]);
		} else {
			address = new Address(addressLines, results[3], results[4], results[5]);
		}
		addressID = push.addAddress(address);
		
		//add new supplier
		newSP = new Supplier(results[0], addressID);
		newSP.setAverageDeliveryTime(0);
		if (!results[2].isEmpty()){
			newSP.setEmail(results[2]);
		}
		if (!results[1].isEmpty()){
			newSP.setTelephone(results[1]);
		}
		sLoader.newSupplier(newSP);
		
	}




}
