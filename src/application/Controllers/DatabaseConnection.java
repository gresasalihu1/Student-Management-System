package application.Controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
public static Connection startConnection() {		
	final String USERNAME="root";
	final String PASSWORD="";
	final String CONNECTDB="jdbc:mysql://localhost/spms";
		try {
			Connection connection;
			connection=(Connection) DriverManager.getConnection(CONNECTDB,USERNAME,PASSWORD);
			
			return connection;
		} 
		catch (SQLException e) {
			
			return null;
		} 
	}
}

