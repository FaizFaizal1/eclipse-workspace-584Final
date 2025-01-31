package courier.model;

import java.io.Serializable;

public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;
	private int deliveryId;
	private String deliveryDate;
	private String deliveryStatus;
	private int staffId;
	private int parcelId;
	private int vehicleId;
	private int routeId;

	public int getdeliveryId() {
		return deliveryId;
	}

	public void setdeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
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
		return staffId;
	}

	public void setStaffID(int staffId) {
		this.staffId = staffId;
	}

	public int getParcelID() {
		return parcelId;
	}

	public void setParcelID(int parcelId) {
		this.parcelId = parcelId;
	}

	public int getVehicleID() {
		return vehicleId;
	}

	public void setVehicleID(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getRouteID() {
		return routeId;
	}

	public void setRouteID(int routeId) {
		this.routeId = routeId;
	}
}