package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.Product;

public class ControllersPublicAjaxProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersPublicAjaxProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		ProductDAO productDAO = new ProductDAO();
		int categories_id = Integer.parseInt(request.getParameter("categories_id"));
		request.setAttribute("listProduct", productDAO.listProductByCategories(categories_id));
		for(Product p : productDAO.listProductByCategories(categories_id)) {
			pw.write("\r\n"
					+ "              <div class=\"tm-product\">\r\n"
					+ "                <img style=\"width: 190px;height: 170px;\" src=\"/CoffeeParadise/templates/public/images/"+p.getProduct_image()+"\" alt=\"Product\">\r\n"
					+ "                <div class=\"tm-product-text\">\r\n"
					+ "				<a href=\"/CoffeeParadise/detail?product_id="+p.getProduct_id()+"\" style=\"text-decoration: none;\">"
					+ "                  <h3 class=\"tm-product-title\">"+p.getProduct_name()+"</h3></a>\r\n"
					+ "                  <p class=\"tm-product-description\">"+p.getProduct_description()+"</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"tm-product-price\">\r\n"
					+ "                  <a href=\"#\" class=\"tm-product-price-link tm-handwriting-font\"><span class=\"tm-product-price-currency\">$</span>"+p.getProduct_price()+"</a>\r\n"
					+ "                </div>\r\n"
					+ "              </div>\r\n"
					+ "              \r\n"
					+ "             	");
		}
	}

}
