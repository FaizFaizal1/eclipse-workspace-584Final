package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import courier.dao.AdminDAO;
import courier.dao.DispatcherDAO;
import courier.dao.StaffDAO;
import courier.model.Admin;
import courier.model.Dispatcher;
import courier.model.Staff;	

/**
 * Servlet implementation class AdminController
 */

public class AdminController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private RequestDispatcher view;
	private int staffId;
	private String action="", forward="";
//	private static String LIST = "scansort.jsp";
	private static String UPDATE = "updateAdmin.jsp";
//	private static String VIEW = "/staff/viewSupplier.jsp";	
//	private static String VIEW_PROFILE = "/supplier/viewProfile.jsp";
       
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
		action = request.getParameter("action");

		//view all parcels
		if(action.equalsIgnoreCase("updateProfile")) {
			System.out.println("UPDATE");
			forward = UPDATE;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			System.out.println(staffId);
			request.setAttribute("staff", StaffDAO.getStaffById(staffId));
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
		
		staff.setStaffId(Integer.parseInt(staffId));
		admin.setStaffId(Integer.parseInt(staffId));
		admin.setStaff(staff);

		//update admin
		try {
			StaffDAO.updateStaff(admin.getStaff());
			AdminDAO.updateAdmin(admin);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
