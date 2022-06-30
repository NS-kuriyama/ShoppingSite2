package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.aforce.bean.ProductBean;

public class ProductAddDAO {

	public ProductAddDAO (ProductBean pb) {
	final String URL = "jdbc:mysql://localhost:3306/";
	 final String DATABASE_NAME = "shoppingsite_kuriyama";
	 final String USER = "root";
	 final String PASSWORD = "Kurihiro0525";

	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	 }catch (ClassNotFoundException e1) {
		 e1.printStackTrace();
		 System.out.println("クラスが見つかりませんでした");
	 }
		try(Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD)){
			String sql = "INSERT INTO product_info_kuriyama(product_id, product_name, product_price, product_words,product_genre) VALUES(?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1,pb.getId());
			st.setString(2,pb.getName());
			st.setInt(3,pb.getPrice());
			st.setString(4,pb.getWords());
			st.setString(5,pb.getGenre());

			int count = 0;
			count = st.executeUpdate();

				if(count != 0) {

					System.out.println("商品の登録に成功しました");
				}else {
					System.out.println("登録に失敗しました");

				}
	 }catch (SQLException e) {
		 e.printStackTrace();
		 System.out.println("入力内容に不備がある");
	 }

	 }
}



