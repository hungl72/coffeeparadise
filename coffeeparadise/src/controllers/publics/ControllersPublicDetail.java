package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CommentDAO;
import daos.MessageDAO;
import daos.ProductDAO;
import daos.StarDAO;
import models.Staff;
import models.User;

public class ControllersPublicDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		ProductDAO productDAO = new ProductDAO();
		HttpSession session = request.getSession();
		Staff s = (Staff)session.getAttribute("staff");
		User u = (User)session.getAttribute("user");
		productDAO.updateView(product_id);
		request.setAttribute("productDetail", productDAO.findProductByProductId(product_id));
		request.setAttribute("fullComment", new CommentDAO().findAll(product_id));
		request.setAttribute("selectValueFinal", new StarDAO().selectValueFinal(product_id));
		request.setAttribute("findAll", new MessageDAO().findAll(u.getUser_id()));
		request.setAttribute("fullMessage", new MessageDAO().findAll(u.getUser_id()));
		request.getRequestDispatcher("/views/public/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
