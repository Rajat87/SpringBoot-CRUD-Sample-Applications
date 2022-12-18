package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This is our controller which receives the request from the client through the LoginPage.jsp file
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// We get the username and password from the client
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// Now we need to authenticate it and save the result either in a primitive or an object
		
		resp.getWriter().println("In the Login Servlet");
		
	}

}
