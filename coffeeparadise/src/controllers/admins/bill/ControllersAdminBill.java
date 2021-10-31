package controllers.admins.bill;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.BillDAO;
import models.Bill;
import models.Staff;
import utils.DefineUtil;

public class ControllersAdminBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ControllersAdminBill() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BillDAO billDAO = new BillDAO();
		HttpSession session = request.getSession();
		Staff staff = (Staff)session.getAttribute("staff");
		int currentPage = 1;
		int numberOfItems = 0;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			currentPage = 1;
		}
		if(staff.getPer_name().equals("Administrator")) {
			numberOfItems = billDAO.findAll().size();
		}else {
			numberOfItems = billDAO.findAllStaff(staff.getStaff_id()).size();
		}
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<Bill> listBill = billDAO.getItemPagination(offset);
		ArrayList<Bill> listBillStaff = billDAO.getItemPaginationByStaff(offset, staff.getStaff_id());
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listBill", listBill);
		request.setAttribute("listBillStaff", listBillStaff);
		if(session.getAttribute("staff") == null) {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/admin/bill/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
