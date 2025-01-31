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
			sql = "INSERT INTO delivery(delivery_date,delivery_status,staffId,parcelId,vehicleId,routeId)VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,delivery.getDeliveryDate());
			ps.setString(2,delivery.getDeliveryStatus());
			ps.setInt(3,delivery.getStaffId());
			ps.setInt(4,delivery.getParcelId());
			ps.setInt(5,delivery.getVehicleId());
			ps.setInt(6,delivery.getRouteId());

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
			sql = "SELECT * FROM delivery ORDER BY deliveryId";
			ps = con.prepareStatement(sql);

			//4. execute query
			rs = ps.executeQuery();

			while (rs.next()) { 
				Delivery delivery = new Delivery();
				delivery.setDeliveryId(rs.getInt("deliveryId"));	  
				delivery.setDeliveryDate(rs.getString("delivery_date"));
				delivery.setDeliveryStatus(rs.getString("delivery_status"));
				delivery.setStaffId(rs.getInt("staffId"));
				delivery.setParcelId(rs.getInt("parcelId"));
				delivery.setVehicleId(rs.getInt("vehicleId"));
				delivery.setRouteId(rs.getInt("routeId"));
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
	public static Delivery getDeliveryById(int deliveryId) {
		Delivery delivery = new Delivery();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM delivery WHERE deliveryId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, deliveryId);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				delivery.setDeliveryId(rs.getInt("deliveryId"));	  
				delivery.setDeliveryDate(rs.getString("delivery_date"));
				delivery.setDeliveryStatus(rs.getString("delivery_status"));
				delivery.setStaffId(rs.getInt("staffId"));
				delivery.setParcelId(rs.getInt("parcelId"));
				delivery.setVehicleId(rs.getInt("vehicleId"));
				delivery.setRouteId(rs.getInt("routeId"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return delivery;
	}

	//delete delivery
	public static void deleteDelivery(int deliveryId) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "DELETE FROM delivery WHERE deliveryId = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, deliveryId);

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
			sql = "UPDATE delivery SET delivery_date=?, delivery_status=?, staffId=?, parcelId=?, vehicleId=?, routeId=? WHERE deliveryId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,delivery.getDeliveryDate());
			ps.setString(2,delivery.getDeliveryStatus());
			ps.setInt(3,delivery.getStaffId());
			ps.setInt(4,delivery.getParcelId());
			ps.setInt(5,delivery.getVehicleId());
			ps.setInt(6,delivery.getRouteId());

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}