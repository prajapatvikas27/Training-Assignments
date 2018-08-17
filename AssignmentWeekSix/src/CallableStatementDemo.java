import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementDemo {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		String jdbcDriverClassName = "com.mysql.jdbc.Driver";
		try {
			Class.forName(jdbcDriverClassName);
			
			try {
				Connection bookSellerDbConnection = DriverManager.
						getConnection(url, user, password);
				
				while(true) {
					System.out.println("select what you want to do");
					System.out.println("1.Insertion 2.Search for a book in Price Range");
					
					int choiceNumber = scan.nextInt();
					switch (choiceNumber) {
					case 1:
						
						break;

					case 2:
						
						getBooksInPriceRange(bookSellerDbConnection);
						break;
						
					default:
						System.out.println("fsfsFAs");
						break;
					}
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
	private static void getBooksInPriceRange(
			Connection bookSellerDbConnection) {
		float startingPrice = 0;
		float endPrice = 0;
		String getBooksInPriceRangeCallableQuery = "{call getBooksInPriceRange(?, ?)}";
		try {
			CallableStatement getBooksInPriceRangeCallableStatement = bookSellerDbConnection.
					prepareCall(getBooksInPriceRangeCallableQuery,
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			System.out.println("Enter starting price");
			startingPrice = scan.nextFloat();

			System.out.println("Enter end Price");
			endPrice = scan.nextFloat();
			getBooksInPriceRangeCallableStatement.setFloat(1, startingPrice);
			getBooksInPriceRangeCallableStatement.setFloat(2, endPrice);
			
			ResultSet rs = getBooksInPriceRangeCallableStatement.executeQuery();
			System.out.println("The available books are:-");
			while(rs.next()) {
				System.out.println(rs.getString("Title"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
