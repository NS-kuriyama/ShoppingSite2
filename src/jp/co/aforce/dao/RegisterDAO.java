package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.aforce.bean.UserBean;

public class RegisterDAO {

	public RegisterDAO(UserBean rub) {
		final String URL = "jdbc:mysql://localhost:3306/";
		 final String DATABASE_NAME = "shoppingsite_kuriyama";
		 final String USER = "root";
		 final String PASSWORD = "Kurihiro0525";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("クラスが見つかりませんでした。");
		}

		try (Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD)) {
			String sql = "INSERT INTO yuser_info_kuriyama"
					+ "(last_name,first_name,mail_address,password,nick_name,role)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, rub.getLastName());
			ps.setString(2, rub.getFirstName());
			ps.setString(3, rub.getMailAddress());
			ps.setString(4, rub.getPassword());
			ps.setString(5, rub.getNickName());
			ps.setInt(6, rub.getRole());

			int count = ps.executeUpdate();

			if (count != 0) {
				System.out.println("新規登録成功");
			} else {
				System.out.println("新規登録失敗");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("入力した内容に不備がある");
		}
	}

}
