package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import courier.dao.ParcelDAO;
import courier.dao.StaffDAO;
import courier.model.Parcel;

/**
 * Servlet implementation class ParcelController
 */
public class ParcelController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private RequestDispatcher view;
	private int parcelId;
	private String action="", forward="";
	private static String LIST = "/courier.parcel/scansort.jsp";
	private static String UPDATE = "/courier.parcel/updateParcel.jsp";
	private static String VIEW = "/courier.parcel/viewParcel.jsp";
	private static String CUSTOMER_VIEW = "/courier.parcel/customerViewParcel.jsp";
	private static String ADD = "/courier.parcel/addParcel.jsp";	
       
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
		action = request.getParameter("action");

		if(action.equalsIgnoreCase("listParcels")) {
			forward = LIST;
			request.setAttribute("parcels", ParcelDAO.getAllParcels());        
		}
		else if(action.equalsIgnoreCase("addParcel")) {
			forward = ADD;
		}
		else if(action.equalsIgnoreCase("viewParcel")) {
			forward = VIEW;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));
		}	
		else if(action.equalsIgnoreCase("updateParcel")) { 
			forward = UPDATE;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));	        
		}
		else if(action.equalsIgnoreCase("deleteParcel")) {
			forward = LIST;
			parcelId = Integer.parseInt(request.getParameter("parcelId"));
			ParcelDAO.deleteParcel(parcelId);
			request.setAttribute("parcels", ParcelDAO.getAllParcels());        
		}
		else if(action.equalsIgnoreCase("searchParcel")) {
			forward = VIEW;
			parcelId = Integer.parseInt(request.getParameter("parcelSearch"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));
		}
		else if(action.equalsIgnoreCase("customerSearchParcel")) {
			forward = CUSTOMER_VIEW;
			parcelId = Integer.parseInt(request.getParameter("parcelSearch"));
			request.setAttribute("parcel", ParcelDAO.getParcelById(parcelId));
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
			parcel.setParcelId(Integer.parseInt(parcelId));
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
