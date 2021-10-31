package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Staff;

public class ControllerPublicAjaxLoadHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerPublicAjaxLoadHeader() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff staff = (Staff)request.getSession().getAttribute("staff");
		response.getWriter().print("			if(session.getAttribute(\""+staff+"\") != null){\r\n"
				+ "				"+staff+" = (Staff)session.getAttribute(\""+staff+"\");\r\n"
				+ "			}");
	}

}
