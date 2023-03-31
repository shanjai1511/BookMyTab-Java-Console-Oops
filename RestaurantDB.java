import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class RestaurantDB {

	public static ResultSet getDetails(String resId) throws Exception {
		try {
		Connection con=ConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from restaurant where restaurantId=?");
	        ps.setString(1, resId);
			return ps.executeQuery();
		} catch (SQLException e){}
		return null;
	}

	public static boolean restLogin(String restaurantId, String password) throws Exception {
		try {
			Connection con=ConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from restaurant where restaurantId=? and password=?");
	        ps.setString(1, restaurantId);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e){e.printStackTrace();return false;}
	}

	public static boolean restalreadyExist(String id) throws Exception {
		ResultSet rs = null;
		try {
		Connection con=ConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from restaurant where restaurantId=?");
	        ps.setString(1, id);
			rs= ps.executeQuery();
			return rs.next();
		} catch (SQLException e){return false;}
	}

	public static void restRegister(String userId, String userName, String description, String type, String location,String password)
	{
		try
		{
			Connection con = ConnectionDB.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into restaurant values(?,?,?,?,?,?)");
			ps.setString(1, userId);
			ps.setString(2, location);
			ps.setString(3, userName);
			ps.setString(4, description);
			ps.setString(5, type);
			ps.setString(6, password);
			ps.executeUpdate();
		} catch(Exception e){System.out.print(e);}
	}

	public static ResultSet display(String location) {
		ResultSet rs=null;
		try {
			Connection con=ConnectionDB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from restaurant where location = ?");
			ps.setString(1, location);
			rs=ps.executeQuery();
		}catch(Exception e) {e.printStackTrace();}
		return rs;
	}
}