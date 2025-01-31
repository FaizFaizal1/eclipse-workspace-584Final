package courier.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUId = 1L;
	private int staffId; // use adminId? example given by miss uses different Id name.
	private String adminRole;
	private Staff staff;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
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