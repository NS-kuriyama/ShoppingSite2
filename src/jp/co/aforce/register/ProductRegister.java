package jp.co.aforce.register;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.dao.ProductAddDAO;

@WebServlet("/register/ProductRegister")
public class ProductRegister extends HttpServlet{
	private static final long seriaVersionUID = 1L;//Serializableを親クラスでimplmentsしている場合は必要


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter java11Format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String time = nowDateTime.format(java11Format);


		String id = ("A"+time);
		String name = request.getParameter("name");
		int price = Integer.parseInt (request.getParameter("price"));
		String words = request.getParameter("words");
		String genre = request.getParameter("genre");

		ProductBean pb = new ProductBean();


		pb.setId(id);
		pb.setName(name);
		pb.setPrice(price);
		pb.setWords(words);
		pb.setGenre(genre);

		ProductAddDAO adddao = new ProductAddDAO(pb);



		HttpSession session = request.getSession();
		session.setAttribute("product", pb);
		request.setAttribute("success", "の商品登録が完了しました");
		request.getRequestDispatcher("../views/addproduct.jsp").forward(request, response);

	}

}
