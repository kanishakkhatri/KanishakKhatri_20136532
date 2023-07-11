package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegistrationServlet() {
	
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String sid = request.getParameter("sid");
    	String sname = request.getParameter("sname");
    	String phone = request.getParameter("phone");
    	String marks = request.getParameter("marks");
    	String branch = request.getParameter("branch");
    	
    	try {
    		// Register JDBC driver
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/igt","root", "root");
    		// Prepare the SQL statement
    		PreparedStatement preparedStatement=connection.prepareStatement("insert into students values(?,?,?,?,?)");
    		preparedStatement.setString(1, sid);
    		preparedStatement.setString(2, sname);
    		preparedStatement.setString(3, phone);
    		preparedStatement.setString(4, marks);
    		preparedStatement.setString(5, branch);
    		// Execute the statement
    		int rowsInserted = preparedStatement.executeUpdate();
    		preparedStatement.close();
    		connection.close();
                   if (rowsInserted > 0) {
                       response.setContentType("text/html");
                       PrintWriter out = response.getWriter();
                       out.println("<h1>Congrats! you are successfully registered</h1>");
                   } else {
                       response.setContentType("text/html");
                       PrintWriter out = response.getWriter();
                       out.println("<h2>Error: Registration failed!</h2>");
                   }
    	} 
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
} 