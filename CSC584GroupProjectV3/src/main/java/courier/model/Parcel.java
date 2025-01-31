package courier.model;

import java.io.Serializable;

public class Parcel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int parcelId;
	private String parcelName;
	private String parcelAddress;
	private double parcelWeight;
	private String parcelStatus;
	private int staffId;

	public int getParcelID() {
		return parcelId;
	}

	public void setParcelID(int parcelId) {
		this.parcelId = parcelId;
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
		return staffId;
	}

	public void setStaffID(int staffId) {
		this.staffId = staffId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
