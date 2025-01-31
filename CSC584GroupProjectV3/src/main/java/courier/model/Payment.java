package courier.model;

import java.io.Serializable;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int paymentID;
	private double paymentAmount;
	private String paymentDate;
	private String paymentStatus;
	private int parcelID;

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getParcelID() {
		return parcelID;
	}

	public void setParcelID(int parcelID) {
		this.parcelID = parcelID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
