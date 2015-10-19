/**
 * @author jforster
 * @date 6/10/15
 */
package com.netbuilder.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPurchaseOrder;
	private Date datePlaced;
	private Date dateExpected;
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idEmployee")
	private Employee employee;
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idPurchaseOrderStatus")
	private PurchaseOrderStatus purchaseOrderStatus;
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "idSupplier")
	private Supplier supplier;
	
	/**
	 * Constructor to build an instance of PurchaseOrder, not null variables are date placed, employee owning, the order status and the supplier
	 * @author jforster
	 * @date 6/10/2015
	 * @param dP : Date of current time
	 * @param e : Employee assigned to order
	 * @param pOS : PurchaseOrderStatus of the order
	 * @param s : Supplier who fufills the order 
	 */
	public PurchaseOrder (Date dP, Employee e, PurchaseOrderStatus pOS, Supplier s) {
		datePlaced = new Date(dP.getTime());
		employee = e;
		purchaseOrderStatus = pOS;
		supplier = s;
	}
	
	/**
	 * Blank constructor for testing purposes only
	 */
	@Deprecated
	public PurchaseOrder() { }

	public int getIDPurchaseOrder() {
		return idPurchaseOrder;
	}

	public Date getDatePlaced() {
		return datePlaced;
	}

	public Date getDateExpected() {
		return dateExpected;
	}

	public Employee getEmployee() {
		return employee;
	}

	public PurchaseOrderStatus getPurchaseOrderStatus() {
		return purchaseOrderStatus;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setDateExpected(Date dE) {
		dateExpected = dE;
	}

	public void setEmployee(Employee e) {
		employee = e;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus pOS) {
		purchaseOrderStatus = pOS;
	}
}