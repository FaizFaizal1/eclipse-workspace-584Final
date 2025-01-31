package courier.model;

import java.io.Serializable;

public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;
	private int deliveryID;
	private String deliveryDate;
	private String deliveryStatus;
	private int staffID;
	private int parcelID;
	private int vehicleID;
	private int routeID;

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public int getParcelID() {
		return parcelID;
	}

	public void setParcelID(int parcelID) {
		this.parcelID = parcelID;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
}