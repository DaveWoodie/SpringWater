/**
 * @author jforster
 * @date 28/10/2015
 */
package com.netbuilder.logic;

import java.util.ArrayList;








import com.netbuilder.entities.Item;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderLine;
import com.netbuilder.entities.Supplier;
import com.netbuilder.loaders.PurchaseOrderLineLoader;
import com.netbuilder.loaders.PurchaseOrderLoader;
import com.netbuilder.loaders.PurchaseOrderStatusLoader;
import com.netbuilder.loaders.SupplierLoader;

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
	
	public void calculateOrderQuantity(Item item) {
		//fetch total inbound stock from purchase orders
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
}
