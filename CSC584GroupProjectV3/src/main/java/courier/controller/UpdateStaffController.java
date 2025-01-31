package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import courier.dao.StaffDAO;
import courier.model.Staff;

/**
 * Servlet implementation class UpdateStaffController
 */
@WebServlet("/UpdateStaffController")
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUId = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStaffController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Staff staff = new Staff();
		staff.setStaffFirstName(request.getParameter("staffFirstName"));
		staff.setStaffLastName((request.getParameter("staffLastName")));
		staff.setStaffPhoneNumber((request.getParameter("staffPhoneNumber")));
		staff.setStaffEmail((request.getParameter("staffEmail")));
		staff.setStaffAddress((request.getParameter("staffAddress")));
		staff.setStaffPassword(request.getParameter("staffPassword"));
		staff.setStaffRole(request.getParameter("staffRole"));

		String staffId = request.getParameter("staffId");

		staff.setStaffId(Integer.parseInt(staffId));
		try {
			StaffDAO.updateStaff(staff);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("staffId", request.getParameter("staffId"));
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
	}

}
