package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.UserDAO;
import models.User;

public class ControllersPublicLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		request.getRequestDispatcher("/views/public/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		UserDAO userDAO = new UserDAO();
		User u = userDAO.login(email, pass);
		if(u != null) {
			userDAO.updateStatusLogin(u.getUser_id());
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.sendRedirect(request.getContextPath()+"/index");
		}else {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/public/login.jsp").forward(request, response);
		}
	}

}
