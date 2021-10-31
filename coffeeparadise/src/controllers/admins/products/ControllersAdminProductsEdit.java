package controllers.admins.products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;
import models.Product;
import utils.FileUtil;
@MultipartConfig
public class ControllersAdminProductsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminProductsEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.setAttribute("result", "0");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("listCategories", new CategoriesDAO().findAll());
		request.setAttribute("product", new ProductDAO().findProductByProductId(id));
		request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		String picture = FileUtil.upload("picture", request);System.out.println(picture);
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		try {
			if("".equals(picture)) {
				Product product = new ProductDAO().findProductDetailByProductId(product_id);
				picture= product.getProduct_image();
			}
		} catch (Exception e) {

		}
		String name = request.getParameter("name");
		String categories = request.getParameter("categories");
		String [] cutCategories = categories.split(",");
		int categories_id = Integer.parseInt(cutCategories[0]);
		String categories_name = cutCategories[1];
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		double promotion = Double.parseDouble(request.getParameter("promotion"));
		String descriptiondetail = request.getParameter("descriptiondetail");
		if(new ProductDAO().updateProduct(picture, name, categories_id, categories_name, description, price, promotion, descriptiondetail, product_id) > 0) {
			request.setAttribute("result", "1");
			request.setAttribute("product_id", product_id);
			request.setAttribute("listCategories", new CategoriesDAO().findAll());
			request.setAttribute("product", new ProductDAO().findProductByProductId(product_id));
			request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.setAttribute("product_id", product_id);
			request.setAttribute("listCategories", new CategoriesDAO().findAll());
			request.setAttribute("product", new ProductDAO().findProductByProductId(product_id));
			request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
		}
	}

}
