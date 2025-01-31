package courier.model;

import java.io.Serializable;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int paymentId;
	private double paymentAmount;
	private String paymentDate;
	private String paymentStatus;
	private int parcelId;

	public int getPaymentID() {
		return paymentId;
	}

	public void setPaymentID(int paymentId) {
		this.paymentId = paymentId;
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
		return parcelId;
	}

	public void setParcelID(int parcelId) {
		this.parcelId = parcelId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
