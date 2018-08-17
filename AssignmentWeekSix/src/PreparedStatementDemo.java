import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/booksellerdb";
		String user = "root";
		String password = "ITT@123456";
		String jdbcDriverClassName = "com.mysql.jdbc.Driver";
		
		
		try {
			Class.forName(jdbcDriverClassName);
			
			try {
				Connection bookSellerDbConnection = DriverManager.getConnection(url, user, password);
				
				while(true) {
					System.out.println("select what you want to do");
					System.out.println("1.Insertion 2.Search for a book");
					
					int choiceNumber = scan.nextInt();
					switch (choiceNumber) {
					case 1:
						insertBook(bookSellerDbConnection);
						break;

					case 2:
						searchBook(bookSellerDbConnection);
						
					default:
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

	public static void insertBook(Connection bookSellerDbConnection) {
		
		String insertBookDetailsSqlQuery = "INSERT INTO Book "
				+ "(ISBN, Title, PubDate, BookFormat, UnitPrice)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement insertBookDetailsPreparedStatement = bookSellerDbConnection.
					prepareStatement(insertBookDetailsSqlQuery);
			
			System.out.println("Enter book's ISBN number");
			String isbn = scan.next();
			System.out.println("Enter book's title");
			String title = scan.next();
			System.out.println("Enter book's pubdate in yyyy-mm-dd format");
			String userDate = scan.next();	
			System.out.println("Enter book's format");
			String format = scan.next();
			System.out.println("Enter book's unit price");
			String unitPrice = scan.next();
			
			insertBookDetailsPreparedStatement.setString(1, isbn);
			insertBookDetailsPreparedStatement.setString(2, title);
			insertBookDetailsPreparedStatement.setString(3, userDate);
			insertBookDetailsPreparedStatement.setString(4, format);
			insertBookDetailsPreparedStatement.setString(5, unitPrice);

			if(insertBookDetailsPreparedStatement.executeUpdate() >0)
			{
				System.out.println("row inserted");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void searchBook(Connection bookSellerDbConnection) {
		
		String selectBookByNameSqlQuery = "SELECT Title from Book WHERE Title LIKE ? ";
		
		PreparedStatement selectBookByNamePreparedStatement;
		try {
			selectBookByNamePreparedStatement = bookSellerDbConnection.
					prepareStatement(selectBookByNameSqlQuery);
			

			System.out.println("Give Name of the book you want to search");
			
			String bookName = scan.next();
			
			
			selectBookByNamePreparedStatement.setString(1, "%"+bookName+"%");
			
			ResultSet resultSet = selectBookByNamePreparedStatement.executeQuery();
			System.out.println("All the matching available books are:-");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("Title"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
}
