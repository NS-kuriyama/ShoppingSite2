package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.aforce.bean.UserBean;

public class UpdateDAO {

	public int update(UserBean ub) {

		final String URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "shoppingsite_kuriyama";
		final String USER = "root";
		final String PASSWORD = "Kurihiro0525";
		int count = 0;



		try {Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);

			String sql = "UPDATE yuser_info_kuriyama SET last_name = ?, first_name = ?, password = ?, nick_name = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, ub.getLastName());
			st.setString(2, ub.getFirstName());
			st.setString(3, ub.getPassword());
			st.setString(4, ub.getNickName());


			count = st.executeUpdate();

			return count;

		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("データベースの接続に失敗");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("予期せぬエラー");
		}
		return count;
	}
}


