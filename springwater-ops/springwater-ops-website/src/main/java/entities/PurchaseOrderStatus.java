/**
 * @author dwoodward
 * @date 06/10/2015
 */

package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class PurchaseOrderStatus {

	private int statusID;
	private String status;
	
	/**
	 * Empty constructor to create an instance of the Purchase Order Status Class.
	 */
	public PurchaseOrderStatus () { }
	
	/**
	 * Constructor with a new status String
	 * @param status
	 * @MethodAuthor tstacey
	 * @date 08/10/2015
	 */
	public PurchaseOrderStatus(String status) {
		this.status = status;
	}
	
	public int getStatusID() {
		return statusID;
	}
	
	/**
	 * Method to get the Purchase Order Status.
	 * @return Returns data type string.
	 */
	public String getPurchOrderStatus() {
		return status;
	}
	
	public void setPurchOrderID(int i) {
		statusID = i;
	}
}