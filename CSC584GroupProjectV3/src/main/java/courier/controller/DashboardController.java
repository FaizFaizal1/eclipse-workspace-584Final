package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import courier.dao.AdminDAO;
import courier.dao.DashboardDAO;
import courier.dao.DispatcherDAO;
import courier.dao.StaffDAO;
import courier.model.Staff;

/**
 * Servlet implementation class DashboardController
 */
public class DashboardController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private HttpSession session;
	private RequestDispatcher view;
	private String forward="", sessionStaffRole=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		sessionStaffRole = (String) session.getAttribute("sessionRole");
		
		if (sessionStaffRole.equalsIgnoreCase("Admin")) {
			request.setAttribute("totalDispatchers", DashboardDAO.countTotalDispatchers());
			request.setAttribute("totalActiveDispatchers", DashboardDAO.countTotalDispatchersByType("Active"));
			request.setAttribute("totalInactiveDispatchers", DashboardDAO.countTotalDispatchersByType("Inactive"));
            request.getRequestDispatcher("/courier.admin/adminDashboard.jsp").forward(request, response);
		} 
		else {
			request.setAttribute("totalParcels", DashboardDAO.countTotalDispatchers());
			request.setAttribute("totalUnreceivedParcels", DashboardDAO.countTotalDispatchersByType("Unreceived"));
			request.setAttribute("totalReceivedParcels", DashboardDAO.countTotalDispatchersByType("Received"));
            request.getRequestDispatcher("/courier.dispatcher/dispatcherDashboard.jsp").forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
