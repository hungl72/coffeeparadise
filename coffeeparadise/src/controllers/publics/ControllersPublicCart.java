package controllers.publics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ProductDAO;
import models.Cart;
import models.Item;
import models.Product;

public class ControllersPublicCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/public/cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		int productid = Integer.parseInt(request.getParameter("productid"));
		int amount = Integer.parseInt(request.getParameter("quantity1"));
		double price = Double.parseDouble(request.getParameter("price"));
		double total = Double.parseDouble(request.getParameter("total"));
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cartProduct");
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.findProductByProductId(productid);
			if(cart.getCartItem().containsKey(productid)){
				cart.add(productid, new Item(product,cart.getCartItem().get(productid).getAmount()+amount,cart.getCartItem().get(productid).getMoney()));
					//productDAO.amountDatabaseAfterAddCart(productDetail.getProduct_detail_id());
				}else {
					cart.add(productid, new Item(product,amount,product.getProduct_price()));
					//productDAO.amountDatabaseAfterAddCart(productDetail.getProduct_detail_id());
				}
		session.setAttribute("cartProduct", cart);
		//response.sendRedirect(request.getContextPath()+"/detailproduct?product_id="+productDetail.getProduct_detail_id()+"&&parent_id="+productDetail.getCategories_id());
		response.sendRedirect(request.getContextPath()+"/cart");
	}

}
