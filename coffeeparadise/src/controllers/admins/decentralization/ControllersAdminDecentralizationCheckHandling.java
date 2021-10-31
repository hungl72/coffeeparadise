package controllers.admins.decentralization;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.PermisionDAO;
import models.Permision;

public class ControllersAdminDecentralizationCheckHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminDecentralizationCheckHandling() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");System.out.println("value "+value);
		String [] cutValue = value.split(",");
		int check = Integer.parseInt(cutValue[0]);
		String checkk = cutValue[0];
		String action = cutValue[1];
		int staff_id  = Integer.parseInt(cutValue[2]);
		new PermisionDAO().updateCheck(check==1?0:1, action, staff_id);
	}
}
