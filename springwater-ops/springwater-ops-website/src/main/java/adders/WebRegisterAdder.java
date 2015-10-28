package adders;

import java.sql.ResultSet;
import java.sql.SQLException;

import connections.SQLDBConnector;


public class WebRegisterAdder {
	private SQLDBConnector SQL = new SQLDBConnector();
	private ResultSet rSet;
	
	public WebRegisterAdder() {
	}
	
	public void addNewUser(String[] data) {
		
		SQL.openCon();
		//Might need to get the last used ID here but not sure
		
		try {
		
			SQL.addToDB("INSERT INTO user (password, forename, surname, email, isemployee) "
					+ "VALUES (SHA1('" + data[0] + "'),'" + data[1] + "','"+ data[2] + "','"+ data[3] + "',0)" );
			
		}
		catch(SQLException e) {
			System.out.println("Heyo.");
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			SQL.closeCon();
		}
		
	}
	
	public void addNewCustomer(String dob, int teleNumber) {
		
	}
}
