package controllers.admins.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.StaffDAO;
import models.Staff;

public class ControllersAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Staff staff = new StaffDAO().login(email, pass);
		if(staff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("staff", staff);
			response.sendRedirect(request.getContextPath()+"/administratorindex");
		}else {
				request.setAttribute("result", "1");
				request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
	}

}
