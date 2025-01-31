package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Dispatcher;
//test

public class DispatcherDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps = null;
	private static String sql = null;

	//get all dispatchers
	public static List<Dispatcher> getAllDispatchers() {
		List<Dispatcher> dispatchers = new ArrayList<Dispatcher>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "SELECT * FROM dispatcher d INNER JOIN staff s ON d.staffId = s.staffId";
			ps = con.prepareStatement(sql);

			//4. execute query
			rs = ps.executeQuery();

			while (rs.next()) { 
				Dispatcher dispatcher = new Dispatcher();
				dispatcher.setStaffID(rs.getInt("staffId"));	  
				dispatcher.setDispatcherStatus(rs.getString("dispatcher_status"));
				dispatcher.setDispatcherEmploymentType(rs.getString("dispatcher_employment_type"));
				dispatcher.setStaff(StaffDAO.getStaffById(rs.getInt("staffId")));
				dispatchers.add(dispatcher);
			} 
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return dispatchers; 
	}

	//get dispatcher by Id
	public static Dispatcher getDispatcherById(int staffId) {
		Dispatcher dispatcher = new Dispatcher();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM dispatcher WHERE staffId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, staffId);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				dispatcher.setStaffID(rs.getInt("staffId"));	  
				dispatcher.setDispatcherStatus(rs.getString("dispatcher_status"));
				dispatcher.setDispatcherEmploymentType(rs.getString("dispatcher_employment_type"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return dispatcher;
	}

	//delete dispatcher
	public static void deleteDispatcher(int staffId) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "DELETE FROM dispatcher WHERE staffId = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, staffId);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//update dispatcher
	public static void updateDispatcher(Dispatcher dispatcher) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "UPDATE dispatcher SET dispatcher_status=?, dispatcher_employment_type=? WHERE staffId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,dispatcher.getDispatcherStatus());
			ps.setString(2,dispatcher.getDispatcherEmploymentType());
			ps.setInt(3,dispatcher.getStaffID());

			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Dispatcher table updated successfully");

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}