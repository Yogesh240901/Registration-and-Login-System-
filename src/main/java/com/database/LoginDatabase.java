package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.LoginBean;

public class LoginDatabase {

	public String authorizeLogin(LoginBean loginBean) throws SQLException {
		
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		
		String dbusername ="";
		String dbpassword ="";
		
		String url ="jdbc:mysql://localhost:3306/sports";
		String uname ="root";
		String pass = "yogesh";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
		
			PreparedStatement pstmt=null; 

            pstmt=con.prepareStatement("select * from turf where username=? and password=?"); 

            pstmt.setString(1,username);

            pstmt.setString(2,password);

            ResultSet rs=pstmt.executeQuery();
		
            while(rs.next())

            {    

                dbusername=rs.getString("username");    

                dbpassword=rs.getString("password"); 

                

                if(username.equals(dbusername) && password.equals(dbpassword)){

                    return "SUCCESS LOGIN"; 

                }

            } 
            pstmt.close();
            con.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return"Wrong Username and Password";
	}
}
