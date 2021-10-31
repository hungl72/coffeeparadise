package controllers.publics;

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

import daos.CommentDAO;
import daos.ProductDAO;
import models.Comment;
import models.Message;
import models.Staff;
import models.User;
import daos.MessageDAO;

public class PublicMessageControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PublicMessageControllers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<Message> arrMessage = new ArrayList<Message>();
		PrintWriter print = response.getWriter();
		HttpSession session = request.getSession();
		Staff s = (Staff)session.getAttribute("staff");
		User u = (User)session.getAttribute("user");
		int id_user = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("username");
		String message = request.getParameter("message");
		new MessageDAO().insertMessage(message, new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Timestamp(new Date().getTime())),name,id_user);
		arrMessage = new MessageDAO().findAll(id_user);
		for(Message m : arrMessage) {
			if(m.getName().equals("Administrator") || m.getName().equals("Admin") || m.getName().equals("Moderator") || m.getName().equals("Staff")){
				print.write("                    <div class=\"row msg_container base_sent\">\r\n"
						+ "                        <div class=\"col-md-10 col-xs-10\">\r\n"
						+ "                            <div class=\"messages msg_sent\">\r\n"
						+ "                                <p>"+m.getMessage_sent()+"</p>\r\n"
						+ "                                <time datetime=\"2009-11-13T20:00\">"+m.getMessage_time_sent()+"</time>\r\n"
						+ "                            </div>\r\n"
						+ "                        </div>\r\n"
						+ "                        <div class=\"col-md-2 col-xs-2 avatar\">\r\n"
						+ "                            <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\" class=\" img-responsive \">\r\n"
						+ "                        </div>\r\n"
						+ "                    </div>");
			}else {
				print.write("<div class=\"row msg_container base_receive\">\r\n"
						+ "                        <div class=\"col-md-2 col-xs-2 avatar\">\r\n"
						+ "                            <img src=\"http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg\" class=\" img-responsive \">\r\n"
						+ "                        </div>\r\n"
						+ "                        <div class=\"col-md-10 col-xs-10\">\r\n"
						+ "                            <div class=\"messages msg_receive\">\r\n"
						+ "                                <p>"+m.getMessage_sent()+"</p>\r\n"
						+ "                                <time datetime=\"2009-11-13T20:00\">"+m.getMessage_time_sent()+"</time>\r\n"
						+ "                            </div>\r\n"
						+ "                        </div>\r\n"
						+ "                    </div>");
			}
		}
	}

}