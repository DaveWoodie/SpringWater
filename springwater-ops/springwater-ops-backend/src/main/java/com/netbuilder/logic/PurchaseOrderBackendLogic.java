/**
 * @author jforster
 * @date 28/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;












import com.netbuilder.JMS.Sender;

import connections.MongoPull;
import entities.Item;
import entities.MessageContent;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import entities.PurchaseOrderStatus;
import entities.Supplier;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import loaders.PurchaseOrderStatusLoader;
import loaders.SupplierLoader;


/**
 * Class to apply the business logic to the backend entities
 * @author jforster
 *
 */
public class PurchaseOrderBackendLogic {

	PurchaseOrderLoader pOLoader = new PurchaseOrderLoader();
	PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
	ArrayList<PurchaseOrderLine> pOLList;
	ArrayList<PurchaseOrder> pOList;
	
	/**
	 * Method to add an item to a purchase order
	 * @param item to add to the purchase order
	 * @param quantityAdd quantity to add to the purchase order
	 */
	public void addItemToPurchaseOrder(Item item, int quantityAdd) {
		ArrayList<PurchaseOrder> itemPurchaseOrderList = new ArrayList<PurchaseOrder>();
		itemPurchaseOrderList = pOLoader.getPurchaseOrderListByItemValid(item);
		//if no valid pending purchase order to attach item to
		if (itemPurchaseOrderList.isEmpty()) {
			PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
			SupplierLoader sLoader = new SupplierLoader();
			ArrayList<Supplier> supplierList= new ArrayList<Supplier>();
			supplierList = sLoader.getSupplierListByID(item.getIdSupplier());
			Supplier supplier;
			if (!supplierList.isEmpty()) {
				supplier = supplierList.get(0);
			}
			else {
				supplier = null;
			}
			PurchaseOrder pO = new PurchaseOrder(pOSLoader.getPurchaseOrderStatus(1), supplier);
			pOLoader.createPurchaseOrder(pO);
			PurchaseOrderLine pOL = new PurchaseOrderLine(quantityAdd, item.getIdItem(), pO);
			pOLLoader.createPurchaseOrderLine(pOL);
		}
		// If valid pending purchase order to attach item to exists
		else {
			pOLList = pOLLoader.getPurchaseOrderLineByOrderID(itemPurchaseOrderList.get(0).getIDPurchaseOrder());
			boolean lineFound = false;
			PurchaseOrderLine pOL = null;
			for (int i = 0; i < pOLList.size(); i++){
				if (pOLList.get(i).getItemID() == item.getIdItem()) {
					pOL = pOLList.get(i);
					lineFound = true;
				}
			}
			//if item is not already on the purchase order
			if (!lineFound) {
				pOL = new PurchaseOrderLine(quantityAdd, item.getIdItem(), itemPurchaseOrderList.get(0));
				pOLLoader.createPurchaseOrderLine(pOL);
			}
			//if item is already on the purchase order
			else {
				pOL.setQuantity((quantityAdd));
				pOLLoader.setPurchaseOrderLineStock(pOL);
			}
		}
	}
	
	/**
	 * Method to check if a purchase order is required to maintain levels of stock for an item
	 * @param item to check the levels of
	 */
	public void calculateOrderQuantity(Item item) {
		int inboundStock = 0;
		pOList = pOLoader.getPurchaseOrderListByItem(item.getIdItem());
		for (int i = 0; i < pOList.size(); i++) {
			if (pOList.get(i).getPurchaseOrderStatus().getStatusID() == 2 || pOList.get(i).getPurchaseOrderStatus().getStatusID() == 3){
				pOLList = pOLLoader.getPurchaseOrderLineByOrderAndProduct(pOList.get(i).getIDPurchaseOrder(), item.getIdItem());
				for (int j = 0; j < pOLList.size(); j++) {
					inboundStock = inboundStock + pOLList.get(j).getQuantity() - pOLList.get(j).getDamagedQuantity();
				}
			}
		}
		
		int stockEstimate = (int) (item.getStock() + inboundStock - item.getSalesRate());
		int stockTarget = item.getStock() * 3;
		int stockOrder = 0;
		if (stockEstimate < 0) {
			stockOrder = (int)stockTarget;
		}
		else if (stockEstimate < item.getSalesRate()) {
			stockOrder = (int)stockTarget - (int)stockEstimate;
		}
		if (stockOrder != 0) {
			addItemToPurchaseOrder(item, stockOrder);
		}
	}
	
	/**
	 * Method to set the purchase order as sent 
	 * @param pO purchase order to be sent
	 * @param employeeID id of the employee who sent the order
	 */
	public void sendPurchaseOrder(PurchaseOrder pO, Integer employeeID) {
		PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
		//update order from pending to sent
		if (pO.getPurchaseOrderStatus().getStatusID() == 1) {
			//TODO get current employee and set on purchase order
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(2);
			pO.setPurchaseOrderStatus(pOS);
			pOLoader.setPurchaseOrder(pO);
		}
	}
	
	public void receivePurchaseOrder(PurchaseOrder pO, Integer employeeID) {
		PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
		System.out.println("Checking purchase order status");
		System.out.println(pO.getPurchaseOrderStatus().getStatusID());
		if (pO.getPurchaseOrderStatus().getStatusID() == 2) {
			//TODO get current employee and set on purchase order
			System.out.println("Correct status determined");
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(3);
			pO.setPurchaseOrderStatus(pOS);
			System.out.println("Set purchase order");
			pOLoader.setPurchaseOrder(pO);
			String damagedReport = "<html>Damaged Stock Report<br>Purchaseorder: " + pO.getIDPurchaseOrder();
			boolean damagedGoods = false;
			PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
			ArrayList<PurchaseOrderLine> pOLList = pOLLoader.getPurchaseOrderLineByOrderID(pO.getIDPurchaseOrder());
			for (int i = 0; i < pOLList.size(); i++) {
				if (pOLList.get(i).getDamagedQuantity() > 0) {
					System.out.println("Damaged item detected");
					damagedGoods = true;
					MongoPull mP = new MongoPull();
					Item item = mP.getItem(pOLList.get(i).getItemID());
					damagedReport = damagedReport + "<br>Item ID: " + item.getIdItem() + " Item Name: " + item.getItemName() + " Number Damaged: " + pOLList.get(i).getDamagedQuantity();
				}
			}
			if (damagedGoods) {
				System.out.println("Sending message to IMS");
				MessageContent messageContent = new MessageContent(damagedReport, "damagedStockReport");
				Sender sender = new Sender ("IMS.IN");
				sender.sendMessage(messageContent);
			}
		}
		
	}
	
	public void completePurchaseOrder(PurchaseOrder pO, Integer employeeID) {
		PurchaseOrderStatusLoader pOSLoader = new PurchaseOrderStatusLoader();
		if (pO.getPurchaseOrderStatus().getStatusID() == 3) {
			//TODO get current employee and set on purchase order
			PurchaseOrderStatus pOS = pOSLoader.getPurchaseOrderStatus(4);
			pO.setPurchaseOrderStatus(pOS);
			pOLoader.setPurchaseOrder(pO);
		}
	}
}
