package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Parcel;

public class ParcelDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps = null;
	private static String sql = null;

	//add parcel
	public static void addParcel(Parcel parcel){		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "INSERT INTO parcel(parcelName,parcelAddress,parcelWeight,parcelStatus,staffId)VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,parcel.getParcelName());
			ps.setString(2,parcel.getParcelAddress());
			ps.setDouble(3,parcel.getParcelWeight());
			ps.setString(5,parcel.getParcelStatus());
			ps.setInt(6,parcel.getStaffId());

			//4. execute query
			ps.executeUpdate();
			
			System.out.print("Parcel added successfully");
			
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//get all parcels
	public static List<Parcel> getAllParcels() {
		List<Parcel> parcels = new ArrayList<Parcel>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();
			System.out.println("getAllParcels");

			//3. create statement
			sql = "SELECT * FROM parcel ORDER BY parcelId";
			ps = con.prepareStatement(sql);

			//4. execute query
			rs = ps.executeQuery();

			while (rs.next()) { 
				Parcel parcel = new Parcel();
				parcel.setParcelId(rs.getInt("parcelId"));	  
				parcel.setParcelName(rs.getString("parcelName"));
				parcel.setParcelAddress(rs.getString("parcelAddress"));
				parcel.setParcelWeight(rs.getDouble("parcelWeight"));
				parcel.setParcelStatus(rs.getString("parcelStatus"));
				parcel.setStaffId(rs.getInt("staffId"));
				parcels.add(parcel);

			} 
			System.out.println("getAllParcels finish");
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return parcels; 
	}

	//get parcel by Id
	public static Parcel getParcelById(int parcelId) {
		Parcel parcel = new Parcel();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM parcel WHERE parcelId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, parcelId);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				parcel.setParcelId(rs.getInt("parcelId"));	  
				parcel.setParcelName(rs.getString("parcelName"));
				parcel.setParcelAddress(rs.getString("parcelAddress"));
				parcel.setParcelWeight(rs.getDouble("parcelWeight"));
				parcel.setParcelStatus(rs.getString("parcelStatus"));
				parcel.setStaffId(rs.getInt("staffId"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return parcel;
	}

	//delete parcel
	public static void deleteParcel(int parcelId) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "DELETE FROM parcel WHERE parcelId = ?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, parcelId);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//update parcel
	public static void updateParcel(Parcel parcel) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "UPDATE parcel SET parcelName=?, parcelAddress=?, parcelWeight=?, parcelStatus=?, staffId=? WHERE parcelId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,parcel.getParcelName());
			ps.setString(2,parcel.getParcelAddress());
			ps.setDouble(3,parcel.getParcelWeight());
			ps.setString(4,parcel.getParcelStatus());
			ps.setInt(5,parcel.getStaffId());
			ps.setInt(6,parcel.getParcelId());

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}