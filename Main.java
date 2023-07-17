public class Main
{
	private static java.util.Scanner sc = new java.util.Scanner(System.in);
	private static Validation validation=new Validation();
	private static Customer custlogin() throws Exception
	{
		for(int i=0;i<10;i++) {
			System.out.print("Enter your userId: ");
			String userId=sc.nextLine();
			System.out.print("Enter your correct password: ");
			String password=sc.nextLine();
			Customer customer=new Customer(userId);
			if(customer.login(password)) return customer;
			System.out.println("Password and userId incorrect");
			System.out.print("Do you want to exit(Y/N)? ");
        	char ch=sc.nextLine().toUpperCase().charAt(0);
        	if(ch=='Y') System.exit(0);
		}
		return null;
	}
	private static Customer registerUser() throws Exception
	{
		System.out.print("Enter your userId: ");
		String userId=sc.nextLine();
		int i=0;
		Customer customer = new Customer();
		while((customer.alreadyExist(userId)||userId.equals(""))&&i<=5) {
			if(userId.equals(""))System.out.print("Enter valid userId: ");
			else if(customer.alreadyExist(userId))System.out.print("Enter another user name: ");
			userId=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter your name: ");
		String userName=sc.nextLine();
		while(userName.equals("")&&i<=5) {
			System.out.print("Enter your valid name: ");
			userName=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter your phone number: ");
		String phNum=sc.nextLine();
		while(i<=5&&!validation.validatePhno(phNum)) {
			System.out.print("Enter your correct phone Number: ");
			phNum=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		customer=new Customer(userId);
		i=0;
		System.out.print("Enter your mail Id: ");
		String mail=sc.nextLine();
		while(i<=5&&!validation.validateEmail(mail)) {
			System.out.print("Enter your correct mailId");
			mail=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter your location: ");
		String location=sc.nextLine();
		while(location.equals("")&&i<=5) {
			System.out.print("Enter your correct location: ");
			location=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter your password: ");
		String password=sc.nextLine();
		while(i<=5&&!validation.validatePassword(password)) {
			System.out.print("Enter valid password: ");
			password=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		customer.register(userId,userName,phNum,mail,location,password);
		System.out.println("Successfully registered!");
		customer.login(password);
		return customer;
	}
	private static void booktable(Restaurant restaurant, String userId,String resId) throws Exception
	{
		System.out.print("Enter date:(dd/mm/yyyy) ");
		String date=sc.nextLine();
		int i=0;
		while(!validation.validDate(date)&&i<=5) {
			System.out.print("Enter in correct format:(dd/mm/yyyy) ");
			date=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		date=validation.correctdate(date);
		System.out.print("Enter the time:(24hrs - hh:mm) ");
		String time=sc.nextLine();
		while(!validation.validTime(time)&&i<=5) {
			System.out.print("Enter in correct format:(24hrs - hh:mm) ");
			date=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		restaurant.bookTable(userId,  date, time);
		System.out.println("Table booked successfully!");
	}
	private static void Customer() throws Exception
	{
		System.out.print("Have you registered already? (Y/N)");
		char ch='4';
		int i=0;
		Customer customer=null;
		while(i<=5) {
			i++;
			ch=sc.nextLine().toUpperCase().charAt(0);
			if(ch=='Y') {
				customer=custlogin();
				if(customer!=null)break;
			}
			else if(ch=='N') {
				if(customer!=null)customer=registerUser();
				break;
			}
			else System.out.print("Enter valid option:");
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		System.out.print("Enter your desired location :");
		String location=sc.nextLine();
		Restaurant.display(location);
		while(true)
		{
			System.out.println("\n1 - Search for other location");
			System.out.println("2 - View Menu");
			System.out.println("3 - Book Table");
			System.out.println("4 - Show Bookings");
			System.out.println("5 - Exit");
			System.out.print("Enter your choice: ");
			String str=sc.nextLine();
			char choice;
			if(Integer.parseInt(str)>4)choice='5';
			else choice=str.charAt(0);
			if(ch=='4')return;
			Restaurant restaurant;
			switch(choice)
			{
				case '1': {
					System.out.print("Enter your location: ");
					location = sc.nextLine();
					Restaurant.display(location);
					break;
				}
				case '2': {
					System.out.print("Enter restaurant ID : ");
					String resId=sc.nextLine();
					restaurant =new Restaurant(resId);
					restaurant.displayMenu();
					break;
				}
				case '3': {
					System.out.println("Enter the restaurant id: ");
					String resId=sc.nextLine();
					booktable(new Restaurant(resId),customer.getUserId(),resId);
					break;
				}
				case '4':
					System.out.println("Your Bookings are!...");
					customer.showBooking();
					break;
				case '5': 
					System.out.print("Do you want to exit ? (Y/N)");
		        	ch=sc.nextLine().toUpperCase().charAt(0);
		        	if(ch=='Y') return;
		        	return;
				default:
        			System.out.println("Invalid");
        			break;
			}
        	System.out.print("Do you want to exit ? (Y/N)");
        	ch=sc.nextLine().toUpperCase().charAt(0);
        	if(ch=='Y') {
        		System.out.print("Thank you! visit again....");
        		System.exit(0);
        	}
		}
	}
	private static void Restaurant() throws Exception
	{
		Restaurant restaurant;
		System.out.print("Have you already registered?(y/n)");
		while(true) {
			char ch=sc.nextLine().toUpperCase().charAt(0);
			if(ch=='Y') {
				restaurant=restlogin();
				break;
			}
			else if(ch=='N') {
				restaurant=registerRestaurant();
				addMenu(restaurant);
				break;
			}
			System.out.print("Enter correct option: ");
		}
		while(true) { 
    		System.out.println("1 : Add Menu");
        	System.out.println("2 : Delete Menu");
        	System.out.println("3 : Show Menu");
        	System.out.println("4 : Show Bookings");
        	System.out.println("5 : Exit");
    		System.out.print("Enter your choice: ");
        	char c=sc.nextLine().charAt(0);
        	switch(c)
        	{
        		case '1':
        			addMenu(restaurant);
        			break;
        		case '2':
        			System.out.print("Enter Number of Items need to be deleted: ");
        			int n=Integer.parseInt(sc.nextLine());
        			String[] itemName=new String[n];
        			for(int i=0;i<n;i++)
        			{
        				System.out.print("Enter Item Name: ");
        				itemName[i]=sc.nextLine();
        			}
        			restaurant.deleteMenu(itemName);
        			break;
        		case '3':
        			System.out.println("Your menu is:");
        			restaurant.displayMenu();
        			break;
        		case '4':
        			restaurant.showBooking();
        			break;
        		default:
        			break;
        	}
        	System.out.print("Do you want to continue? (Y/N)");
        	if(sc.nextLine().toUpperCase().charAt(0)=='N') {
        		System.out.println("Thank you! visit again....");
        		System.exit(0);
        	}
    	}
	}
	private static void addMenu(Restaurant restaurant) throws Exception {
		System.out.print("Enter number of menu in you restaurant: ");
		int n=Integer.parseInt(sc.nextLine());
			String[] itemName=new String[n];
			String[] description=new String[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter itemName: ");
			itemName[i]=sc.nextLine();
			System.out.print("Enter about "+itemName[i]+": ");
			description[i]=sc.nextLine();
		}
		restaurant.addMenu(itemName,description);
	}
	private static Restaurant restlogin() throws Exception
	{
		Restaurant restaurant;
		for(int i=0;i<10;i++) {
			System.out.print("Enter your userId: ");
			String userId=sc.nextLine();
			System.out.print("Enter your password: ");
			String password=sc.nextLine();
			restaurant=new Restaurant();
			if(restaurant.login(userId,password)) return new Restaurant(userId);
			System.out.println("Password and userId incorrect");
			System.out.print("Do you want to exit(Y/N)? ");
        	char ch=sc.nextLine().toUpperCase().charAt(0);
        	if(ch=='Y') {
        		System.out.print("Thank you! visit again....");
        		System.exit(0);
        	}
		}
		return null;
	}
	private static Restaurant registerRestaurant() throws Exception
	{
		System.out.print("Enter your userId:(should start with 'r') ");
		String userId=sc.nextLine();
		int i=0;
		Restaurant restaurant=new Restaurant();
		while(i<=5&&(restaurant.alreadyExist(userId)||(userId.equals("")||userId.charAt(0)!='r'))) {
			if(userId.equals("")||userId.charAt(0)!='r')System.out.print("Enter valid userId: ");
			else if(restaurant.alreadyExist(userId))System.out.print("Enter another userId: ");
			userId=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter location: ");
		String location=sc.nextLine();
		while(location.equals("")&&i<=5) {
			System.out.print("Enter correct location: ");
			location=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Enter restaurant name: ");
		String userName=sc.nextLine();
		while(userName.equals("")&&i<=5) {
			System.out.print("Enter valid name: ");
			userName=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Say about you restaurant(200 words): ");
		String description=sc.nextLine();
		while(i<=5&&(description.equals("")||description.length()>200)) {
			System.out.print("Enter description correclty:");
			description=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		System.out.print("Veg/NonVeg: ");
		char veg=sc.nextLine().toUpperCase().charAt(0);
		while(i<=5&&veg!='V'&&veg!='N') {
			System.out.print("Enter valid input: (Veg/NonVeg) ");
			veg=sc.nextLine().toLowerCase().charAt(0);
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		i=0;
		String type=veg=='V'?"Veg":"Non";
		System.out.print("Enter your password: ");
		String password=sc.nextLine();
		while(!validation.validatePassword(password)&&i<=5) {
			System.out.print("Enter valid password: ");
			password=sc.nextLine();
			i++;
		}
		if(i==6) {
			System.out.println("Attempts over!\nTry again later....");
			System.exit(0);
		}
		restaurant.register(userId,userName,description,type,location,password);
		System.out.println("Successfully registered!");
		restaurant=new Restaurant(userId);
		restaurant.login(password);
		return restaurant;
	}
	public static void main(String args[])
	{
		System.out.println("Welcome to tabie!");
		System.out.println("A site to fill your eyes and stomach");
		try {
			while(true) { 
				System.out.println("1 : Customer");
				System.out.println("2 : Restaurant");
				System.out.print("Enter your choice: ");
				char n=sc.nextLine().charAt(0);
				switch(n)
				{
					case '1':
						Customer();
						break;
					case '2':
						Restaurant();
						break;
					default:
						System.out.println("Invalid");
						break;
				}
				System.out.print("Do you want to continue to main menu? (Y/N)");
				if(sc.nextLine().toUpperCase().charAt(0)=='N') {
					System.out.print("Thank you! visit again....");
					break;
				}
			}
			ConnectionDB.closeConnection();
		}catch(Exception e) {System.out.print(e);}
	}
}
