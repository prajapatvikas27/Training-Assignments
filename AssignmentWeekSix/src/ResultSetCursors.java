import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetCursors {

	public static void main(String args[]) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				DatabaseMetaData dbmd = con.getMetaData();
				
				if(dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
					System.out.println("Supports type forward");
					if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_UPDATABLE)) {
						System.out.print(" and supports CONCUR_UPDATABLE");
					}
				}
				
				if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
					System.out.println("supports TYPE_SCROLL_SENSITIVE");
					if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, 
							ResultSet.CONCUR_UPDATABLE)) {
						System.out.print(" and supports CONCUR_UPDATABLE");
					}
					
				}
				
				if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
					System.out.print("Supports TYPE_SCROLL_SENSITIVE");
					if(dbmd.supportsResultSetConcurrency(ResultSet.CONCUR_UPDATABLE,
							ResultSet.CONCUR_UPDATABLE)) {
						System.out.print(" and supports CONCUR_UPDATABLE");
					}					
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
