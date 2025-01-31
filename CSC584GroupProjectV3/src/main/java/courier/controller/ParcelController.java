package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import courier.dao.ParcelDAO;
import courier.model.Parcel;

/**
 * Servlet implementation class ParcelController
 */
public class ParcelController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private RequestDispatcher view;
	private int parcelId;
	private String action="", forward="";
	private static String LIST = "scansort.jsp";
	private static String UPDATE = "updateParcel.jsp";
	private static String VIEW = "viewParcel.jsp";	
       
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

		if(action.equalsIgnoreCase("listParcels")) {
			forward = LIST;
			request.setAttribute("parcels", ParcelDAO.getAllParcels());        
		} 
		if(action.equalsIgnoreCase("viewParcel")) {
			forward = VIEW;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));
		}	
		if(action.equalsIgnoreCase("updateParcel")) { 
			forward = UPDATE;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));	        
		}
		if(action.equalsIgnoreCase("deleteParcel")) {
			forward = LIST;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			ParcelDAO.deleteParcel(parcelId);
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
		Parcel parcel = new Parcel();

		parcel.setParcelName(request.getParameter("parcelName"));
		parcel.setParcelAddress(request.getParameter("parcelAddress"));
		parcel.setParcelWeight(Double.parseDouble(request.getParameter("parcelWeight")));
		parcel.setParcelStatus(request.getParameter("parcelStatus"));
		parcel.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		
		String parcelId = request.getParameter("parcelId");

		if(parcelId != null) {
			parcel.setParcelId(Integer.parseInt(request.getParameter("parcelId")));
			ParcelDAO.updateParcel(parcel);
		} else {
			ParcelDAO.addParcel(parcel);
		}

		forward = LIST;
		request.setAttribute("parcels", ParcelDAO.getAllParcels()); 
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
