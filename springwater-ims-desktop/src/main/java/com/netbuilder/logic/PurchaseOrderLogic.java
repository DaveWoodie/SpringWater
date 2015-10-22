/**
 * @author jforster
 * @date 21/10/15
 */
package com.netbuilder.logic;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.netbuilder.DBConnector.MongoPull;
import com.netbuilder.apploader.PurchaseOrderLineLoader;
import com.netbuilder.apploader.PurchaseOrderLoader;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderLine;

/**
 * Class to manage the logic and business rules for the application
 * @author jforster
 *
 */
public class PurchaseOrderLogic {
	
	Object [][] purchaseOrderList;
	PurchaseOrderLoader pOLoader = new PurchaseOrderLoader();
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
	ArrayList<PurchaseOrder> pOList;
	ArrayList<PurchaseOrderLine> pOLList;
	ArrayList<Item> itemList;
	
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
	public Object[][] fetchPurchaseOrdersByID(int id) {
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderByID(id));
		
		formatTable();
		
		return purchaseOrderList;
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
	
	public Object[][] fetchPurchaseOrdersByDate(Date date){
		pOList = new ArrayList<PurchaseOrder>(pOLoader.getPurchaseOrderListByDate(date));
		
		formatTable();
		
		return purchaseOrderList;
	}
	/**
	 * Method to format the purchase order entities' data into a format for the GUI
	 */
	private void formatTable() {
		purchaseOrderList = new Object [pOList.size()][5];
		for (int i = 0; i < pOList.size(); i++) {
			PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
			pOLList = pOLLoader.getPurchaseOrderLineByOrderID(pOList.get(i).getIDPurchaseOrder());
			NumberFormat formatter = new DecimalFormat("#0.00"); 
			float total = 0;
			for (int j = 0; j < pOLList.size(); j++) {
//				MongoPull mP = new MongoPull();
//				itemList = mP.getItemInf(pOLList.get(j).getItemID());
				
//				float itemPrice = itemList.get(0).getCost();
				float itemPrice = 30;
				total = total + (pOLList.get(j).getQuantity() * itemPrice);
			}
			purchaseOrderList[i][0] = pOList.get(i).getIDPurchaseOrder();
			purchaseOrderList[i][1] = df.format(pOList.get(i).getDatePlaced()); 
			purchaseOrderList[i][2] = pOList.get(i).getPurchaseOrderStatus().getPurchOrderStatus(); 
			purchaseOrderList[i][3] = pOList.get(i).getSupplier().getSupplierName();
			purchaseOrderList[i][4] = "£" + formatter.format(total);
		}
	}
}
