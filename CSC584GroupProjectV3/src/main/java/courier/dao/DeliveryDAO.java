package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Delivery;

public class DeliveryDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps = null;
	private static String sql = null;

	//add delivery
	public static void addDelivery(Delivery delivery){		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "INSERT INTO delivery(delivery_date,delivery_status,staffID,parcelID,vehicleID,routeID)VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,delivery.getDeliveryDate());
			ps.setString(2,delivery.getDeliveryStatus());
			ps.setInt(3,delivery.getStaffID());
			ps.setInt(4,delivery.getParcelID());
			ps.setInt(5,delivery.getVehicleID());
			ps.setInt(6,delivery.getRouteID());

			//4. execute query
			ps.executeUpdate();
			
			System.out.print("Delivery added successfully");
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//get all deliveries
	public static List<Delivery> getAllDeliveries() {
		List<Delivery> deliveries = new ArrayList<Delivery>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "SELECT * FROM delivery ORDER BY deliveryID";
			ps = con.prepareStatement(sql);

			//4. execute query
			rs = ps.executeQuery();

			while (rs.next()) { 
				Delivery delivery = new Delivery();
				delivery.setDeliveryID(rs.getInt("deliveryID"));	  
				delivery.setDeliveryDate(rs.getString("delivery_date"));
				delivery.setDeliveryStatus(rs.getString("delivery_status"));
				delivery.setStaffID(rs.getInt("staffID"));
				delivery.setParcelID(rs.getInt("parcelID"));
				delivery.setVehicleID(rs.getInt("vehicleID"));
				delivery.setRouteID(rs.getInt("routeID"));
				deliveries.add(delivery);
			} 
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return deliveries; 
	}

	//get delivery by Id
	public static Delivery getDeliveryById(int deliveryID) {
		Delivery delivery = new Delivery();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM delivery WHERE deliveryID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, deliveryID);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				delivery.setDeliveryID(rs.getInt("deliveryID"));	  
				delivery.setDeliveryDate(rs.getString("delivery_date"));
				delivery.setDeliveryStatus(rs.getString("delivery_status"));
				delivery.setStaffID(rs.getInt("staffID"));
				delivery.setParcelID(rs.getInt("parcelID"));
				delivery.setVehicleID(rs.getInt("vehicleID"));
				delivery.setRouteID(rs.getInt("routeID"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return delivery;
	}

	//delete delivery
	public static void deleteDelivery(int deliveryID) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "DELETE FROM delivery WHERE deliveryID = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, deliveryID);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//update delivery
	public static void updateDelivery(Delivery delivery) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "UPDATE delivery SET delivery_date=?, delivery_status=?, staffID=?, parcelID=?, vehicleID=?, routeID=? WHERE deliveryID=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,delivery.getDeliveryDate());
			ps.setString(2,delivery.getDeliveryStatus());
			ps.setInt(3,delivery.getStaffID());
			ps.setInt(4,delivery.getParcelID());
			ps.setInt(5,delivery.getVehicleID());
			ps.setInt(6,delivery.getRouteID());

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}