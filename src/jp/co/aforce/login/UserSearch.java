package jp.co.aforce.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.LoginDAO;

@WebServlet("/login/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mail_address = request.getParameter("mail_address");
		String password = request.getParameter("password");

		UserBean ub = new UserBean();
		ub.setMailAddress(mail_address);
		ub.setPassword(password);

		LoginDAO ld = new LoginDAO();
		UserBean returnub = ld.search(ub);

		if (returnub != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", returnub);
			request.getRequestDispatcher("../views/loginSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../views/error.jsp").forward(request, response);

		}
	}
}
