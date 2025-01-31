package courier.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import courier.dao.DispatcherDAO;
import courier.model.Dispatcher;

/**
 * Servlet implementation class UpdateDispatcherTempController
 */
@WebServlet("/UpdateDispatcherTempController")
public class UpdateDispatcherTempController extends HttpServlet {
	private static final long serialVersionUId = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDispatcherTempController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dispatcher dispatcher = new Dispatcher();
		
		dispatcher.setDispatcherEmploymentType(request.getParameter("dispatcherEmploymentType"));
		dispatcher.setDispatcherStatus(request.getParameter("dispatcherStatus"));
		dispatcher.setStaffId(Integer.parseInt(request.getParameter("staffId")));
		
		DispatcherDAO.updateDispatcher(dispatcher);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
