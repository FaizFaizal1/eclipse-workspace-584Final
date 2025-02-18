package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import courier.dao.AdminDAO;
import courier.dao.DashboardDAO;
import courier.dao.DispatcherDAO;
import courier.dao.StaffDAO;
import courier.model.Admin;
import courier.model.Staff;
import courier.model.Dispatcher;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Staff staff = new Staff();

			//retrieve and set email and password
			staff.setStaffEmail(request.getParameter("staffEmail"));
			staff.setStaffPassword(request.getParameter("staffPassword"));


			staff = StaffDAO.login(staff);

			//set staff session if staff is valid
			if (staff.isValid()) {
				System.out.println("staff");
	            session = request.getSession(true);
	            session.setAttribute("sessionId", staff.getStaffId());
	            session.setAttribute("sessionEmail", staff.getStaffEmail());
	            session.setAttribute("sessionRole", staff.getStaffRole());
	            session.setAttribute("sessionFirstName", staff.getStaffFirstName());
	            
				request.setAttribute("staff", StaffDAO.getStaffByEmail(staff.getStaffEmail()));
	            
				if(staff.getStaffRole().equalsIgnoreCase("admin")) {
					request.setAttribute("admin", AdminDAO.getAdminById(staff.getStaffId()));
					System.out.print(staff.getStaffEmail()+" Admin login successful");
					
					request.setAttribute("totalDispatchers", DashboardDAO.countTotalDispatchers());
					request.setAttribute("totalActiveDispatchers", DashboardDAO.countTotalDispatchersByType("Active"));
					request.setAttribute("totalInactiveDispatchers", DashboardDAO.countTotalDispatchersByType("Inactive"));
					request.setAttribute("paymentSum", DashboardDAO.sumOfPayments());
		            request.getRequestDispatcher("/courier.admin/adminDashboard.jsp").forward(request, response);
				}
				else {
					request.setAttribute("dispatcher", DispatcherDAO.getDispatcherById(staff.getStaffId()));	
					request.setAttribute("totalParcels", DashboardDAO.countTotalParcels());
					request.setAttribute("totalUnreceivedParcels", DashboardDAO.countTotalParcelsByType("Unreceived"));
					request.setAttribute("totalReceivedParcels", DashboardDAO.countTotalParcelsByType("Received"));
					request.setAttribute("paymentSum", DashboardDAO.sumOfPayments());
		            request.getRequestDispatcher("/courier.dispatcher/dispatcherDashboard.jsp").forward(request, response);
				}		
	        } else {
	        	System.out.println("Invalid login credentials");

	            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
	            request.getRequestDispatcher("signin.jsp").forward(request, response);
	        }
			
		}catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}