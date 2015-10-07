/**
 * @author Freshwater
 * @date 07/10/2015
 */

package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Role;

/**
 * Entity manager containing CRUD methods for the Role entity.
 */
public interface RoleManager {
	// CREATE
	public void persistRole(Role r);
	public void persistRoles(ArrayList<Role> r);
	
	// READ
	public Role findByName(String name);
	public ArrayList<Role> getRoles();
	
	// UPDATE
	public void updateRole(Role r);
	
	// DELETE
	public void removeRole(Role r);
}
