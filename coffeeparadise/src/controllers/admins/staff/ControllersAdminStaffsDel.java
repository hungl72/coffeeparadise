package controllers.admins.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import daos.StaffDAO;

public class ControllersAdminStaffsDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminStaffsDel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new StaffDAO().delProduct(id);
		response.sendRedirect(request.getContextPath()+"/adminstaff");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
