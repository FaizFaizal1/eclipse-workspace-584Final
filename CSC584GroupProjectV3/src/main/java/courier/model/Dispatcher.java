package courier.model;

import java.io.Serializable;

public class Dispatcher extends Staff implements Serializable {
	private static final long serialVersionUId = 1L;
	private int staffId; // use dispatcherId? example given by miss uses different Id name.
	private String dispatcherStatus;
	private String dispatcherEmploymentType;
	private Staff staff;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
		return serialVersionUId;
	}
}
