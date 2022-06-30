package jp.co.aforce.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.dao.CartAddDAO;

@WebServlet("/cart/CartAddAction")
public class CartAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String book_name = request.getParameter("book_name");

		ProductBean pb = new ProductBean();
		pb.setName(book_name);

		CartAddDAO dao = new CartAddDAO();
		ProductBean productbean = dao.add(pb);

		if (productbean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("product", productbean);
			request.getRequestDispatcher("../views/cart.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "カートへの追加に失敗しました");
			request.getRequestDispatcher("../views/product.jsp");
		}
	}
}
