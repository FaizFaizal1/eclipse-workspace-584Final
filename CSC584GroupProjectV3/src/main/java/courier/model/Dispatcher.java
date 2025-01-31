package courier.model;

import java.io.Serializable;

public class Dispatcher implements Serializable {
	private static final long serialVersionUID = 1L;
	private int staffID; // use dispatcherID? example given by miss uses different ID name.
	private String dispatcherStatus;
	private String dispatcherEmploymentType;
	private Staff staff;

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getDispatcherStatus() {
		return dispatcherStatus;
	}

	public void setDispatcherStatus(String dispatcherStatus) {
		this.dispatcherStatus = dispatcherStatus;
	}

	public String getDispatcherEmploymentType() {
		return dispatcherEmploymentType;
	}

	public void setDispatcherEmploymentType(String dispatcherEmploymentType) {
		this.dispatcherEmploymentType = dispatcherEmploymentType;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
