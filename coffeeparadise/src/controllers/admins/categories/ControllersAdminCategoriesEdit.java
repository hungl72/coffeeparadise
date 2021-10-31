package controllers.admins.categories;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CategoriesDAO;
import models.Categories;

public class ControllersAdminCategoriesEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminCategoriesEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.setAttribute("result", "0");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("categories", new CategoriesDAO().categories(id));
		request.getRequestDispatcher("/views/admin/categories/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		if(new CategoriesDAO().updateCategories(id,name) > 0) {
			request.setAttribute("result", "1");
		}else {
			request.setAttribute("result", "-1");
		}
		request.setAttribute("categories", new CategoriesDAO().categories(id));
		request.getRequestDispatcher("/views/admin/categories/edit.jsp").forward(request, response);
	}

}
