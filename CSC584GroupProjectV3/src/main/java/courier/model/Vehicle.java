package courier.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	private int vehicleId;
	private String vehicleRegistrationNumber;
	private String vehicleType;
	private int vehicleCapacity;
	private String vehicleStatus;
	private int staffId;

	public int getVehicleID() {
		return vehicleId;
	}

	public void setVehicleID(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getVehicleCapacity() {
		return vehicleCapacity;
	}

	public void setVehicleCapacity(int vehicleCapacity) {
		this.vehicleCapacity = vehicleCapacity;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
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
