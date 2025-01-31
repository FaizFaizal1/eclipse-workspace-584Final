package courier.model;

import java.io.Serializable;

public class Parcel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int parcelID;
	private String parcelName;
	private String parcelAddress;
	private double parcelWeight;
	private String parcelStatus;
	private int staffID;

	public int getParcelID() {
		return parcelID;
	}

	public void setParcelID(int parcelID) {
		this.parcelID = parcelID;
	}

	public String getParcelName() {
		return parcelName;
	}

	public void setParcelName(String parcelName) {
		this.parcelName = parcelName;
	}

	public String getParcelAddress() {
		return parcelAddress;
	}

	public void setParcelAddress(String parcelAddress) {
		this.parcelAddress = parcelAddress;
	}

	public double getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(double parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getParcelStatus() {
		return parcelStatus;
	}

	public void setParcelStatus(String parcelStatus) {
		this.parcelStatus = parcelStatus;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
