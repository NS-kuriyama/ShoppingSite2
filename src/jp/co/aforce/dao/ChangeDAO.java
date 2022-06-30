package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.UserBean;

public class ChangeDAO {

	public UserBean search(UserBean ub) {
		final String URL = "jdbc:mysql://localhost:3306/";
		 final String DATABASE_NAME = "shoppingsite_kuriyama";
		 final String USER = "root";
		 final String PASSWORD = "Kurihiro0525";

		UserBean searchub = new UserBean();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
			String sql = "SELECT * FROM yuser_info_kuriyama WHERE mail_address = ? ";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1,ub.getMailAddress());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				searchub.setLastName(rs.getString("last_name"));
				searchub.setFirstName(rs.getString("first_name"));
				searchub.setMailAddress(rs.getString("mail_address"));
				searchub.setPassword(rs.getString("password"));
				searchub.setNickName(rs.getString("nick_name"));
				searchub.setRole(rs.getInt("role"));

			}
				st.close();
				con.close();
				return searchub;

			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("データベースに接続できませんでした");
			return null;
		}
	}
}
