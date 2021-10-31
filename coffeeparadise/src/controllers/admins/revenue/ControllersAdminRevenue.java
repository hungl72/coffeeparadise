package controllers.admins.revenue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.RevenueDAO;

public class ControllersAdminRevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminRevenue() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("revenue", new RevenueDAO().revenue());
		request.setAttribute("revenueTo7Days", new RevenueDAO().revenueTo7Days());
		request.getRequestDispatcher("/views/admin/revenue/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
