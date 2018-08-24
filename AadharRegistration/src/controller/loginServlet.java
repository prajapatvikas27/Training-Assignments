package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/aadhar";
		String user = "root";
		String password = "ITT@123456";
		String jdbcDriverClassName = "com.mysql.jdbc.Driver";
		
		String name = request.getParameter("name");
		String userPassword = request.getParameter("password");
		
		try {
			Class.forName(jdbcDriverClassName);
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				
				String sql = "select name,password from registration where name = ?";
				
			
				
				PreparedStatement pStatement = con.prepareStatement(sql);
				
				pStatement.setString(1, name);
				
				ResultSet rs = pStatement.executeQuery();
				
				if(rs.next()) {
					
					if(rs.getString("password").equals(userPassword)) {
						response.sendRedirect("./homeScreen.html");
					}
					else {
						out.println("Enter valid password");
					}
					
				}
				else {
					out.println("There is no such user");
				}
			
				
			} catch (SQLException e) {
				out.println("login failed");;

				e.printStackTrace();
			}
			
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
					

		
	}



}
