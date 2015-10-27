package entitiyrepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Supplier;

/**
 * 
 * Repository for the Supplier entity
 * @author tstacey
 * @date 07/10/2015
 */

/**#
 * Modified to change the naming convention slightly.
 * @author dwoodward
 *
 */

public interface SupplierRepository {
	public Supplier findSupplierByName(String supplierName);
}