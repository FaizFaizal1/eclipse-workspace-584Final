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
public class AddDispatcherController extends HttpServlet {
	private static final long serialVersionUId = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDispatcherController() {
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
		staff.setStaffFirstName(request.getParameter("dispatcherFirstName"));
		staff.setStaffLastName((request.getParameter("dispatcherLastName")));
		staff.setStaffPhoneNumber((request.getParameter("dispatcherPhoneNumber")));
		staff.setStaffEmail((request.getParameter("dispatcherEmail")));
		staff.setStaffAddress((request.getParameter("dispatcherAddress")));
		staff.setStaffPassword(request.getParameter("dispatcherPassword"));
		staff.setStaffRole(request.getParameter("staffRole"));
		dispatcher.setDispatcherStatus(request.getParameter("dispatcherStatus"));
		dispatcher.setDispatcherEmploymentType(request.getParameter("dispatcherEmploymentType"));

		dispatcher.setStaff(staff);
		
		try {
			StaffDAO.addStaff(dispatcher.getStaff());
			int staffId = StaffDAO.getStaffByEmail(dispatcher.getStaff().getStaffEmail()).getStaffId();
			dispatcher.setStaffId(staffId);
			DispatcherDAO.updateDispatcher(dispatcher);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
	}

}
