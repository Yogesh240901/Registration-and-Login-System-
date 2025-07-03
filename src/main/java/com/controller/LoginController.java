package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.database.LoginDatabase;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("txt_user");
		String password = request.getParameter("txt_pass");
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		LoginDatabase logindb = new LoginDatabase();
		try {
			String authorize=logindb.authorizeLogin(loginBean);
			 if(authorize.equals("SUCCESS LOGIN")) {
				 
				 HttpSession session=request.getSession();
				 session.setAttribute("login",loginBean.getUsername());
				 request.getRequestDispatcher("SignOut.jsp").forward(request, response);
				 
			 }
			 else {
				 request.setAttribute("WrongLoginMsg",authorize);
				 request.getRequestDispatcher("Login.jsp").include(request, response);
				 
			 }
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
