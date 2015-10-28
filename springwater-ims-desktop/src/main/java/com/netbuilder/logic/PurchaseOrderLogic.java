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

import javax.swing.JFrame;
import javax.swing.JOptionPane;




import com.netbuilder.JMS.Sender;
import connections.MongoPull;
import loaders.ItemLoader;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import loaders.PurchaseOrderStatusLoader;
import loaders.SupplierLoader;
import entities.Item;
import entities.MessageContent;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import entities.PurchaseOrderStatus;
import entities.Supplier;

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
				MongoPull mP = new MongoPull();
				itemList = mP.getItemAsArrayList(pOLList.get(j).getItemID());
				float itemPrice;
				if (!itemList.isEmpty()) {
					itemPrice = itemList.get(0).getCost();
				}
				else {
					itemPrice = 30;
				}
				total = total + (pOLList.get(j).getQuantity() * itemPrice);
			}
			purchaseOrderList[i][0] = pOList.get(i).getIDPurchaseOrder();
			purchaseOrderList[i][1] = df.format(pOList.get(i).getDatePlaced()); 
			purchaseOrderList[i][2] = pOList.get(i).getPurchaseOrderStatus().getPurchOrderStatus(); 
			purchaseOrderList[i][3] = pOList.get(i).getSupplier().getSupplierName();
			purchaseOrderList[i][4] = "£" + formatter.format(total);
		}
	}
	
	/**
	 * Method to add an item to a purchase order
	 * @param item to add to the purchase order
	 * @param quantityAdd quantity to add to the purchase order
	 */
	public void addItemToPurchaseOrder(Item item, int quantityAdd) {
		ArrayList<Object> messageList = new ArrayList<Object>();
		messageList.add(item);
		messageList.add(quantityAdd);
		MessageContent messageContent = new MessageContent(messageList, "addItemToPurchaseOrder");
		Sender sender = new Sender();
		sender.sendMessage(messageContent);
//		ArrayList<PurchaseOrder> itemPurchaseOrderList = new ArrayList<PurchaseOrder>();
//		PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
//		itemPurchaseOrderList = pOLoader.getPurchaseOrderListByItemValid(item);
//		//if no valid pending purchase order to attach item to
//		if (itemPurchaseOrderList.isEmpty()) {
//			PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
//			SupplierLoader sLoader = new SupplierLoader();
//			ArrayList<Supplier> supplierList= new ArrayList<Supplier>();
//			supplierList = sLoader.getSupplierListByID(item.getIdSupplier());
//			Supplier supplier;
//			if (!supplierList.isEmpty()) {
//				supplier = supplierList.get(0);
//			}
//			else {
//				supplier = null;
//			}
//			PurchaseOrder pO = new PurchaseOrder(pOSLoader.getPurchaseOrderStatus(1), supplier);
//			pOLoader.createPurchaseOrder(pO);
//			PurchaseOrderLine pOL = new PurchaseOrderLine(quantityAdd, item.getIdItem(), pO);
//			pOLLoader.createPurchaseOrderLine(pOL);
//		}
//		// If valid pending purchase to attach item to exists
//		else {
//			pOLList = pOLLoader.getPurchaseOrderLineByOrderID(itemPurchaseOrderList.get(0).getIDPurchaseOrder());
//			boolean lineFound = false;
//			PurchaseOrderLine pOL = null;
//			for (int i = 0; i < pOLList.size(); i++){
//				if (pOLList.get(i).getItemID() == item.getIdItem()) {
//					pOL = pOLList.get(i);
//					lineFound = true;
//				}
//			}
//			//if item is not already on the purchase order
//			if (!lineFound) {
//				pOL = new PurchaseOrderLine(quantityAdd, item.getIdItem(), itemPurchaseOrderList.get(0));
//				pOLLoader.createPurchaseOrderLine(pOL);
//			}
//			//if item is already on the purchase order
//			else {
//				pOL.setQuantity((pOL.getQuantity() + quantityAdd));
//				pOLLoader.setPurchaseOrderLineStock(pOL);
//			}
//		}
	}
	
	/**
	 * Method to update the status of a purchase order
	 * @param pO purchase order being updated
	 * @param employeeID ID of the currently active employee
	 */
	public void updatePurchaseOrderStatus (PurchaseOrder pO, int employeeID) {
		PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
		//update order from pending to sent
		if (pO.getPurchaseOrderStatus().getStatusID() == 1) {
			//TODO get current employee and set on purchase order
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(2);
			pO.setPurchaseOrderStatus(pOS);
			
		}
		//update order from sent to received
		else if (pO.getPurchaseOrderStatus().getStatusID() == 2) {
			//TODO get current employee and set on purchase order
			PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
			ItemLoader iLoader = new ItemLoader();
			ArrayList<PurchaseOrderLine> pOLList = pOLLoader.getPurchaseOrderLineByOrderID(pO.getIDPurchaseOrder());
			//go through each item in purchase order to record damaged stock and update order line
			for (int i = 0; i < pOLList.size(); i++) {
				ArrayList<Item> itemList = iLoader.loadItemByID(pOLList.get(i).getItemID());
				String [] totalDelivered = new String [pOLList.get(i).getQuantity() + 1];
				for (Integer j = 0; j < totalDelivered.length; j++) {
					totalDelivered[j] = j.toString();
				}
				JFrame frame = new JFrame();
				String s = (String)JOptionPane.showInputDialog(frame, "Please select the number of broken instances of " + itemList.get(0).getItemName(), "Broken Item Entry", JOptionPane.PLAIN_MESSAGE, null, totalDelivered, "0");
				pOLList.get(i).setDamagedQuantity(Integer.parseInt(s));
				pOLLoader.setPurchaseOrderLineStock(pOLList.get(i));
			}
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(3);
			pO.setPurchaseOrderStatus(pOS);
		}
		//update order from received to stored
		else if (pO.getPurchaseOrderStatus().getStatusID() == 3) {
			//TODO get current employee and set on purchase order
			PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
			ItemLoader iLoader = new ItemLoader();
			ArrayList<PurchaseOrderLine> pOLList = pOLLoader.getPurchaseOrderLineByOrderID(pO.getIDPurchaseOrder());
			for (int i = 0; i < pOLList.size(); i++) {
				ArrayList<Item> itemList = iLoader.loadItemByID(pOLList.get(i).getItemID());
				int newStock = itemList.get(0).getStock() + pOLList.get(i).getQuantity() - pOLList.get(i).getDamagedQuantity();
				itemList.get(0).setStock(newStock);
				//TODO write updated item to MongoDB
			}
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(4);
			pO.setPurchaseOrderStatus(pOS);
		}
		else {
			//TODO manage case where status cannot be updated further
		}
		pOLoader.setPurchaseOrder(pO);
	}
	
	/**
	 * Method to set a purchase order to be cancelled
	 * @param pO purchase order to be cancelled
	 * @param employeeID ID of the currently active employee
	 */
	public void cancelPurchaseOrder (PurchaseOrder pO, int employeeID) {
		PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
		if (pO.getPurchaseOrderStatus().getStatusID() != 4) {
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(2);
			pO.setPurchaseOrderStatus(pOS);
			pOLoader.setPurchaseOrder(pO);
		}
		else {
			//TODO manage case where order cannot be cancelled
		}
	}
}
