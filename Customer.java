import java.sql.ResultSet;
class Customer
{
	private String userId;
	private boolean login;
	Customer(String userId){
		login=false;
		this.userId=userId;
	}
	Customer(){
		login=false;
	}
	public String getUserId() {
		return this.userId;
	}
	public boolean login(String password) throws Exception {
		login = Customerdb.custLogin(userId,password);
		return login;
	}
	public boolean alreadyExist(String id) throws Exception {
		return Customerdb.custalreadyExist(id);
	}
	public void register(String userId,String userName,String phNum,String userMail,String location,String password) throws Exception
	{
		Customerdb.custRegister(userId,userName,phNum,userMail,location,password);
	}
	public void showBooking() throws Exception {
		ResultSet rs = BookingDB.showBookingUser(userId);
		boolean f=true;
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			f=false;
		}
		if(f)System.out.println("Oops!...No bookings...");
	}
}