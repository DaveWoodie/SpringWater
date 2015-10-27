package entitiyrepositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Employee;
import entities.Item;
import entities.PurchaseOrder;
import entities.PurchaseOrderStatus;
import entities.Supplier;

/**
 * Repository containing CRUD methods for the PurchaseOrder entity
 * @author jforster
 *
 */

public interface PurchaseOrderRepository {
	
	public PurchaseOrder findbyPurchaseOrderID(int pOID);
	
	public List<PurchaseOrder> findByStatus(PurchaseOrderStatus pOS);
	public List<PurchaseOrder> findByEmployee(Employee e);
	public List<PurchaseOrder> findBySupplier(Supplier s);
	public List<PurchaseOrder> findByDateExpected(Date dE);
	public List<PurchaseOrder> findByItem(Item i);
}