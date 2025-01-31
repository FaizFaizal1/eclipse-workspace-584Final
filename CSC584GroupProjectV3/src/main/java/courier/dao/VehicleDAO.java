package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Vehicle;

public class VehicleDAO {
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static String sql = null;

	// add vehicle
	public static void addVehicle(Vehicle vehicle) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "INSERT INTO vehicle(vehicle_registration_number,vehicle_type,vehicle_capacity,vehicle_status,staffId)VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vehicle.getVehicleRegistrationNumber());
			ps.setString(2, vehicle.getVehicleType());
			ps.setInt(3, vehicle.getVehicleCapacity());
			ps.setString(4, vehicle.getVehicleStatus());
			ps.setDouble(5, vehicle.getStaffID());

			// 4. execute query
			ps.executeUpdate();

			System.out.print("Vehicle added successfully");

			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get all vehicles
	public static List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM vehicle ORDER BY vehicleId";
			ps = con.prepareStatement(sql);

			// 4. execute query
			rs = ps.executeQuery();

			while (rs.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleID(rs.getInt("vehicleId"));
				vehicle.setVehicleRegistrationNumber(rs.getString("vehicle_registration_number"));
				vehicle.setVehicleType(rs.getString("vehicle_type"));
				vehicle.setVehicleCapacity(rs.getInt("vehicle_capacity"));
				vehicle.setVehicleStatus(rs.getString("vehicle_status"));
				vehicle.setStaffID(rs.getInt("staffId"));
				vehicles.add(vehicle);
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	// get vehicle by Id
	public static Vehicle getVehicleById(int vehicleId) {
		Vehicle vehicle = new Vehicle();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM vehicle WHERE vehicleId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, vehicleId);

			// 4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				vehicle.setVehicleID(rs.getInt("vehicleId"));
				vehicle.setVehicleRegistrationNumber(rs.getString("vehicle_registration_number"));
				vehicle.setVehicleType(rs.getString("vehicle_type"));
				vehicle.setVehicleCapacity(rs.getInt("vehicle_capacity"));
				vehicle.setVehicleStatus(rs.getString("vehicle_status"));
				vehicle.setStaffID(rs.getInt("staffId"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicle;
	}

	// delete vehicle
	public static void deleteVehicle(int vehicleId) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "DELETE FROM vehicle WHERE vehicleId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, vehicleId);

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update vehicle
	public static void updateVehicle(Vehicle vehicle) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "UPDATE vehicle SET vehicle_registration_number=?, vehicle_type=?, vehicle_capacity=?, vehicle_status=?, staffId=? WHERE vehicleId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, vehicle.getVehicleRegistrationNumber());
			ps.setString(2, vehicle.getVehicleType());
			ps.setInt(3, vehicle.getVehicleCapacity());
			ps.setString(4, vehicle.getVehicleStatus());
			ps.setDouble(5, vehicle.getStaffID());

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}