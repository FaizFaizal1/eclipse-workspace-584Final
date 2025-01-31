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

public class AdminDAO {

	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static String sql = null;

	// get all admins
	public static List<Admin> getAllAdmin() {
		List<Admin> admins = new ArrayList<Admin>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM admin ORDER BY staffID";
			ps = con.prepareStatement(sql);

			// 4. execute query
			rs = ps.executeQuery();

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setStaffID(rs.getInt("staffID"));
				admin.setAdminRole(rs.getString("admin_role"));
				admins.add(admin);
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

	// get admin by staffID
	public static Admin getAdminById(int staffID) {
		Admin admin = new Admin();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM admin WHERE staffID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, staffID);

			// 4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				admin.setStaffID(rs.getInt("staffID"));
				admin.setAdminRole(rs.getString("admin_role"));
			}
			
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return admin;
	}

	// update admin
	public static void updateAdmin(Admin admin) {

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "UPDATE admin SET admin_role=? WHERE staffID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdminRole());
			ps.setInt(2, admin.getStaffID());

			// 4. execute query
			ps.executeUpdate();
			
			System.out.println("Admin table successfully updated");

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
