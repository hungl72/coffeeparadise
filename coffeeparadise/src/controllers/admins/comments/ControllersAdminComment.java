package controllers.admins.comments;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.CommentDAO;
import models.Bill;
import models.Comment;
import utils.DefineUtil;

public class ControllersAdminComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentDAO commentDAO = new CommentDAO();
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			currentPage = 1;
		}
		int numberOfItems = commentDAO.findAllComment().size();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);System.out.println("numberofpage"+numberOfPages+"numberofitem"+numberOfItems);
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Comment> listComment = commentDAO.getItemPagination(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listComment", listComment);
		HttpSession session = request.getSession();
		if(session.getAttribute("staff") == null) {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/admin/comment/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}