package controllers.admins.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;
import daos.StaffDAO;
import models.Product;
import models.Staff;
import utils.FileUtil;
import utils.StringUtil;
@MultipartConfig
public class ControllersAdminStaffsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersAdminStaffsEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.setAttribute("result", "0");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("s", new StaffDAO().findStaffByStaffId(id));
		request.getRequestDispatcher("/views/admin/staff/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		StaffDAO staffDAO = new StaffDAO();
		String picture = FileUtil.upload("picture", request);
		int staff_id = Integer.parseInt(request.getParameter("staff_id"));
		try {
			if("".equals(picture)) {
				Staff staff = staffDAO.findStaffByStaffId(staff_id);
				picture= staff.getStaff_image();
			}
		} catch (Exception e) {

		}
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String calendar = request.getParameter("calendar");
		if(staffDAO.updateStaff(staff_id,picture, name, email, pass.equals(staffDAO.findStaffByStaffId(staff_id).getStaff_pass())?pass:StringUtil.md5(pass), phone, salary, calendar) > 0) {
			request.setAttribute("result", "1");
			request.setAttribute("s", new StaffDAO().findStaffByStaffId(staff_id));
			request.getRequestDispatcher("/views/admin/staff/edit.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
	}

	}
}
