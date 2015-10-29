/**
 * @author jforster
 * @date 6/10/15
 */
package entities;

import java.io.Serializable;
import java.util.Date;

public class PurchaseOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPurchaseOrder;
	private Date datePlaced;
	private Date dateExpected;
	private Employee employee;
	private PurchaseOrderStatus purchaseOrderStatus;
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
	public PurchaseOrder (PurchaseOrderStatus pOS, Supplier s) {
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
	
	public void setDatePlaced(Date dP) {
		datePlaced = dP;
	}

	public void setEmployee(Employee e) {
		employee = e;
	}

	public void setPurchaseOrderStatus(PurchaseOrderStatus pOS) {
		purchaseOrderStatus = pOS;
	}
	
	public void setIDPurchaseOrder(int i) {
		idPurchaseOrder = i;
	}
}