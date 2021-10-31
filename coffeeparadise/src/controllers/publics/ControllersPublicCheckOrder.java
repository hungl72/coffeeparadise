package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BillDAO;

public class ControllersPublicCheckOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicCheckOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bill_id = Integer.parseInt(request.getParameter("bill_id"));
		BillDAO billDAO =  new BillDAO();
		if(billDAO.checkStatus(bill_id) == 2) {
			billDAO.updateCancel(bill_id);
		}else if(billDAO.checkStatus(bill_id) == 0){
			billDAO.updateCancell(bill_id);
		}
	}

}
