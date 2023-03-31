import java.sql.*;
class Restaurant{
	private static String restaurantId;
	private String resName;
	private String desc;
	private String type;
	private boolean login;
	private ResultSet menu;
	private ResultSet booking;
	Restaurant(){
		login=false;
		booking=null;
		menu=null;
	}
	Restaurant(String resId) throws Exception{
		ResultSet rs=RestaurantDB.getDetails(resId);
		if(rs==null)return;
		while(rs.next()) {
			restaurantId=rs.getString("restaurantId");
			resName=rs.getString("restaurantName");
			desc=rs.getString("description");
			type=rs.getString("vegnon");
		}
		login=false;
		menu=MenuDB.getMenu();
		booking=BookingDB.showBooking(resId);
	}
	public boolean login(String password) throws Exception {
		login = RestaurantDB.restLogin(restaurantId,password);
		return login;
	}
	public boolean login(String userId, String password) throws Exception {
		login=RestaurantDB.restLogin(userId, password);
		return login;
	}
	public boolean alreadyExist(String id) throws Exception {
		return RestaurantDB.restalreadyExist(id);
	}
	public void register(String userId,String userName,String description,String type,String location,String password)
	{
		RestaurantDB.restRegister(userId,userName,description,type,location,password);
	}
	public static String getResId() throws Exception {
		return restaurantId;
	}
	public void displayMenu() throws SQLException {
		while(menu.next()) {
			System.out.println(menu.getString("itemname")+" - "+menu.getString("description"));
		}
	}
	public void display() {
		System.out.println(restaurantId+" "+type+" "+resName+"\n - "+desc);
	}
	public static void display(String location) throws SQLException {
		ResultSet rs=RestaurantDB.display(location);
		boolean f=true;
		while(rs.next()) {
			f=false;
			System.out.println(rs.getString("restaurantId")+" "+rs.getString("vegnon")+" - "+rs.getString("restaurantName")+"\n"+rs.getString("description"));
		}
		if(f) {
			System.out.println("Oops!.. there are no restaurants...");
			return;
		}
	}
	public void addMenu(String[] itemname,String[] description) throws Exception {
		MenuDB.addMenu(restaurantId,itemname,description);
	}
	public void deleteMenu(String[] itemName) throws Exception {
		MenuDB.deleteMenu(itemName, restaurantId);
	}
	
	public void showBooking() throws Exception {
		boolean f=true;
		while(booking.next()) {
			System.out.println(booking.getString(1)+" "+booking.getString(2)+" "+booking.getString(3));
			f=false;
		}
		if(f)System.out.println("Oops! there are no bookings....");
	}
	public void bookTable(String userId, String date, String time) throws Exception {
		BookingDB.bookTable(userId, restaurantId, date, time);
	}
}