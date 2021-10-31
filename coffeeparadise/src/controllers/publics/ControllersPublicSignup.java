package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDAO;

public class ControllersPublicSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ControllersPublicSignup() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		request.getRequestDispatcher("/views/public/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(new UserDAO().signup(name, email, pass) > 0) {
			request.setAttribute("result", "1");
			request.getRequestDispatcher("/views/public/login.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/public/signup.jsp").forward(request, response);
		}
	}

}
