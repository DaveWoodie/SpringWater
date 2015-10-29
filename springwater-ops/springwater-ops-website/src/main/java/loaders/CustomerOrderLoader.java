package loaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import connections.SQLDBConnector;
import entities.Customer;
import entities.CustomerOrder;
import entities.CustomerOrderStatus;
import entities.Employee;
import entities.Role;
import entities.User;

public class CustomerOrderLoader {
	final String tableName = " FROM customerorder";
	final String listQuery = "SELECT customerorder.*, customerorderstatus.*, customer.*, employee.*, user.*, role.*";
	final String tableJoins = " LEFT JOIN customerorderstatus ON customerorder.idCustomerOrderStatus = customer LEFT JOIN customer ON customerorder.idCustomer = customer.idUser LEFT JOIN employee ON customerorder.idEmployee = employee.idEmployee LEFT JOIN (SELECT user.idUser AS customerID, user.password AS customerPassword, user.forename AS customerForename, user.surname AS customerSurname, user.email AS customerEmail, user.isEmployee AS customerIsEmployee FROM user) AS userCustomer ON customerorder.idCustomer = userCustomer.idUser LEFT JOIN (SELECT user.idUser AS employeeID, user.password AS employeePassword, user.forename AS employeeForename, user.surname AS employeeSurname, user.email as employeeEmail, user.isEmployee AS employeeIsEmployee FROM user) AS userEmployee ON customerorder.idCustomer = userEmployee.idEmployee LEFT JOIN role ON employee.idRole = role.idRole";
	private String sql;
	private SQLDBConnector sqlDB = new SQLDBConnector();
	private CustomerOrder customerOrder;
	
	public CustomerOrder getCustomerOrderByID(int id) {
		sql = listQuery + tableName + tableJoins + " WHERE customerorder.idCustomerOrder = " + id;
		sqlDB.openCon();
		try {
			ResultSet rs = sqlDB.queryDB(sql);
			rs.next();
			CustomerOrderStatus cOS = new CustomerOrderStatus(rs.getString("status"));
			cOS.setCustomerOrderID(rs.getInt("customerorderstatus.idCustomerOrderStatus"));
			User user = new User(rs.getString("customerPassword"), rs.getString("customerForename"), rs.getString("customerSurname"), rs.getString("customerEmail"), rs.getBoolean("customerIsEmployee"));
			user.setUserID(rs.getInt("customerID"));
			Customer customer = new Customer(user, rs.getFloat("customer.credit"), rs.getString("customer.phoneNumber"), rs.getDate("customer.dateOfBirth"));
			customer.setCustomerID(rs.getInt("customer.idCustomer"));
			User eUser = new User(rs.getString("employeePassword"), rs.getString("employeeForename"), rs.getString("employeeSurname"), rs.getString("employeeEmail"), rs.getBoolean("employeeIsEmployee"));
			eUser.setUserID(rs.getInt("employeeID"));
			Role role = new Role(rs.getString("role.Role"));
			role.setID(rs.getInt("role.roleID"));
			Employee employee = new Employee(eUser, role);
			customerOrder = new CustomerOrder(rs.getDate("customerorder.datePlaced"), customer, cOS, employee, rs.getBoolean("customerorder.isPaid"), rs.getInt("customerorder.idAddress"));
		} 
		catch (SQLException sqle){
			sqle.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
