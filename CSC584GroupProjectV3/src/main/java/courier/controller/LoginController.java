package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import courier.dao.StaffDAO;
import courier.model.Admin;
import courier.model.Staff;
import courier.model.Dispatcher;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher view;

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
			staff.setStaffID(Integer.parseInt(request.getParameter("staffID")));
			staff.setStaffPassword(request.getParameter("staff_password"));
			staff.setStaffEmail(request.getParameter("staff_email"));

			//call courier() in StaffDAO
			staff = StaffDAO.login(staff);

			//set staff session if staff is valid
			if (staff.isLoggedIn()) {
				System.out.println("staff");
	            HttpSession session = request.getSession(true);
	            session.setAttribute("sessionId", staff.getStaffID());
	            session.setAttribute("sessionEmail", staff.getStaffEmail());//set current session based on email

	            // Redirect to avoid resubmission
	            request.setAttribute("staffID", request.getParameter("staffID"));
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        } else {
	        	System.out.println("staff else");
	            //response.sendRedirect("invalidLogin.jsp");
	        	// Set error attribute and forward back to courier.jsp
	            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
	            request.getRequestDispatcher("signin.jsp").forward(request, response);
	        }
			
		}catch (Throwable ex) {
			ex.printStackTrace();
		}
	}
}