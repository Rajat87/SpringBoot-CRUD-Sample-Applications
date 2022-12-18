package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("FirstNumber"));
		int b = Integer.parseInt(req.getParameter("SecondNumber"));
		int k = a+b;
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(k);
		
		// Now I want the user to be redirected to a new servlet with a new URL and also want to send the value of k
		// For that I need to use sendRedirect()
		
		// Since i am sending the response to the client i will be using the response object
		resp.sendRedirect("Square?k="+k); // Now I need to pass the URL of the new servlet here
		
		// This is good but a better way to do this is using Session
		
	}
	
}
