package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.RegisterBean;

public class RegisterDatabase {

	public String authorizeRegister(RegisterBean registerBean) throws SQLException {
		
		String firstname = registerBean.getFirstname();
		String lastname = registerBean.getLastname();
		String username = registerBean.getUsername();
		String password = registerBean.getPassword();
		
		String url ="jdbc:mysql://localhost:3306/sports";
		String uname = "root";
		String pass = "yogesh";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement pst = con.prepareStatement("insert into turf(firstname,lastname,username,password) values(?,?,?,?)");
			
				pst.setString(1, firstname);
				pst.setString(2, lastname);
				pst.setString(3, username);
				pst.setString(4, password);
				
				pst.executeUpdate();
				
			return "Register Success";
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Register Failed";
	}
}
