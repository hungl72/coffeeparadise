package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.FavouriteDAO;
import models.Product;
import models.User;

public class ControllersPublicAjaxFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicAjaxFavourite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Product product = null;
		FavouriteDAO favouriteDAO = new FavouriteDAO();
		product = favouriteDAO.findProduct(product_id);
		favouriteDAO.addFavourite(product.getProduct_name(), product.getProduct_price(), product.getPromotion(), product.getProduct_image(), product.getProduct_id(), user.getUser_id());
	}

}
