package jp.co.aforce.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.UserBean;
import jp.co.aforce.dao.UpdateDAO;

@WebServlet("/update/Update")
public class Update extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String password = request.getParameter("password");
		String nick_name = request.getParameter("nick_name");

		UserBean ub = new UserBean();

		ub.setLastName(last_name);
		ub.setFirstName(first_name);
		ub.setPassword(password);
		ub.setNickName(nick_name);

		UpdateDAO udao = new UpdateDAO();
		int count = udao.update(ub);

		if(count != 0) {
			request.setAttribute("succes", count +"行の更新に成功しました");
			request.getRequestDispatcher("../views/change.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "更新に失敗しました");
			request.getRequestDispatcher("../views/change.jsp").forward(request, response);
		}
	}

}
