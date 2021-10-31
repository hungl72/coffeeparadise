package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CommentDAO;
import daos.ProductDAO;
import models.Comment;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublicCommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<Comment> arrComment = new ArrayList<Comment>();
		PrintWriter print = response.getWriter();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		String name = request.getParameter("name");
		String commentarea = request.getParameter("comment");
		new CommentDAO().insertComment(name, commentarea, new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime()),new ProductDAO().findNameProductByProductId(product_id).getProduct_name(),product_id);
		arrComment = new CommentDAO().findAll(product_id);
		for(Comment comment : arrComment) {
		print.write(comment.getDetail()+" - Bởi : "+comment.getUser()+" - Lúc "+comment.getTime()+"<br />");
		}
	}

}
