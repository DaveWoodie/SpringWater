package com.netbuilder.entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.PaymentDetails;

public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails, String> {
	public PaymentDetails findByID(int ID);
	public List<PaymentDetails> findByCustomerID(int ID);
}