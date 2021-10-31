package controllers.admins.categories;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;

public class ControllersAdminCategoriesAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminCategoriesAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/views/admin/categories/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		if(new CategoriesDAO().insertCategories(name) > 0) {
			request.setAttribute("result", "1");
			request.getRequestDispatcher("/views/admin/categories/add.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/admin/categories/add.jsp").forward(request, response);
		}
	}

}
