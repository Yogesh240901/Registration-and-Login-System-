package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RegisterBean;
import com.database.RegisterDatabase;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("text_firstname");
		String lastName = request.getParameter("text_lastname");
		String userName = request.getParameter("text_username");
		String password = request.getParameter("text_password");
	
		RegisterBean registerBean = new RegisterBean();
		
		registerBean.setFirstname(firstName);
		registerBean.setLastname(lastName);
		registerBean.setUsername(userName);
		registerBean.setPassword(password);
		
		RegisterDatabase registerdb = new RegisterDatabase();
		
		String registerValidate;
		try {
			registerValidate = registerdb.authorizeRegister(registerBean);
		
		
		if(registerValidate.equals("Register Success")) {
			request.setAttribute("RegisterSuccessMsg", registerValidate);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("RegisterErrorMsg", registerValidate);
			request.getRequestDispatcher("Register.jsp").include(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}