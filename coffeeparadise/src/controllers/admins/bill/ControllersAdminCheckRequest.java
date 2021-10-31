package controllers.admins.bill;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BillDAO;

public class ControllersAdminCheckRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminCheckRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bill_id = Integer.parseInt(request.getParameter("bill_id"));
		new BillDAO().updateRefuse(bill_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bill_id = Integer.parseInt(request.getParameter("bill_id"));
		new BillDAO().updateRequest(bill_id);
	}

}