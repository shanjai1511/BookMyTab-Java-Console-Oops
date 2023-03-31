import java.sql.*;
public class MenuDB extends Restaurant{
	public static ResultSet getMenu() throws Exception{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from menu where restaurant_restaurantId=?");
		ps.setString(1, getResId());
		return ps.executeQuery();
	}
	public static void addMenu(String userId, String[] itemName, String[] description) throws Exception {
	    Connection con = ConnectionDB.getConnection();
	    PreparedStatement ps = con.prepareStatement("insert into menu(menuId,itemName,Description,restaurant_restaurantId) values(?,?,?,?)");
	    for(int i=0;i<itemName.length;i++) {
	    	ps.setString(1, null);
	    	ps.setString(2, itemName[i]);
	    	ps.setString(3, description[i]);
	    	ps.setString(4, userId);
	    	if(!ps.execute())System.out.println(itemName[i]+" added successfully...");
	    	else System.out.println(itemName[i]+" can't be added");
	    }
	}
	public static void deleteMenu(String[] itemName,String resId) throws Exception{
		Connection con = ConnectionDB.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from menu where itemName=? and restaurant_restaurantId=?");
    	for(int i=0;i<itemName.length;i++){
    		ps.setString(1, itemName[i]);
    		ps.setString(2, resId);
    		if(!ps.execute())System.out.println(itemName[i]+" deleted successfully...");
    		else System.out.println(itemName[i]+" something went wrong...");
    	}
	}
}