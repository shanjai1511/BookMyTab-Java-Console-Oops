import java.sql.*;
public class BookingDB {
	public static ResultSet showBooking(String resId) throws Exception{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps=con.prepareStatement("select u.username,u.phonenumber,b.bookingdate,b.bookingtime from username u join bookings b on u.userid = b.username_userid where b.restaurant_restaurantid=?");
		ps.setString(1, resId);
		return ps.executeQuery();
	}
	public static boolean bookTable(String userid,String resId,String date,String time) throws Exception {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into bookings (bookingId,bookingdate,bookingtime,restaurant_restaurantid,username_userid) values(?,?,?,?,?) ");
		ps.setString(1, resId+userid);
		ps.setString(2, date);
		ps.setString(3, time);
		ps.setString(4, resId);
		ps.setString(5, userid);
		return ps.execute();
	}
	public static ResultSet showBookingUser(String userId) throws Exception {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps=con.prepareStatement("select b.bookingdate,b.bookingtime,r.restaurantName from  bookings b join restaurant r on b.restaurant_restaurantId=r.restaurantId where username_userid=?");
		ps.setString(1, userId);
		return ps.executeQuery();
	}
}