import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
			
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				String query = "Select * from Customer";
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					System.out.println("");
					System.out.print(rs.getInt("CustomerId") + " ");
					System.out.print(rs.getString("FirstName") + " ");
					System.out.print(rs.getString("LastName") + " ");
					System.out.print(rs.getString("EmailId") + " ");
					System.out.print(rs.getString("Phone") + " ");					
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
