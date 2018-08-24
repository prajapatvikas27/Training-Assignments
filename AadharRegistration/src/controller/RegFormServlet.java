package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/reg")
public class RegFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		
		String formNumber = request.getParameter("fno");
		if(formNumber.equals("1")) {
			
			String name = request.getParameter("name");
			String fatherName = request.getParameter("fname");
			String motherName = request.getParameter("mname");
			String password = request.getParameter("password");
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("fatherName", fatherName);
			httpSession.setAttribute("motherName", motherName);
			httpSession.setAttribute("password", password);
			response.sendRedirect("./form2.html");
		}
		else if(formNumber.equals("2")) {
			
			
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			httpSession.setAttribute("contact", contact);
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("address", address);
			
			response.sendRedirect("./form3.html");
			
		}
		else {
			
			String qualification = request.getParameter("qualification");
			String percentage = request.getParameter("percentage");
			
			String name = (String) httpSession.getAttribute("name");
			String fatherName = (String) httpSession.getAttribute("fatherName");
			String motherName = (String) httpSession.getAttribute("motherName");
			String userPassword = (String) httpSession.getAttribute("password");
			String contact =(String) httpSession.getAttribute("contact");
			String email = (String) httpSession.getAttribute("email");
			String address = (String) httpSession.getAttribute("address");
			
			
			String url = "jdbc:mysql://localhost:3306/aadhar";
			String user = "root";
			String password = "ITT@123456";
			String jdbcDriverClassName = "com.mysql.jdbc.Driver";
			
			try {
				Class.forName(jdbcDriverClassName);
				
				try {
					Connection con = DriverManager.getConnection(url, user, password);
					
					String sql = "insert into registration values(?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pStatement = con.prepareStatement(sql);
					
					pStatement.setString(1, name);
					pStatement.setString(2, fatherName);
					pStatement.setString(3, motherName);
					pStatement.setString(4, contact);
					pStatement.setString(5, email);
					pStatement.setString(6, address);
					pStatement.setString(7, qualification);
					pStatement.setString(8, percentage);
					pStatement.setString(9, userPassword);
					
					int i = pStatement.executeUpdate();
					if(i != 0) {
				/*		out.println("Name :" + name);
						out.println("Father Name :" + fatherName);
						out.println("Mother Name :" + motherName);
						out.println("Contact :" + contact);
						out.println("Email :" + email);
						out.println("Address :" + address);
						out.println("Qualification :" + qualification);
						out.println("Percentage :" + percentage);*/
						
						response.sendRedirect("./regSuccess.html");
					}
					else {
						out.println("Registartion failed");;
					}
					
				} catch (SQLException e) {
					out.println("Registartion failed");;

					e.printStackTrace();
				}
				
				
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
						
			
		}
	}

 
}
