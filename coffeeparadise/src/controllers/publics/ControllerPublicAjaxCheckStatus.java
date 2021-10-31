package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.MessageDAO;
import models.User;

public class ControllerPublicAjaxCheckStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerPublicAjaxCheckStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		MessageDAO messageDAO = new MessageDAO();
		if(messageDAO.checkStatus().size() != 0) {
		for(User user : messageDAO.checkStatus()) {
			response.getWriter().print("<div class=\"chat_list active_chat\">\r\n"
					+ "              <div class=\"chat_people\">\r\n"
					+ "                <div class=\"chat_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>\r\n"
					+ "                <div class=\"chat_ib\">\r\n"
					+ "                  <a href=\"javascript:void(0)\" style=\"text-decoration: none;\" onclick=\"loadChat("+"'"+user.getUser_id()+"'"+")\" ><h5 class=\"contentMess\">"+user.getUser_fullname()+"<span class=\"chat_date\"></span></h5>\r\n</a>\r\n"
					+"						<input type=\"hidden\" id=\""+user.getUser_id()+"\" value=\""+user.getUser_id()+"\"/>"
					+ "                </div>\r\n"
					+ "              </div>     \r\n"
					+ "            </div>");
		}
	}else {
		response.getWriter().print("<h5 style=\"font-weight: bold;\">Không có khách hàng nào online !</h5>\r\n");
		}
	}
}
