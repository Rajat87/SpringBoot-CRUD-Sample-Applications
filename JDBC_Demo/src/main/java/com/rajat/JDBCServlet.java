package com.rajat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JDBCServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			try {
				resp.getWriter().println("Servlet running");
			//1) Load the driver in the init method
			Class.forName("org.postgresql.Driver");
			resp.getWriter().println("Driver Loaded");
			System.out.println("Driver Loaded");
			
			
			
			//2) Open connection
			String url = "jdbc:postgresql://localhost:5432/JDBC";
			String username="postgres";
			String password = "Rajat@123";
			
			Connection connection=DriverManager.getConnection(url, username, password);
			if(connection!=null) {
				resp.getWriter().println("Connection Created");
			}else {
				resp.getWriter().println("Connection Failed");
			}
			
			
			//3) Write the SQL query:
			 //String sql ="insert into Employee(id,name,age,email,address) values(1,'Rajat',24,'rajatpandey090@gmail.com','Sahnewal')"; 
			// id
			//name
			//age
			//email
			//address
			
			int id =Integer.parseInt(req.getParameter("id"));
			String name=(String)req.getParameter("name");
			int age =Integer.parseInt(req.getParameter("age"));
			String email=(String)req.getParameter("email");
			String address=(String)req.getParameter("address");
			
			resp.getWriter().println(name);
			
			//String sql ="insert into Employee(id,name,age,email,address) values(null,'"+sRef2.getName()+"','"+sRef2.getPhone()+"',"+sRef2.getAge()+" , '"+sRef2.getAddress()+"')";
			String sql ="insert into Employee(id,name,age,email,address) values(?,?,?,?,?)";
			
			// Execute the SQL Query 
			//Statement statement = connection.createStatement();
			//int i= statement.executeUpdate(sql);
			PreparedStatement i = connection.prepareStatement(sql);
			i.setInt(1,id);
			i.setString(2, name);
			i.setInt(3,age);
			i.setString(4, email);
			i.setString(5, address);
			
			int j=i.executeUpdate();
			resp.getWriter().println(j+" Rows Inserted");
			// Close the connection
			connection.close();
			}catch(Exception e){
				System.out.println(e);
			}
			
			
		}
		
		
	}

