package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BillDAO;

public class ControllersPublicCheckUndo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ControllersPublicCheckUndo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bill_id = Integer.parseInt(request.getParameter("bill_id"));
		new BillDAO().updateUndo(bill_id);
	}

}
