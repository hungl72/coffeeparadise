package controllers.admins.decentralization;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.PermisionDAO;
import daos.ProductDAO;
import utils.FileUtil;
@MultipartConfig
public class ControllersAdminDecentralizationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersAdminDecentralizationAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", "0");
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		request.setAttribute("listPermision", new PermisionDAO().listStaff());
		request.getRequestDispatcher("/views/admin/decentralization/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");response.setCharacterEncoding("UTF-8");request.setCharacterEncoding("UTF-8");
		String picture = FileUtil.uploadAdmin("picture", request);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String calendar = request.getParameter("calendar");
		String permision = request.getParameter("permision");
		String [] cutPermision = permision.split(",");
		int per_id = Integer.parseInt(cutPermision[0]);
		if(new PermisionDAO().insertStaff(picture,name,email,pass,phone,salary,calendar,per_id) > 0) {
			request.setAttribute("result", "1");
			request.setAttribute("listPermision", new PermisionDAO().listStaff());
			request.getRequestDispatcher("/views/admin/decentralization/add.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "-1");
			request.setAttribute("listPermision", new PermisionDAO().listStaff());
			request.getRequestDispatcher("/views/admin/decentralization/add.jsp").forward(request, response);
		}
	}

}
