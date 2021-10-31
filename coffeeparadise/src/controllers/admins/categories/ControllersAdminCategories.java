package controllers.admins.categories;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CategoriesDAO;
import daos.PermisionDAO;
import models.Bill;
import models.Categories;
import models.Staff;
import utils.DefineUtil;

public class ControllersAdminCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminCategories() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			currentPage = 1;
		}
		int numberOfItems = categoriesDAO.findAll().size();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);System.out.println("numberofpage"+numberOfPages+"numberofitem"+numberOfItems);
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Categories> listCategories = categoriesDAO.getItemPagination(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listCategories", listCategories);
		request.setAttribute("result", "0");
		HttpSession session = request.getSession();
		Staff s = (Staff)session.getAttribute("staff");
		request.setAttribute("listPermision", new PermisionDAO().listPermision(s.getPer_id()));
		if(session.getAttribute("staff") == null) {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/admin/categories/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
