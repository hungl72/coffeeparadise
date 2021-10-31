package controllers.admins.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

public class ControllersAdminMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if((User)session.getAttribute("user") == null) {
			request.setAttribute("fullMessage", new MessageDAO().findAll(0));
		}else {
			User u = (User)session.getAttribute("user");
		request.setAttribute("fullMessage", new MessageDAO().findAll(u.getUser_id()));
		}
		request.setAttribute("checkStatus", new MessageDAO().checkStatus());
		request.getRequestDispatcher("/views/admin/message/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<Message> arrMessage = new ArrayList<Message>();
		PrintWriter print = response.getWriter();
		HttpSession session = request.getSession();
		Staff s = (Staff)session.getAttribute("staff");
		User u = (User)session.getAttribute("user");
		int id_user = 0;
		try {
			if(Integer.parseInt(request.getParameter("id")) != 0) {
				id_user = Integer.parseInt(request.getParameter("id"));
			}
		} catch (Exception e) {
			id_user = 0;
		}
		String name = request.getParameter("username");
		String message = request.getParameter("message");
		try {
		new MessageDAO().insertMessage(message, new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Timestamp(new Date().getTime())),name,id_user);
		}catch(Exception e) {}
		arrMessage = new MessageDAO().findAll(id_user);
		for(Message m : arrMessage) {
			if(m.getName().equals("Administrator") || m.getName().equals("Admin") || m.getName().equals("Moderator") || m.getName().equals("Staff")){
				print.write("<div class=\"incoming_msg\">\r\n"
						+ "              <div class=\"incoming_msg_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>\r\n"
						+ "              <div class=\"received_msg\">\r\n"
						+ "                <div class=\"received_withd_msg\">\r\n"
						+ "                  <p>"+m.getMessage_sent()+"</p>\r\n"
						+ "                  <span class=\"time_date\">"+m.getMessage_time_sent()+"</span></div>\r\n"
						+ "              </div>\r\n"
						+ "            </div>");
			}else {
				print.write("<div class=\"outgoing_msg\">\r\n"
						+ "              <div class=\"sent_msg\">\r\n"
						+ "                <p>"+m.getMessage_sent()+"</p>\r\n"
						+ "                <span class=\"time_date\">"+m.getMessage_time_sent()+"</span> </div>\r\n"
						+ "            </div>");
			}
		}
	}
}
