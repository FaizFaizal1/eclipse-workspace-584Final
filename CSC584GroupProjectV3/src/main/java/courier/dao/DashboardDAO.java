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
	
	public static int countDispatchers() {
		try {

			con = ConnectionManager.getConnection();

			sql = "SELECT * FROM dispatcher";
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count++;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
