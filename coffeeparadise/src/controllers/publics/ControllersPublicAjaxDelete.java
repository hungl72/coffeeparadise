package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.FavouriteDAO;
import models.Cart;
import models.Favourite;
import models.Item;
import models.User;

public class ControllersPublicAjaxDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ControllersPublicAjaxDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		String idandname = request.getParameter("idandname");
		String [] split = idandname.split(",");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int user_id = Integer.parseInt(split[0]);
		String favourite_name = split[1];
		FavouriteDAO favouriteDAO = new FavouriteDAO();
		favouriteDAO.delProductByUserId(user_id,favourite_name);
		for(Favourite f : favouriteDAO.findProductByUserId(user_id)) {
			pw.print(" <tr>\r\n"
					+ "   <td>"+f.getProduct_id()+"</td>  \r\n"
					+ "   <td><img src=\"/CoffeeParadise/templates/public/images/"+f.getFavourite_image()+"\" alt=\"f.getFavourite_image()\" class=\"img-responsive\" style=\"width: 180px;height: auto;\"></td>\r\n"
					+ "   <td><p>"+f.getFavourite_name()+"</p></td> \r\n"
					+ "   <td data-th=\"Price\">"+f.getFavourite_price()+"</td> \r\n"
					+ "   <td data-th=\"Quantity\">"+f.getFavourite_promotion()+"</td> \r\n"
					+ "   <td class=\"actions\" data-th=\"\">\r\n"
					+ "    <button class=\"btn btn-danger\" onclick=\"myFunction('"+user.getUser_id()+","+f.getFavourite_name()+"')\"><i class=\"fa fa-trash-o\"></i>\r\n"
					+ "    </button>\r\n"
					+ "   </td> \r\n"
					+ "  </tr>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		Cart cartProduct = (Cart)session.getAttribute("cartProduct");
		cartProduct.del(Integer.parseInt(request.getParameter("product_id")));
		if(cartProduct.getCartItem().size() > 0) {
		for(Map.Entry<Integer, Item> list : cartProduct.getCartItem().entrySet()){
			pw.write("<tr>  \r\n"
					+ "   <td><img src=\"/CoffeeParadise/templates/public/images/"+list.getValue().getProduct().getProduct_image()+"\" alt=\"list.getValue().getProduct().getProduct_name()\" class=\"img-responsive\" style=\"width: 180px;height: auto;\"></td>\r\n"
					+ "   <td><p>"+list.getValue().getProduct().getProduct_name()+"</p></td> \r\n"
					+ "   <td data-th=\"Price\">"+list.getValue().getMoney()*(100-list.getValue().getProduct().getPromotion())/100+"</td> \r\n"
					+ "   <td data-th=\"Quantity\">"+list.getValue().getAmount()+"</td> \r\n"
					+ "   <td data-th=\"Subtotal\" class=\"text-center\">"+list.getValue().getAmount() * list.getValue().getMoney()*(100-list.getValue().getProduct().getPromotion())/100+"</td>\r\n"
					+ "   <td class=\"actions\" data-th=\"\">\r\n"
					+ "    <button class=\"btn btn-danger\" onclick=\"myFunction("+list.getKey()+")\"><i class=\"fa fa-trash-o\"></i>\r\n"
					+ "    </button>\r\n"
					+ "   </td> \r\n"
					+ "  </tr>\r\n");
			}
		}else {
			pw.write("<tr>\r\n"
					+ "              <td colspan=\"6\">\r\n"
					+ "              <img src=\"/CoffeeParadise/templates/public/images/unnamed.png\"/>\r\n"
					+ "              <h3>Bạn đã xóa hết sản phẩm</h3>\r\n"
					+ "              </td>\r\n"
					+ "            </tr>");
		}
	}

}
