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
import courier.dao.ParcelDAO;
import courier.dao.StaffDAO;
import courier.dao.DispatcherDAO;
import courier.model.Dispatcher;
import courier.model.Staff;

/**
 * Servlet implementation class DispatcherController
 */
public class DispatcherController extends HttpServlet {
	private static final long serialVersionUId  = 1L;
	private RequestDispatcher view;
	private int staffId, sessionStaffId;
	HttpSession session;
	private String action="", forward="";
	private static String LIST = "/courier.dispatcher/manageDispatcher.jsp";
	private static String UPDATE = "/courier.dispatcher/updateDispatcher.jsp";
	private static String UPDATE_PROFILE = "/courier.dispatcher/updateDispatcherProfile.jsp";
	private static String VIEW = "/courier.dispatcher/viewDispatcher.jsp";
	private static String VIEW_PROFILE = "/courier.dispatcher/viewDispatcherProfile.jsp";
	private static String ADD = "/courier.dispatcher/addDispatcher.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherController() {
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

		if(action.equalsIgnoreCase("listDispatchers")) {
			forward = LIST;
			request.setAttribute("dispatchers", DispatcherDAO.getAllDispatchers());        
		}
		else if(action.equalsIgnoreCase("addDispatcher")) {
			forward = ADD;
		}
		else if(action.equalsIgnoreCase("viewDispatcher")) {
			forward = VIEW;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffId));
			request.setAttribute("dispatcher", DispatcherDAO.getDispatcherById(staffId));
		}	
		else if(action.equalsIgnoreCase("updateDispatcher")) { 
			forward = UPDATE;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			request.setAttribute("staff", StaffDAO.getStaffById(staffId));
			request.setAttribute("dispatcher", DispatcherDAO.getDispatcherById(staffId));	        
		}
		else if(action.equalsIgnoreCase("updateDispatcherProfile")) {
			forward = UPDATE_PROFILE;
			request.setAttribute("staff", StaffDAO.getStaffById(sessionStaffId));
			request.setAttribute("dispatcher", DispatcherDAO.getDispatcherById(sessionStaffId));
		}
		else if(action.equalsIgnoreCase("deleteDispatcher")) {
			forward = LIST;
			staffId = Integer.parseInt(request.getParameter("staffId"));
			StaffDAO.deleteStaff(staffId);
			request.setAttribute("dispatchers", DispatcherDAO.getAllDispatchers());        
		}

		view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dispatcher dispatcher = new Dispatcher();
		Staff staff = new Staff();

		String staffId = request.getParameter("staffId");

		//get staff table details
		staff.setStaffFirstName(request.getParameter("dispatcherFirstName"));
		staff.setStaffLastName((request.getParameter("dispatcherLastName")));
		staff.setStaffPhoneNumber((request.getParameter("dispatcherPhoneNumber")));
		staff.setStaffEmail((request.getParameter("dispatcherEmail")));
		staff.setStaffAddress((request.getParameter("dispatcherAddress")));
		staff.setStaffPassword(request.getParameter("dispatcherPassword"));
		staff.setStaffRole(request.getParameter("staffRole"));
		
		//get dispatcher table details
		dispatcher.setDispatcherStatus(request.getParameter("dispatcherStatus"));
		dispatcher.setDispatcherEmploymentType(request.getParameter("dispatcherEmploymentType"));

		if(staffId != null) {
			try {
			staff.setStaffId(Integer.parseInt(staffId));
			dispatcher.setStaffId(Integer.parseInt(staffId));
			dispatcher.setStaff(staff);
			DispatcherDAO.updateDispatcher(dispatcher);
			StaffDAO.updateStaff(dispatcher.getStaff());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {//TODO
			try {
				dispatcher.setStaff(staff);
				StaffDAO.addStaff(dispatcher.getStaff());
				dispatcher.setStaffId(StaffDAO.getStaffByEmail(request.getParameter("dispatcherEmail")).getStaffId()); //get staffid of newly created staff to update dispatcher table 
				DispatcherDAO.updateDispatcher(dispatcher);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		if(request.getParameter("updateDispatcherProfile").equalsIgnoreCase("Yes")) {
			forward = "/courier.dispatcher/viewDispatcherProfile.jsp";
			request.setAttribute("staff", StaffDAO.getStaffById(sessionStaffId));
			request.setAttribute("dispatcher", DispatcherDAO.getDispatcherById(sessionStaffId));
			view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			forward = LIST;
			request.setAttribute("dispatchers", DispatcherDAO.getAllDispatchers()); 
			view = request.getRequestDispatcher(forward);
			view.forward(request, response);	
		}	
	}

}
