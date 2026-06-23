import java.sql.*;
public class DBConnector {
	private static String url="jdbc:mysql://localhost:3306/Student" ;
	private static String user_name="root";
	private static String pwd="Anudeep@99";
	public static Connection getconnection() {
		try {
			return(DriverManager.getConnection(url,user_name,pwd));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
