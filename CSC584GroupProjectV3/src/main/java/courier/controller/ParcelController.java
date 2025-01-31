package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import courier.dao.ParcelDAO;

/**
 * Servlet implementation class ParcelController
 */
public class ParcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view;
	private int parcelId;
	private String action="", forward="";
	private static String LIST = "scansort.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParcelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		//view all parcels
		if(action.equalsIgnoreCase("listParcels")) {
			System.out.println("LIST");
			forward = LIST;
			request.setAttribute("parcels", ParcelDAO.getAllParcels());        
		}		

		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
