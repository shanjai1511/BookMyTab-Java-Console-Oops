import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Customerdb {
	public static boolean custLogin(String userId,String password) throws Exception
	{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps = con.prepareStatement("select userId from username where userId=? and password = ?");
        ps.setString(1, userId);
        ps.setString(2, password);
		ResultSet rs= ps.executeQuery();
		return rs.next();
	}
	public static boolean custalreadyExist(String id) throws Exception{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from username where userId=?");
        ps.setString(1, id);
		ResultSet rs= ps.executeQuery();
		return rs.next();
	}
	public static void custRegister(String userId,String userName,String phNum,String userMail,String location,String password) throws Exception
	{
	     Connection con = ConnectionDB.getConnection();
	     PreparedStatement ps = con.prepareStatement("insert into username values(?,?,?,?,?,?)");
	     ps.setString(1, userId);
	     ps.setString(2, userName);
	     ps.setString(3, phNum);
	     ps.setString(4, userMail);
	     ps.setString(5, location);
	     ps.setString(6, password);
	     ps.executeUpdate();
	}
}