package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// To get the data from the semdRedirect() Method
		int k = Integer.parseInt(req.getParameter("k"));
		k=k*k;
		PrintWriter write= resp.getWriter();
		write.println("Result is : "+k);
	}
}
