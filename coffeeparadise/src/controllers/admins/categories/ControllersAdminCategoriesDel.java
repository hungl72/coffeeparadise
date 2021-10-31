package controllers.admins.categories;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CategoriesDAO;

public class ControllersAdminCategoriesDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminCategoriesDel() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		new CategoriesDAO().delCategories(id);
		response.sendRedirect(request.getContextPath()+"/admincategories");
		HttpSession session = request.getSession();
		if(session.getAttribute("staff") == null) {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
