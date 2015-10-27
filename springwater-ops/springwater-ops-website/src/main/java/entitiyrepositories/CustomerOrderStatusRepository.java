/**
 * @author dwoodward
 * @date 07/10/2015
 */
package entitiyrepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.CustomerOrderStatus;

public interface CustomerOrderStatusRepository {
	public CustomerOrderStatus findByID (int i);
	public CustomerOrderStatus findByStatus (String s);
}