import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseDetails {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				DatabaseMetaData dbmd = con.getMetaData();
				
				ResultSet rs = dbmd.getColumns(null, "booksellerdb", "%" , "%");
				System.out.println("<-----------------------------"
						+ "Column Details"
						+ "------------------------>");
				  while (rs.next()) { 
					  System.out.print("Table Name:  " + rs.getString("TABLE_NAME") + " "); 
					  System.out.print("Column_Name: " + rs.getString("COLUMN_NAME") + " ");  
					  System.out.print("Type_Name:   " + rs.getString("TYPE_NAME") + " ");  
					  System.out.println("Column Size  " + rs.getString("COLUMN_SIZE"));
				  }
				
				
				  System.out.println("<-----------------------------"
							+ "Method Details"
							+ "------------------------>");
				  
				  rs = dbmd.getProcedures(null, null, "%");
				  while(rs.next()) {  
					  System.out.println("Procedure Name: " + rs.getString("PROCEDURE_NAME"));
					  }
				  
				  System.out.println("<-----------------------------"
							+ "Driver Details"
							+ "------------------------>");
				  
				  System.out.println("Driver name : " + dbmd.getDriverName());
				  System.out.println("Driver version : " + dbmd.getDriverVersion());
				  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		catch(ClassNotFoundException e) {
			
		}
		

	}

}
