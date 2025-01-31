package courier.controller;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import courier.dao.StaffDAO;
import courier.model.Staff;

import java.io.IOException;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUId = 1L; 
	private RequestDispatcher view;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
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
		Staff staff = new Staff();
		//retrieve input and set
		staff.setStaffFirstName(request.getParameter("staffFirstName"));		
		staff.setStaffLastName(request.getParameter("staffLastName"));		
		staff.setStaffPhoneNumber(request.getParameter("staffPhoneNumber"));		
		staff.setStaffEmail(request.getParameter("staffEmail"));		
		staff.setStaffAddress(request.getParameter("staffAddress"));		
		staff.setStaffPassword(request.getParameter("staffPassword"));
		staff.setStaffRole(request.getParameter("staffRole"));
		
		//check if staff exists
		if(!staff.isValid()){
			try {
				//if staff not exist, add/register the staff
				StaffDAO.addStaff(staff);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//redirect to dashboard.jsp
			RequestDispatcher view = request.getRequestDispatcher("index.html"); // staff page
			view.forward(request, response);
		}        
	}
}