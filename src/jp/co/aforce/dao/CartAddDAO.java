package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.ProductBean;

public class CartAddDAO {

	public ProductBean add(ProductBean pb) {
		final String URL = "jdbc:mysql://localhost:3306/";
		 final String DATABASE_NAME = "shoppingsite_kuriyama";
		 final String USER = "root";
		 final String PASSWORD = "Kurihiro0525";

		 ProductBean productbean = new ProductBean();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
				String sql = "SELECT * FROM product_info_kuriyama WHERE product_name = ? ";

				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1,pb.getName());

				ResultSet rs = st.executeQuery();

				while(rs.next()) {
					productbean.setId(rs.getString("product_id"));
					productbean.setName(rs.getString("product_name"));
					productbean.setPrice(rs.getInt("product_price"));
					productbean.setWords(rs.getString("product_words"));
					productbean.setGenre(rs.getString("product_genre"));
				}
				st.close();
				con.close();
				return productbean;
		 }catch (Exception e) {
				e.printStackTrace();
				System.out.println("データベースに接続できませんでした");
				return null;
		 }
	}
}
