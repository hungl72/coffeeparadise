package controllers.publics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ContactDAO;
import models.User;

public class ControllersPublicContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		request.getRequestDispatcher("/views/public/contact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int result = new ContactDAO().addContact(name, phone, title, content,user.getUser_email());
		if(result > 0) {
			request.getRequestDispatcher("/views/public/success.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/public/contact.jsp").forward(request, response);
		}		
	}

}
