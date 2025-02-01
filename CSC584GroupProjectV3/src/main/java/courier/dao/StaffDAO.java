package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.security.*;
import java.sql.*;
import java.util.*;
import courier.connection.ConnectionManager;
import courier.model.Staff;

public class StaffDAO {

	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static String sql=null;

	//login
	public static Staff login(Staff staff) throws NoSuchAlgorithmException{

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(staff.getStaffPassword().getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			sql = "SELECT * FROM staff WHERE staffEmail = ? AND staffPassword = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, staff.getStaffEmail());
			ps.setString(2, sb.toString());
			
		    //4. execute query
			rs = ps.executeQuery();

			// if staff exists set the isValid variable to true
			if (rs.next()) {
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStaffFirstName(rs.getString("staffFirstName"));
				staff.setStaffLastName(rs.getString("staffLastName"));
				staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
				staff.setStaffEmail(rs.getString("staffEmail"));
				staff.setStaffAddress(rs.getString("staffAddress"));
				staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffRole(rs.getString("staffRole"));
				staff.setValid(true);
				}
			// if staff does not exist set the isValid variable to false
			else{
				staff.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return staff;
	}

	//add new staff (register)
	public static void addStaff(Staff staff) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(staff.getStaffPassword().getBytes());
		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "INSERT INTO staff(staffFirstName,staffLastName,staffPhoneNumber,staffEmail,staffAddress,staffPassword,staffRole)VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,staff.getStaffFirstName());
			ps.setString(2,staff.getStaffLastName());
			ps.setString(3,staff.getStaffPhoneNumber());
			ps.setString(4,staff.getStaffEmail());
			ps.setString(5,staff.getStaffAddress());
			ps.setString(6,sb.toString());
			ps.setString(7,staff.getStaffRole());
			
			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Staff added successfully");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	//update staff
	public static void updateStaff(Staff staff) throws NoSuchAlgorithmException{
		try {
			con = ConnectionManager.getConnection();
			
			//convert the password to MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(staff.getStaffPassword().getBytes());

			byte byteData[] = md.digest();

			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			sql = "UPDATE staff SET staffFirstName=?, staffLastName=?, staffPhoneNumber=?, staffEmail=?, staffAddress=?, staffPassword=?, staffRole=? WHERE staffId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,staff.getStaffFirstName());
			ps.setString(2,staff.getStaffLastName());
			ps.setString(3,staff.getStaffPhoneNumber());
			ps.setString(4,staff.getStaffEmail());
			ps.setString(5,staff.getStaffAddress());
			ps.setString(6,sb.toString());
			ps.setString(7,staff.getStaffRole());
			ps.setInt(8, staff.getStaffId());
			
			ps.executeUpdate();
			
			System.out.print("Staff table updated successfully");
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

	//get staff
	public static Staff getStaff(Staff staff)  {   
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM staff WHERE staffEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,staff.getStaffEmail());
			
			//execute statement
			rs = ps.executeQuery();

			// if staff exists set the isValid variable to true
			if (rs.next()) {
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStaffFirstName(rs.getString("staffFirstName"));
				staff.setStaffLastName(rs.getString("staffLastName"));
				staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
				staff.setStaffEmail(rs.getString("staffEmail"));
				staff.setStaffAddress(rs.getString("staffAddress"));
				staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setLoggedIn(true);
			}
			// if staff does not exist set the isValid variable to false
			else{
				staff.setLoggedIn(false);
			}
			
			System.out.println("Staff found");
			//5. close connection
			con.close();	
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return staff;
	}
	
	//get staff by id
	public static Staff getStaffById(int id) {
		Staff staff = new Staff();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM staff WHERE staffId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			//execute statement
			rs = ps.executeQuery();

			if (rs.next()) {	            
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStaffFirstName(rs.getString("staffFirstName"));
				staff.setStaffLastName(rs.getString("staffLastName"));
				staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
				staff.setStaffEmail(rs.getString("staffEmail"));
				staff.setStaffAddress(rs.getString("staffAddress"));
				staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffRole(rs.getString("staffRole"));
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return staff;
	}
	
	//get staff by email
	public static Staff getStaffByEmail(String email) {
		Staff staff = new Staff();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM staff WHERE staffEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			//execute statement
			rs = ps.executeQuery();

			if (rs.next()) {	            
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStaffFirstName(rs.getString("staffFirstName"));
				staff.setStaffLastName(rs.getString("staffLastName"));
				staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
				staff.setStaffEmail(rs.getString("staffEmail"));
				staff.setStaffAddress(rs.getString("staffAddress"));
				staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffRole(rs.getString("staffRole"));
			}
			
			System.out.println("Staff with email " + email + " found");
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return staff;
	}

	//get all staff role dispatcher
	public static List<Staff> getStaffDispatcher() {
		List<Staff> staffs = new ArrayList<Staff>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM staff s INNER JOIN dispatcher d ON s.staffId = d.staffId";
			ps=con.prepareStatement(sql);
						
			//4. execute query
			rs = ps.executeQuery();

			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffId(rs.getInt("staffId"));
				staff.setStaffFirstName(rs.getString("staffFirstName"));
				staff.setStaffLastName(rs.getString("staffLastName"));
				staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
				staff.setStaffEmail(rs.getString("staffEmail"));
				staff.setStaffAddress(rs.getString("staffAddress"));
				staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setDispatcher(DispatcherDAO.getDispatcherById(rs.getInt("staffId")));
				staffs.add(staff);
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return staffs;
	}
	
	//get all staff role admin
		public static List<Staff> getStaffAdmin() {
			List<Staff> staffs = new ArrayList<Staff>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				
				//3. create statement  
				sql = "SELECT * FROM staff s INNER JOIN admin a ON s.staffId = a.staffId";
				ps=con.prepareStatement(sql);
							
				//4. execute query
				rs = ps.executeQuery();

				while (rs.next()) {
					Staff staff = new Staff();
					staff.setStaffId(rs.getInt("staffId"));
					staff.setStaffFirstName(rs.getString("staffFirstName"));
					staff.setStaffLastName(rs.getString("staffLastName"));
					staff.setStaffPhoneNumber(rs.getString("staffPhoneNumber"));
					staff.setStaffEmail(rs.getString("staffEmail"));
					staff.setStaffAddress(rs.getString("staffAddress"));
					staff.setStaffDateOfHire(rs.getString("staffDateOfHire"));
					staff.setStaffPassword(rs.getString("staffPassword"));
					staff.setAdmin(AdminDAO.getAdminById(rs.getInt("staffId")));
					staffs.add(staff);
				}
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return staffs;
		}
		
	//delete staff and courier from table staffs
	public static void deleteStaff(String email) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			sql = "DELETE FROM staff WHERE staffEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			//4. execute query
			ps.executeUpdate();
			
			System.out.println("Dispatcher with email " + email + " successfully deleted");

			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}		
}