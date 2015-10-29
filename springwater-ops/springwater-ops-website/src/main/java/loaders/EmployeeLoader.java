package loaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import connections.SQLDBConnector;
import entities.Employee;
import entities.Role;
import entities.User;

public class EmployeeLoader {
	
	private String sql;
	final String listQuery = "SELECT employee.*, user.*, role.*";
	final String tableName = " FROM employee";
	final String tableJoins = " LEFT JOIN user ON employee.idEmployee = user.idUser LEFT JOIN role ON employee.idRole = role.idRole";
	private SQLDBConnector sqlDB = new SQLDBConnector();
	private Employee employee;
	
	public Employee getEmployeeByID (int eID) {
		
		sql = listQuery + tableName + tableJoins + " WHERE employee.idEmployee = " + eID;
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				Role role = new Role(rs.getString("role.Role"));
				role.setID(rs.getInt("role.idRole"));
				User user = new User(rs.getString("user.password"), rs.getString("user.forename"), rs.getString("user.surname"), rs.getString("user.email"), rs.getBoolean("user.isEmployee"));
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
