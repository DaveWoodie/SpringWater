package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.PurchaseOrderStatus;

public interface PurchaseOrderStatusManager {

	//CREATES
		/**
		 * Method to make a single status.
		 * @param s : The PurchaseOrderStatus to add.
		 */
		public void persistPurchaseOrderStatus(PurchaseOrderStatus s);
		/**
		 * Method to create a set of status' from a List.
		 * @param s : The PurchaseOrderStatus List to add.
		 */
		public void persistPurchaseOrderStatus(List<PurchaseOrderStatus> s);
		
		//READS
		/**
		 * Method to return a status by it's ID number.
		 * @param i : the ID of the status.
		 * @return Returns data type PurchaseOrderStatus.
		 */
		public PurchaseOrderStatus findByID (int i);
		/**
		 * Method to return a status by it's name number.
		 * @param s : the name of the status.
		 * @return Returns data type PurchaseOrderStatus.
		 */
		public PurchaseOrderStatus findByStatus (String s);

		//UPDATE
		//No need to update these statuses we want them to never change.
		
		//DELETE
		//Same as above.
}
