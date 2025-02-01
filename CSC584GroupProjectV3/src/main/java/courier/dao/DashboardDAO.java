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

			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM dispatcher";
			stmt = con.createStatement();

			// 4. execute query
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count++;
			}
			
//			while (rs.next()) {
//				count++;
//			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
