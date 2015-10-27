package com.netbuilder.entityrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netbuilder.entities.Role;

/**
 * @author Freshwater
 * @date 07/10/2015
 */

public interface RoleRepository {
	
	public Role findByID(int ID);
	public Role findByName(String name);
}