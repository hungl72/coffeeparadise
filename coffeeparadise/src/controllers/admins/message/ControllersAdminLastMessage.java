package controllers.admins.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.MessageDAO;
import models.Message;
import models.Staff;
import models.User;

public class ControllersAdminLastMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminLastMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		/*
		User user = (User)request.getSession().getAttribute("user");
		Staff staff = (Staff)request.getSession().getAttribute("staff");
		Message message = new MessageDAO().lastMessage(user.getUser_id());
		response.getWriter().print("<p>"+new MessageDAO().lastMessage(user.getUser_id()).getMessage_sent()+"</p>\r\n"
				+ "	                  <span class=\"time_date\">"+new MessageDAO().lastMessage(user.getUser_id()).getMessage_time_sent()+"</span>");
				*/
	}

}