package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ManagementDAO;
import models.Management;
import models.User;

public class ControllersPublicManagementAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersPublicManagementAuto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		User user = (User)request.getSession().getAttribute("user");
		int user_id = 0;
		try {
			user_id = user.getUser_id();
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(Management m : new ManagementDAO().listOrder(user_id)) {
			response.getWriter().print(
					"</tr><tr>\r\n" + 
					"<td>"+m.getBill_id()+"</td>\r\n" + 
					"<td>"+m.getList_product()+"</td>\r\n" + 
					"<td>"+m.getAmount()+"</td>\r\n" + 
					"<td>"+m.getMoney()+"</td>\r\n" + 
					"<td>"+m.getDate()+"</td>\r\n" + 
					"<td>"+m.getDate()+"</td>\r\n" + 
					""+((m.getState() == 1)?"<td><a href=\"javascript:void(0)\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-success\">Đã thanh toán</button></a></td><td></td>":(m.getState() == -1)?"<td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-basic\">Đơn hàng bị hủy</button></a></td><td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-danger\">Hết hàng</button></a></td>":(m.getState() == 0)?"<td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-warning\">Đang chờ xử lý</button></a></td><td><a href=\"javascript:void(0)\" onclick=\"checkorder("+m.getBill_id()+")\"><button class=\"btn btn-danger\">Hủy đơn hàng</button></a></td>":(m.getState() == 2)?" <td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-primary\">Đang vận chuyển</button></a></td><td><a href=\"javascript:void(0)\" onclick=\"checkorder("+m.getBill_id()+")\"><button class=\"btn btn-danger\">Hủy đơn hàng</button></a></td>":(m.getState() == 3)?"<td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-basic\">Đã yêu cầu hủy đơn</button></a></td><td><a href=\"javascript:void(0)\" onclick=\"checkundo("+m.getBill_id()+")\"><button class=\"btn btn-default\">Hoàn tác yêu cầu</button></a></td>":(m.getState() == 4)?" <td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-basic\">Đơn hàng bị hủy</button></a></td><td><a href=\"javascript:void(0)\" onclick=\"checkundo("+m.getBill_id()+")\"><button class=\"btn btn-default\">Hoàn tác yêu cầu</button></a></td>":(m.getState() == 8)?"<td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-basic\">Đã yêu cầu hủy đơn</button></a></td><td><a href=\"javascript:void(0)\" onclick=\"checkundo(\"+m.getBill_id()+\")\"><button class=\"btn btn-default\">Hoàn tác yêu cầu</button></a></td>":(m.getState() == 6)?"<td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-basic\">Đơn hàng bị hủy</button></a></td><td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-success\">Chấp nhận hủy đơn</button></a></td>":" <td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-primary\">Đang vận chuyển</button></a></td><td><a href=\"#\" style=\"pointer-events: none;cursor: default;\"><button class=\"btn btn-danger\">Từ chối hủy đơn</button></a></td></tr>"));
		}
	}

}
