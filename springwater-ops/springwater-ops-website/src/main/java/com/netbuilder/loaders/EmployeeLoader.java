/**
 * @author jforster
 * @date 30/10/2015
 */
package com.netbuilder.loaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.netbuilder.connections.SQLDBConnector;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.Role;
import com.netbuilder.entities.User;

/**
 * Class to load an employee from the database
 * @author jforster
 *
 */
public class EmployeeLoader {
	
	private String sql;
	final String listQuery = "SELECT employee.*, user.*, role.*";
	final String tableName = " FROM employee";
	final String tableJoins = " LEFT JOIN user ON employee.idEmployee = user.idUser LEFT JOIN role ON employee.idRole = role.idRole";
	private SQLDBConnector sqlDB = new SQLDBConnector();
	private Employee employee;
	
	/**
	 * Method to load an employee from a specified ID
	 * @param eID id of the employee to load
	 * @return the Employee entity found
	 */
	public Employee getEmployeeByID (int eID) {
		
		sql = listQuery + tableName + tableJoins + " WHERE employee.idEmployee = " + eID;
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				Role role = new Role(rs.getString("role.Role"));
				role.setID(rs.getInt("role.idRole"));
				User user = new User(rs.getString("user.password"), rs.getString("user.forename"), rs.getString("user.surname"), rs.getString("user.email"), rs.getBoolean("user.isEmployee"));
				user.setUserID(rs.getInt("user.idUser"));
				employee = new Employee(user, role);
				return employee;
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
