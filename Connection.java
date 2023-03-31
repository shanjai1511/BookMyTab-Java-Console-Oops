import java.sql.Connection;
import java.sql.DriverManager;
class ConnectionDB {
	static Connection con=null;
	private ConnectionDB() throws Exception
	{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmytab","root","root");
	}
	public static Connection getConnection() throws Exception {
		if(con==null) new ConnectionDB();
		return con;
	}
	public static void closeConnection() throws Exception {
		con.close();
	}
}