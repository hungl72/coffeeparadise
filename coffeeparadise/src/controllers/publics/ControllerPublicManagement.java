package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ManagementDAO;
import models.User;

public class ControllerPublicManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerPublicManagement() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = 0;
		try {
				User user = (User)request.getSession().getAttribute("user");
				user_id = user.getUser_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listOrder", new ManagementDAO().listOrder(user_id));
		request.getRequestDispatcher("/views/public/management.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
