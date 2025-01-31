package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Payment;

public class PaymentDAO {
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static String sql = null;

	// add payment
	public static void addPayment(Payment payment) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "INSERT INTO payment(payment_amount,payment_date,payment_status,staffID)VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, payment.getPaymentAmount());
			ps.setString(2, payment.getPaymentDate());
			ps.setString(3, payment.getPaymentStatus());
			ps.setInt(4, payment.getParcelID());

			// 4. execute query
			ps.executeUpdate();

			System.out.print("Payment added successfully");

			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get all payments
	public static List<Payment> getAllPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM payment ORDER BY paymentID";
			ps = con.prepareStatement(sql);

			// 4. execute query
			rs = ps.executeQuery();

			while (rs.next()) {
				Payment payment = new Payment();
				payment.setPaymentID(rs.getInt("paymentID"));
				payment.setPaymentAmount(rs.getDouble("payment_amount"));
				payment.setPaymentDate(rs.getString("payment_date"));
				payment.setPaymentStatus(rs.getString("payment_status"));
				payment.setParcelID(rs.getInt("parcelID"));
				payments.add(payment);
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return payments;
	}

	// get payment by Id
	public static Payment getPaymentById(int paymentID) {
		Payment payment = new Payment();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM payment WHERE paymentID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, paymentID);

			// 4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				payment.setPaymentID(rs.getInt("paymentID"));
				payment.setPaymentAmount(rs.getDouble("payment_amount"));
				payment.setPaymentDate(rs.getString("payment_date"));
				payment.setPaymentStatus(rs.getString("payment_status"));
				payment.setParcelID(rs.getInt("parcelID"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return payment;
	}

	// delete payment
	public static void deletePayment(int paymentID) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "DELETE FROM payment WHERE paymentID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, paymentID);

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update payment
	public static void updatePayment(Payment payment) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "UPDATE payment SET payment_amount=?, payment_date=?, payment_status=?, parcelID=? WHERE paymentID=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, payment.getPaymentAmount());
			ps.setString(2, payment.getPaymentDate());
			ps.setString(3, payment.getPaymentStatus());
			ps.setInt(4, payment.getParcelID());

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}