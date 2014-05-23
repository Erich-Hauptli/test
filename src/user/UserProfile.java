package user;

public class UserProfile implements Profile{
    String username = "";
    String birthday = "";
    String education = "";
    String work = "";

   // The compiler will now require that methods
   // changeCadence, changeGear, speedUp, and applyBrakes
   // all be implemented. Compilation will fail if those
   // methods are missing from this class.

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
