/**
 * @author chrisjwwalker
 */

package com.netbuilder.entitymanagers;

import java.util.List;

import com.netbuilder.entities.PaymentDetails;

public interface PaymentDetailsManager {

	// CREATE
	public void persistPayment(PaymentDetails paymentDetails);
	public void persistPayment(List<PaymentDetails> paymentDetails);
	
	// READ
	public PaymentDetails findByID(int ID);
	public PaymentDetails findByName(String name);
	public List<PaymentDetails> getNames();
	
	// UPDATE
	public void updatePayment(PaymentDetails paymentDetails);
	
	// DELETE
	public void removeItem(PaymentDetails paymentDetails);
}
