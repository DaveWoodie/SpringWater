/**
 * @author jforster
 * @date 22/10/15
 */
package com.netbuilder.logic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.netbuilder.DBConnector.MongoPull;
import com.netbuilder.apploader.PurchaseOrderLineLoader;
import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrderLine;

/**
 * Class to manage the logic and business rules for the application
 * @author jforster
 *
 */
public class PurchaseOrderLineLogic {
	
	Object[][] purchaseOrderLineList;
	PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
	ArrayList<PurchaseOrderLine> pOLList;
	ArrayList<Item> itemList;
	
	/**
	 * Method to format the purchase order line entities's data into a format for the GUI
	 */
	private void formatTable() {
		purchaseOrderLineList = new Object [pOLList.size()][5];
		for (int i = 0; i < pOLList.size(); i++) {
			MongoPull mP = new MongoPull();
			itemList = mP.getItemInf(pOLList.get(i).getItemID());
			float itemPrice = 0;
			String itemName = "Placeholder";
			if (!itemList.isEmpty()) {
				itemPrice = itemList.get(0).getCost();
				itemName = itemList.get(0).getItemName();
			}
			else {
				itemPrice = 0;
				itemName = "Failed";
			}
			
			NumberFormat formatter = new DecimalFormat("#0.00"); 
			float subTotal = pOLList.get(i).getQuantity() * itemPrice;
			purchaseOrderLineList[i][0] = pOLList.get(i).getItemID();
			purchaseOrderLineList[i][1] = itemName;
			purchaseOrderLineList[i][2] = pOLList.get(i).getQuantity();
			purchaseOrderLineList[i][3] = pOLList.get(i).getDamagedQuantity();
			purchaseOrderLineList[i][4] = "£" + formatter.format(subTotal);
		}
	}
	
	/**
	 * Method to load and format the entities for the GUI for all purchase order lines within an order
	 * @param id of the purchase order to be searched for
	 * @return the array of data to be displayed by the GUI
	 */
	public Object[][] fetchPurchaseOrderLinesByPurchaseOrderID(int id) {
		pOLList = new ArrayList<PurchaseOrderLine>(pOLLoader.getPurchaseOrderLineByOrderID(id));
		
		formatTable();
		
		return purchaseOrderLineList;
	}
	
}
