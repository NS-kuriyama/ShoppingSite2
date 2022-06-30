package jp.co.aforce.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.DeleteDAO;

@WebServlet("/delete/UserDelete")
public class UserDelete extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mail_address = request.getParameter("mail_address");

		UserBean ub = new UserBean();
		ub.setMailAddress(mail_address);

		DeleteDAO ddao = new DeleteDAO();
		int count = ddao.delete(ub);

		if(count != 0) {
			request.getRequestDispatcher("../views/login.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "IDに誤りがあります");
			request.setAttribute("mail_address",mail_address);
			request.getRequestDispatcher("../views/delete.jsp").forward(request, response);
		}
	}

}
