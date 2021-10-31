package controllers.admins.bill;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BillDAO;
import models.Bill;
import utils.DefineUtil;

public class ControllersAdminBillAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ControllersAdminBillAuto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<Bill> listBill = new BillDAO().getItemPagination((Integer.parseInt(request.getParameter("bill_id")) - 1) * DefineUtil.NUMBER_PER_PAGE);
		for(Bill bill : listBill) {
				response.getWriter().write("<tr><td>"+bill.getBill_id()+"</td>\r\n" + 
						"<td>"+bill.getBill_product_name()+"</td>\r\n" + 
						"<td>"+bill.getBill_product_amount()+"</td>\r\n" + 
						"<td>"+bill.getBill_product_money()+"</td>\r\n" + 
						"<td>"+bill.getUser_fullname()+"</td>\r\n" + 
						"<td>"+bill.getUser_id()+"</td>\r\n" +
						"<td>"+bill.getDate()+"</td>\r\n" + 
						""+((bill.getStatus() == 0)?"<td id=\"\"><input id=\"checkbill.getBill_id()\" type=\"checkbox\" onclick=\"requestApproval("+bill.getBill_id()+")\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\"></td>":(bill.getStatus() == 8)?"<td id=\"\" style=\"background-color: #ddd;cursor: not-allowed;\"><input type=\"checkbox\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\" disabled></td>":(bill.getStatus() == 2)?"<td id=\"\"><input type=\"checkbox\" checked=\"checked\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\"></td>":(bill.getStatus() == 7)?"<td id=\"\" style=\"background-color: #ddd;cursor: not-allowed;\"><input type=\"checkbox\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\" disabled></td>":(bill.getStatus() == 6)?"<td id=\"\"><input type=\"checkbox\" checked=\"checked\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\" disabled></td>":(bill.getStatus() == 5)?"<td id=\"\"><input type=\"checkbox\" checked=\"checked\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\"></td>":"<td id=\"\"><input type=\"checkbox\" checked=\"checked\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\"></td>")+"r\n"+
						""+(bill.getStatus() == 1?" <td><h6 style=\"color: #1769ff;font-weight: bold;\">Ship thành công</h6></td>":(bill.getStatus() == 0)?"<td style=\"color: red;font-weight: bold;\">Chưa chốt đơn !</td>":(bill.getStatus() == 8)?"<td id=\"\" style=\"background-color: #ddd;cursor: not-allowed;\"><input type=\"checkbox\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\" disabled></td>":(bill.getStatus() == 7)?"<td style=\"color: red;font-weight: bold;\">Người dùng yêu cầu hủy đơn !</td>":(bill.getStatus() == 6)?"<td style=\"color: red;font-weight: bold;\">Đơn hàng đã bị hủy !</td>":(bill.getStatus() == -1)?"<td style=\"color: red;font-weight: bold;\">Đơn hàng đã bị hủy bởi người quản trị !</td>":"<td id=\"change\"><input id=\"checkbill.getBill_id()\" type=\"checkbox\" onclick=\"checkBill("+bill.getBill_id()+")\" data-toggle=\"toggle\" data-onstyle=\"success\" data-offstyle=\"danger\"></td>")+""+
						""+((bill.getStatus() == 3)?"<td><a href=\"javascript:void(0)\" onclick=\"checkRequest("+bill.getBill_id()+")\">Khách yêu cầu hủy đơn</a></td>":(bill.getStatus() == 8)?"<td><a href=\"javascript:void(0)\" onclick=\"checkRequest("+bill.getBill_id()+")\">Khách yêu cầu hủy đơn</a></td>":(bill.getStatus() == 7)?"<td><a href=\"javascript:void(0)\" onclick=\"checkRequest(<%=bill.getBill_id()%>)\">Khách yêu cầu hủy đơn</a></td>":(bill.getStatus() == 6)?"<td><h6 style=\"color: blue;font-weight: bold;\">Yêu cầu được chấp nhận !</h6></td>":(bill.getStatus() == 5)?"<td><h6 style=\"color: #993300;font-weight: bold;\">Yêu cầu bị từ chối !</h6></td>":"<td></td>")+"</tr>");
		}
	}
}
