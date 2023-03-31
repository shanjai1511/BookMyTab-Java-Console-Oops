class Validation
{
	public boolean validateEmail(String email)
    {
        java.util.regex.Pattern pat = java.util.regex.Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$");
        return pat.matcher(email).matches();
    }
	public String correctdate(String date)
	{
		String[] str=date.split("/");
		return str[2]+"/"+str[1]+"/"+str[0];
	}
	public boolean validatePhno(String str)
	{
		java.util.regex.Pattern ptrn = java.util.regex.Pattern.compile("(0/91)?[7-9][0-9]{9}");
		java.util.regex.Matcher match = ptrn.matcher(str);
		return match.find()&&match.group().equals(str);
	}
    public boolean validDate(String date)
    {
    	if (date.trim().equals("")) return true;
		else
		{
		    java.text.SimpleDateFormat sdfrmt = new java.text.SimpleDateFormat("dd/MM/yyyy");
		    sdfrmt.setLenient(false);
		    try {
		        sdfrmt.parse(date); 
		        return true;
		    }catch(java.text.ParseException e){ return false;}
		}
    }
    private static boolean containsUpper(String str)
    {
    	for(int i=0;i<str.length();i++) if(Character.isUpperCase(str.charAt(i))) return true;
    	return false;
    }
    private static boolean containsLower(String str)
    {
    	for(int i=0;i<str.length();i++)	if(Character.isLowerCase(str.charAt(i))) return true;
    	return false;
    }
    private static boolean containsDigit(String str)
    {
    	for(int i=0;i<str.length();i++)	if(Character.isDigit(str.charAt(i))) return true;
    	return false;
    }
    private static boolean containsSpecial(String str)
    {
    	for(int i=0;i<str.length();i++) if(!Character.isLetter(str.charAt(i))&&!Character.isDigit(str.charAt(i))) return true;
    	return false;
    }
	public boolean validatePassword(String password)
    {
		boolean f=containsUpper(password)&&containsLower(password)&&containsDigit(password)&&containsSpecial(password)&&password.length()>=8&&password.length()<=20;
		if(!f) System.out.println("Password should be 8-12 characters long\nShould contain atleast one uppercase, one lowercase, one special character and one digit.");
		return f;
    }
	public boolean validTime(String time) {
		if(!time.contains(":"))return false;
		String[] str=time.split(":");
		if(str.length==2&&Integer.parseInt(str[0])<=24&&Integer.parseInt(str[0])>=0&&Integer.parseInt(str[1])<=60&&Integer.parseInt(str[1])>=0)return true;
		return false;
	}
}