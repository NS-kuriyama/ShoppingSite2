package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.bean.UserBean;

public class LoginDAO {


	public UserBean search(UserBean ub){
		final String URL = "jdbc:mysql://localhost:3306/";
		 final String DATABASE_NAME = "shoppingsite_kuriyama";
		 final String USER = "root";
		 final String PASSWORD = "Kurihiro0525";

		UserBean returnub= new UserBean();
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
			String sql ="SELECT * FROM yuser_info_kuriyama WHERE mail_address = ? AND password = ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1,ub.getMailAddress());
			st.setString(2,ub.getPassword());

			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				returnub.setLastName(rs.getString("last_name"));
				returnub.setFirstName(rs.getString("first_name"));
				returnub.setMailAddress(rs.getString("mail_address"));
				returnub.setPassword(rs.getString("password"));
				returnub.setNickName(rs.getString("nick_name"));
				returnub.setRole(rs.getInt("role"));
			}else {
				return null;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return returnub;
	}


}