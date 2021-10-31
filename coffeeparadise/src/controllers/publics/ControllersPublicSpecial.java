package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.FavouriteDAO;
import models.Favourite;
import models.User;

public class ControllersPublicSpecial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicSpecial() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		request.setAttribute("listFavourite", new FavouriteDAO().findProductByUserId(user.getUser_id()));
		request.getRequestDispatcher("/views/public/special.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
