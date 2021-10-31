package controllers.admins.products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;
import utils.FileUtil;
@MultipartConfig
public class ControllersAdminProductsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminProductsAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		request.setAttribute("listCategories", new CategoriesDAO().findAll());
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		String picture = FileUtil.upload("picture", request);System.out.println(picture);
		String name = request.getParameter("name");
		String categories = request.getParameter("categories");
		String [] cutCategories = categories.split(",");
		int categories_id = Integer.parseInt(cutCategories[0]);
		String categories_name = cutCategories[1];
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		double promotion = Double.parseDouble(request.getParameter("promotion"));
		String descriptiondetail = request.getParameter("descriptiondetail");
		if(new ProductDAO().insertProduct(picture, name, categories_id, categories_name, description, price, promotion, descriptiondetail) > 0) {
			request.setAttribute("result", "1");
			request.setAttribute("listCategories", new CategoriesDAO().findAll());
			request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.setAttribute("listCategories", new CategoriesDAO().findAll());
			request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
		}
	}

}
