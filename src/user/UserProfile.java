package user;


public class UserProfile implements Profile{
		String username = "";
		String birthday = "";
		String education = "";
		String work = "";
		

	    public void set_username(String newValue) {
	         username = newValue;
	    }
	
	    public void set_birthday(String newValue) {
	         birthday = newValue;
	    }
	
	    public void set_education(String newValue) {
	         education = newValue;   
	    }
	
	    public void set_work_history(String newValue) {
	         work = newValue;
	    }
	
	    void printStates() {
	         System.out.println(username + " born on:" + 
	             birthday + " attended:" + education + " works at:" + work);
	}
}
