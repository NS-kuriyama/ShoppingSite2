package jp.co.aforce.change;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.ChangeDAO;

@WebServlet("/change/Change")
public class Change extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String mail_address = request.getParameter("mail_address");


		UserBean ub = new UserBean();
		ub.setMailAddress(mail_address);

		ChangeDAO cdao = new ChangeDAO();
		UserBean searchub = cdao.search(ub);



		if(searchub != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", searchub);
			request.getRequestDispatcher("../views/change.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "IDに誤りがあります");
			request.setAttribute("mail_address",mail_address);
			request.getRequestDispatcher("../views/change.jsp").forward(request, response);
		}

	}



}
