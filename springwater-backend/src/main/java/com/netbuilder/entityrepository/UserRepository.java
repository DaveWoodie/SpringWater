/**
 * @author dwoodward
 * @date 07/10/2015
 */

package com.netbuilder.entityrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.netbuilder.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByID(int i);
	public User findByForNam(String s);
	public List<User> findByForNams(String s);
	public User findBySurNam(String s);
	public List<User> findBySurNams(String s);
	public List<User> findByEmploy(boolean b);
}
