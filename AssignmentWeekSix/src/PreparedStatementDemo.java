import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		String jdbcDriverClassName = "com.mysql.jdbc.Driver";
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName(jdbcDriverClassName);
			
			try {
				Connection bookSellerDbConnection = DriverManager.getConnection(url, user, password);
				
				String selectBookByNameSqlQuery = "SELECT Title from Book WHERE Title LIKE ? ";
				
				PreparedStatement selectBookByNamePreparedStatement = bookSellerDbConnection.
						prepareStatement(selectBookByNameSqlQuery);
				
				System.out.println("Give Name of the book you want to search");
				
				String bookName = scan.next();
				
				
				selectBookByNamePreparedStatement.setString(1, "%"+bookName+"%");
				
				ResultSet resultSet = selectBookByNamePreparedStatement.executeQuery();
				System.out.println("All the matching available books are:-");
				while(resultSet.next()) {
					System.out.println(resultSet.getString("Title"));
				}
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
