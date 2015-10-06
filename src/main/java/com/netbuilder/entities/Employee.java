package com.netbuilder.entities;

public class Employee 
{
	private int ID;
	private Role Role;
	
	public Employee(int ID, Role Role)
	{
		this.ID = ID;
		this.Role = Role;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public Role getRole()
	{
		return Role;
	}
	
	public void setRole(Role Role)
	{
		this.Role = Role;
	}
}
