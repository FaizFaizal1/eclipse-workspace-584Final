package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import courier.dao.AdminDAO;
import courier.dao.DispatcherDAO;
import courier.dao.AdminDAO;
import courier.dao.StaffDAO;
import courier.model.Admin;
import courier.model.Admin;
import courier.model.Staff;	

/**
 * Servlet implementation class AdminController
 */

public class AdminController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private RequestDispatcher view;
	private int staffId, sessionStaffId;
	HttpSession session;
	private String action="", forward="", updateAdminProfile;
	private static String LIST = "/courier.admin/manageAdmin.jsp";
	private static String UPDATE = "/courier.admin/updateAdmin.jsp";
	private static String UPDATE_PROFILE = "/courier.admin/updateAdminProfile.jsp";
	private static String VIEW = "/courier.admin/viewAdmin.jsp";
	private static String VIEW_PROFILE = "/courier.admin/viewAdminProfile.jsp";
	private static String ADD = "/courier.admin/addAdmin.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		sessionStaffId = (int) session.getAttribute("sessionId");
		action = request.getParameter("action");	
		
		
		if(action.equalsIgnoreCase("listAdmins")) {
			forward = LIST;
			request.setAttribute("admins", AdminDAO.getAllAdmin());        
		}
		else if(action.equalsIgnoreCase("addAdmin")) {
			forward = ADD;
		}
		else if(action.equalsIgnoreCase("viewAdmin")) {
			forward = VIEW;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffId));
			request.setAttribute("admin", AdminDAO.getAdminById(staffId));
		}	
		else if(action.equalsIgnoreCase("updateAdmin")) { 
			forward = UPDATE;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffId));
			request.setAttribute("admin", AdminDAO.getAdminById(staffId));	        
		}
		else if(action.equalsIgnoreCase("updateAdminProfile")) {
			forward = UPDATE_PROFILE;
			request.setAttribute("staff", StaffDAO.getStaffById(sessionStaffId));
			request.setAttribute("admin", AdminDAO.getAdminById(sessionStaffId));
		}
		else if(action.equalsIgnoreCase("deleteAdmin")) {
			forward = LIST;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			StaffDAO.deleteStaff(staffId);
			request.setAttribute("admins", AdminDAO.getAllAdmin());        
		}

		view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		Staff staff = new Staff();
		staff.setStaffFirstName(request.getParameter("adminFirstName"));
		staff.setStaffLastName((request.getParameter("adminLastName")));
		staff.setStaffPhoneNumber((request.getParameter("adminPhoneNumber")));
		staff.setStaffEmail((request.getParameter("adminEmail")));
		staff.setStaffAddress((request.getParameter("adminAddress")));
		staff.setStaffPassword(request.getParameter("adminPassword"));
		staff.setStaffRole(request.getParameter("staffRole"));
		
		admin.setAdminRole(request.getParameter("adminRole"));
		
		String staffId = request.getParameter("staffId");

		if(staffId != null) {
			try {
			staff.setStaffId(Integer.parseInt(staffId));
			admin.setStaffId(Integer.parseInt(staffId));
			admin.setStaff(staff);
			AdminDAO.updateAdmin(admin);
			StaffDAO.updateStaff(admin.getStaff());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {//TODO
			try {
				admin.setStaff(staff);
				StaffDAO.addStaff(admin.getStaff());
				admin.setStaffId(StaffDAO.getStaffByEmail(request.getParameter("adminEmail")).getStaffId()); //get staffid of newly created staff to update admin table
				AdminDAO.updateAdmin(admin);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		
		updateAdminProfile = request.getParameter("updateAdminProfile");
		
		if (updateAdminProfile != null) {
			if(request.getParameter("updateAdminProfile").equalsIgnoreCase("Yes")) {
				forward = VIEW_PROFILE;
				request.setAttribute("staff", StaffDAO.getStaffById(sessionStaffId));
				request.setAttribute("admin", AdminDAO.getAdminById(sessionStaffId));
				view = request.getRequestDispatcher(forward);
				view.forward(request, response);
			} 
		}
		else {
				forward = LIST;
				request.setAttribute("admins", AdminDAO.getAllAdmin()); 
				view = request.getRequestDispatcher(forward);
				view.forward(request, response);
		}	
	}
}
