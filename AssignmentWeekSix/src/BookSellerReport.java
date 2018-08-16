import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BookSellerReport {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				String query = "Select * from Author";
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				String col,colData;
				for(int i=1; i <= cols; i++) {
					col = leftJustify(rsmd.getColumnName(i),
							rsmd.getColumnDisplaySize(i));
					System.out.print(col);
				}
				
				System.out.println("");
				while(rs.next()) {
					 for (int i = 1; i <= cols; i++) {  
						 if (rs.getObject(i) != null) {    
							 colData = rs.getObject(i).toString(); 

						 } else { 
							 colData = "NULL";                     
							   }   
						 col = leftJustify(colData, rsmd.getColumnDisplaySize(i));
						 System.out.print(col);  
						 } 
					 System.out.println(); 
						 }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	private static String leftJustify(String columnName,
			int columnDisplaySize) {
		 if (columnName.length() <= columnDisplaySize) columnDisplaySize++;                         
		 return String.format("%1$-" + columnDisplaySize + "s", columnName);
		
	}

}
