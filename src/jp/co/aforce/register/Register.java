package jp.co.aforce.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.RegisterDAO;

@WebServlet("/register/Register")
public class Register extends HttpServlet{
	private static final long seriaVersionUID = 1L;//Serializableを親クラスでimplmentsしている場合は必要


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String mail_address = request.getParameter("mail_address");
		String password = request.getParameter("password");
		String nick_name = request.getParameter("nick_name");
		int role = Integer.parseInt(request.getParameter("role"));

		UserBean rub = new UserBean();
		rub.setLastName(last_name);
		rub.setFirstName(first_name);
		rub.setMailAddress(mail_address);
		rub.setPassword(password);
		rub.setNickName(nick_name);
		rub.setRole(role);



		RegisterDAO registerdao = new RegisterDAO(rub);

		HttpSession session = request.getSession();
		session.setAttribute("user", rub);

		request.getRequestDispatcher("../views/registerSuccess.jsp").forward(request, response);
	}

}

