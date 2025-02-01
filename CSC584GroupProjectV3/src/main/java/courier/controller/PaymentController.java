package courier.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import courier.dao.PaymentDAO;
import courier.dao.PaymentDAO;
import courier.model.Payment;
import courier.dao.PaymentDAO;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUId = 1L;
	private RequestDispatcher view;
	private int paymentId;
	private String action="", forward="";
	private static String LIST = "/courier.payment/paymentList.jsp";
	private static String UPDATE = "/courier.payment/updatePayment.jsp";
	private static String VIEW = "/courier.payment/viewPayment.jsp";
	private static String ADD = "/courier.payment/addPayment.jsp";	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");

		//view all payments
		if(action.equalsIgnoreCase("listPayments")) {
			System.out.println("LIST");
			forward = LIST;
			request.setAttribute("payments", PaymentDAO.getAllPayments());        
		}		
		else if(action.equalsIgnoreCase("addPayment")) {
			forward = ADD;
		}
		else if(action.equalsIgnoreCase("viewPayment")) {
			forward = VIEW;
			paymentId = Integer.parseInt(request.getParameter("paymentId"));
			request.setAttribute("payment", PaymentDAO.getPaymentById(paymentId));
		}	
		else if(action.equalsIgnoreCase("updatePayment")) { 
			forward = UPDATE;
			paymentId = Integer.parseInt(request.getParameter("paymentId"));
			request.setAttribute("payment", PaymentDAO.getPaymentById(paymentId));	        
		}
		else if(action.equalsIgnoreCase("deletePayment")) {
			forward = LIST;
			paymentId = Integer.parseInt(request.getParameter("paymentId"));
			PaymentDAO.deletePayment(paymentId);
			request.setAttribute("payments", PaymentDAO.getAllPayments());        
		}

		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Payment payment = new Payment();

		payment.setPaymentAmount(Double.parseDouble(request.getParameter("paymentAmount")));
		payment.setPaymentDate(request.getParameter("paymentDate"));
		payment.setPaymentStatus(request.getParameter("paymentStatus"));
		payment.setParcelId(Integer.parseInt(request.getParameter("parcelId")));
		
		String paymentId = request.getParameter("paymentId");

		if(paymentId != null) {
			payment.setPaymentId(Integer.parseInt(request.getParameter("paymentId")));
			PaymentDAO.updatePayment(payment);
		} else {
			PaymentDAO.addPayment(payment);
		}

		forward = LIST;
		request.setAttribute("payments", PaymentDAO.getAllPayments()); 
		view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
