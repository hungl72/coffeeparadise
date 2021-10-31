package controllers.publics;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.BillDAO;
import models.AutoMail;
import models.Bill;
import models.Cart;
import models.Item;
import models.Staff;
import models.User;

public class ControllersPublicPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicPay() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Staff staff = (Staff)session.getAttribute("staff");
		int staffId = 0;
		Bill bill = null;
		Cart cartProduct = (Cart)session.getAttribute("cartProduct");
		double money = 0;
		/*
		for(Map.Entry<Integer, Item> listItem : cartProduct.getCartItem().entrySet()) {
			new BillDAO().addBill(listItem.getValue().getProduct().getProduct_id(),
											    listItem.getValue().getProduct().getProduct_image(),
											    listItem.getValue().getProduct().getProduct_name(),
											    listItem.getValue().getProduct().getProduct_price(),
											    listItem.getValue().getProduct().getPromotion(),
											    listItem.getValue().getAmount(),
											    listItem.getValue().getMoney()*listItem.getValue().getAmount()-(listItem.getValue().getMoney()*listItem.getValue().getAmount()*listItem.getValue().getProduct().getPromotion()/100),
											    user.getUser_fullname(),
											    user.getUser_id(),
											    new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime()),
											    staffId = (staff != null)?staff.getStaff_id():1,
											    0);

		}*/
		int product_id = 0,product_amount = 0;String product_image = "",product_name = "";double product_price = 0,product_promotion = 0,product_money = 0;;
		for(Map.Entry<Integer, Item> listItem : cartProduct.getCartItem().entrySet()) {
			product_id += listItem.getValue().getProduct().getProduct_id();
			product_image +=  listItem.getValue().getProduct().getProduct_image()+",";
			product_name += listItem.getValue().getProduct().getProduct_name()+"("+listItem.getValue().getAmount()+" cốc)"+",";
			product_price += listItem.getValue().getProduct().getProduct_price();
			product_money += listItem.getValue().getMoney()*listItem.getValue().getAmount()-(listItem.getValue().getMoney()*listItem.getValue().getAmount()*listItem.getValue().getProduct().getPromotion()/100);
			//product_promotion += listItem.getValue().getProduct().getPromotion();
			product_amount += listItem.getValue().getAmount();
		}
		new BillDAO().addBill(product_id,
				product_image,
				product_name,
				0,
				product_promotion,
				product_amount,
				product_money,
			    user.getUser_fullname(),
			    user.getUser_id(),
			    new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime()),
			    staffId = (staff != null)?staff.getStaff_id():1,
			    0);
		AutoMail.sendMail(user.getUser_email(), "Don hang da dat thanh cong (Noreply - Day la email tu dong vui long khong phan hoi !)", "Don hang co "+cartProduct.getCartItem().size()+" san pham\nTong so tien ban can thanh toan la : "+cartProduct.totalMoney()+" $"+"\nChan thanh cam on quy khach da mua hang tai website cua chung toi !");
		session.removeAttribute("cartProduct");
		response.sendRedirect(request.getContextPath()+"/cart?nofication=true");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
