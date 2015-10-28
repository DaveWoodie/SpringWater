package com.netbuilder.apploader;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.netbuilder.connections.SQLDBConnector;
import com.netbuilder.entities.PurchaseOrderStatus;

public class PurchaseOrderStatusLoader {
	
	
	public PurchaseOrderStatus getPurchaseOrderStatus(int id) {
		final SQLDBConnector sqlDB = new SQLDBConnector();
		String sql = "SELECT * FROM purchaseorderstatus WHERE idPurchaseOrderStatus = " + id;
		PurchaseOrderStatus pOS;
		try {
			sqlDB.openCon();
			ResultSet rs = sqlDB.queryDB(sql);
			while (rs.next()) {
				pOS = new PurchaseOrderStatus(rs.getString("status"));
				pOS.setPurchOrderID(rs.getInt("idpurchaseorderstatus"));
				return pOS;
			}
			rs.close();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			sqlDB.closeCon();
		}
		return null;
	}
}
