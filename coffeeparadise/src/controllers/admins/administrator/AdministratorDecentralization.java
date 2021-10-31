package controllers.admins.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.PermisionDAO;
import daos.StaffDAO;
import models.Staff;

public class AdministratorDecentralization extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdministratorDecentralization() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Staff staff = (Staff)session.getAttribute("staff");
		request.setAttribute("listStaff", new StaffDAO().listDecentralization());
		try {
			request.setAttribute("listPermision", new PermisionDAO().listPermision(staff.getPer_id()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("listUser", new PermisionDAO().listUser());
		if(session.getAttribute("staff") == null) {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/admin/decentralization/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
