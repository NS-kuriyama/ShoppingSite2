package jp.co.aforce.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
@WebServlet("/role/RoleCheck")

public class RoleCheck extends HttpServlet{
	private static final long seriaVersionUID = 1L;

		public RoleCheck() {
			super();
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			HttpSession session = request.getSession();
			UserBean sub = (UserBean)session.getAttribute("user");

			if(sub.getRole() == 1) {
				request.getRequestDispatcher("../views/admin.jsp").forward(request, response);
			}else if (sub.getRole() == 2) {
				request.getRequestDispatcher("../views/index.html").forward(request, response);
			}else {
				request.getRequestDispatcher("../views/error.jsp").forward(request, response);
			}
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response )
		throws ServletException, IOException{
			doGet(request,response);
		}
	}

