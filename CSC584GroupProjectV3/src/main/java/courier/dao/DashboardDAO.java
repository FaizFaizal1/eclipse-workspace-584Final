package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Admin;

public class DashboardDAO {

	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;
	private static PreparedStatement ps = null;
	private static String sql = null;
	private static int count = 0;
	
	public static int countTotalDispatchers() {
		try {

			con = ConnectionManager.getConnection();

			sql = "SELECT * FROM dispatcher";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			
			count = 0;
			while(rs.next()) {
				count++;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static int countTotalDispatchersByType(String type) {
		try {

			con = ConnectionManager.getConnection();

			sql = "SELECT * FROM dispatcher";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			
			
			if ("Active".equalsIgnoreCase(type)) {
				ps.setString(1, "Active");
			} else {
				ps.setString(1, "Inactive");
			}
			
			count = 0;
			while(rs.next()) {
				count++;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static int countTotalParcels() {
		try {

			con = ConnectionManager.getConnection();

			sql = "SELECT * FROM parcel";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			
			count = 0;
			while(rs.next()) {
				count++;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static int countTotalParcelsByType(String type) {
		try {

			con = ConnectionManager.getConnection();
			
			sql = "SELECT * FROM parcel WHERE parcelStatus=?";
			ps = con.prepareStatement(sql);
	
			if ("Unreceived".equalsIgnoreCase(type)) {
				ps.setString(1, "Unreceived");
			} else {
				ps.setString(1, "Received");	
			}

			rs = ps.executeQuery();
			
			count = 0;
			while(rs.next()) {
				count++;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(DashboardDAO.countTotalParcelsByType("Unreceived"));
	}
}
