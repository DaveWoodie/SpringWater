/**
 * @author jforster
 * @date 21/10/15
 */
package com.netbuilder.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.netbuilder.apploader.PurchaseOrderLoader;
import com.netbuilder.entities.PurchaseOrder;

/**
 * Class to manage the logic and business rules for the application
 * @author jforster
 *
 */
public class PurchaseOrderLogic {
	
	Object [][] purchaseOrderList;
	Object [] purchaseOrder;
	PurchaseOrderLoader pOLoader;
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	ArrayList<PurchaseOrder> pOList;
	
	/**
	 * Method to load and format the entities for the GUI for all purchase orders
	 * @return the array of data to be displayed by the GUI
	 */
	public Object [][] fetchPurchaseOrders() {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderList());
		
		formatTable();
		
		return purchaseOrderList;
	}
	
	/**
	 * Method to load and format the entity of a single purchase order for the GUI
	 * @param id of the purchase order to be displayed
	 * @return the array of data to display the purchase order in the GUI
	 */
	public Object[] fetchPurchaseOrdersByID(int id) {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderByID(id));
		float total = 3160;
		//TODO connect to OrderLineLoader and ItemLoader to calculate price
		purchaseOrder = new Object [5];
		purchaseOrder[0] = pOList.get(0).getIDPurchaseOrder();
		purchaseOrder[1] = df.format(pOList.get(0).getDatePlaced());
		purchaseOrder[2] = pOList.get(0).getPurchaseOrderStatus().getPurchOrderStatus(); 
		purchaseOrder[3] = pOList.get(0).getSupplier().getSupplierName();
		purchaseOrder[4] = "£" + total;
		
		return purchaseOrder;
	}
	
	/**
	 * Method to load and format the entities for the GUI for all purchase orders of a specific status
	 * @param status of the purchase order to be searched for
	 * @return the array of data to be displayed by the GUI
	 */
	public Object [][] fetchPurchaseOrdersByStatus(String status) {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderListByStatus(status));
	
		formatTable();
		
		return purchaseOrderList;
	}
	
	/**
	 * Method to load and format the entities for the GUI for all purchase orders of a specific supplier
	 * @param supplier name of the supplier to be searched for
	 * @return the array of data to be displayed by the GUI
	 */
	public Object [][] fetchPurchaseOrdersBySupplier(String supplier) {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderListBySupplier(supplier));
		
		formatTable();
		
		return purchaseOrderList;
	}
	
	/**
	 * Method to load and format the entities for the GUI for all purchase orders containing a specific item
	 * @param id of the item to be searched for
	 * @return the array of data to be displayed by the GUI
	 */
	public Object [][] fetchPurchaseOrdersByItem(int id) {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderListByItem(id));
		
		formatTable();
		
		return purchaseOrderList;
	}
	
	/**
	 * Method to format the purchase order entities' data into a format for the GUI
	 */
	public void formatTable() {
		purchaseOrderList = new Object [pOList.size()][5];
		for (int i = 0; i < pOList.size(); i++) {
			//TODO connect to OrderLineLoader and ItemLoader to calculate price
			float total = 3160;
			purchaseOrderList[i][0] = pOList.get(i).getIDPurchaseOrder();
			purchaseOrderList[i][1] = df.format(pOList.get(i).getDatePlaced()); 
			purchaseOrderList[i][2] = pOList.get(i).getPurchaseOrderStatus().getPurchOrderStatus(); 
			purchaseOrderList[i][3] = pOList.get(i).getSupplier().getSupplierName();
			purchaseOrderList[i][4] = "£" + total;
		}
	}
}
