package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import courier.dao.DispatcherDAO;
import courier.dao.StaffDAO;
import courier.model.Dispatcher;
import courier.model.Staff;

/**
 * Servlet implementation class UpdateDispatcherController
 */
public class UpdateDispatcherController extends HttpServlet {
	private static final long serialVersionUId = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDispatcherController() {
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
		Dispatcher dispatcher = new Dispatcher();
		Staff staff = new Staff();
		staff.setStaffFirstName(request.getParameter("dispatcher_first_name"));
		staff.setStaffLastName((request.getParameter("dispatcher_last_name")));
		staff.setStaffPhoneNumber((request.getParameter("dispatcher_phone_number")));
		staff.setStaffEmail((request.getParameter("dispatcher_email")));
		staff.setStaffAddress((request.getParameter("dispatcher_address")));
		staff.setStaffPassword(request.getParameter("dispatcher_password"));
		staff.setStaffRole(request.getParameter("staff_role"));
		dispatcher.setDispatcherStatus(request.getParameter("dispatcher_status"));
		dispatcher.setDispatcherEmploymentType(request.getParameter("dispatcher_employment_type"));

		String staffId = request.getParameter("staffId");

		staff.setStaffId(Integer.parseInt(staffId));
		dispatcher.setStaffId(Integer.parseInt(staffId));
		dispatcher.setStaff(staff);
		
		try {
			StaffDAO.updateStaff(dispatcher.getStaff());
			DispatcherDAO.updateDispatcher(dispatcher);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
	}

}
