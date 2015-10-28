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

public class PurchaseOrderBackendLogic {

	PurchaseOrderLoader pOLoader = new PurchaseOrderLoader();
	ArrayList<PurchaseOrderLine> pOLList;
	
	/**
	 * Method to add an item to a purchase order
	 * @param item to add to the purchase order
	 * @param quantityAdd quantity to add to the purchase order
	 */
	public void addItemToPurchaseOrder(Item item, int quantityAdd) {
		ArrayList<PurchaseOrder> itemPurchaseOrderList = new ArrayList<PurchaseOrder>();
		PurchaseOrderLineLoader pOLLoader = new PurchaseOrderLineLoader();
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
				pOL.setQuantity((pOL.getQuantity() + quantityAdd));
				pOLLoader.setPurchaseOrderLineStock(pOL);
			}
		}
	}
}
