package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.model.Book;

public class ProductDAO {
	final String URL = "jdbc:mysql://localhost:3306/";
	 final String DATABASE_NAME = "shoppingsite_kuriyama";
	 final String USER = "root";
	 final String PASSWORD = "Kurihiro0525";
		public List<Book> findAll() {
			List<Book> list = new ArrayList<>();
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
				String sql = "SELECT * FROM yuser_info_kuriyama";

				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					String id = rs.getString("product_id");
					String name = rs.getString("product_name");
					int price = rs.getInt("product_price");
					String genre = rs.getString("produt_genre");
					list.add(new Book(id, name, price, genre));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return list;
		}
}
