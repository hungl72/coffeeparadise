package controllers.publics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;

public class ControllersPublicMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicMenu() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriesDAO categoriesDAO  = new CategoriesDAO();
		ProductDAO productDAO = new ProductDAO();
		int categories_id = 1;
		request.setAttribute("listProduct", productDAO.listProductByCategories(categories_id));
		request.setAttribute("listCategories", categoriesDAO.listCategories());
		request.getRequestDispatcher("/views/public/menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
