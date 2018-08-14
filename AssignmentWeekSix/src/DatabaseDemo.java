import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.System.*;

public class DatabaseDemo {

	public static void main(String[] args) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","ITT@123456");   
			Statement stmt=con.createStatement();  
		/*	boolean bof = stmt.execute("CREATE TABLE Customer IF NOT EXISTS (\r\n" + 
					"    CustomerId INT(50) UNSIGNED AUTO_INCREMENT PRIMARY KEY,\r\n" + 
					"    FirstName VARCHAR(15) NOT NULL,\r\n" + 
					"    LastName VARCHAR(15) NOT NULL,\r\n" + 
					"    Email VARCHAR(30),\r\n" + 
					"    Phone VARCHAR(10)\r\n" + 
					")");*/
			ResultSet rs=stmt.executeQuery("select * from test");  
			 while (rs.next()) {        
				 out.print(rs.getInt("CustomerID") + "  ");  
				 out.print(rs.getString("FirstName") + "  ");  
				 out.print(rs.getString("LastName") + "  "); 
				 out.print(rs.getString("EMail") + "  ");  
				 out.println(rs.getString("Phone"));   
			 }
			 
			 out.println("finished");
			}
		catch(Exception e)
		{ 
			System.out.println(e);
			}  
			
		}
	}


