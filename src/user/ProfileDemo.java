package user;

public class ProfileDemo {
    public static void main(String[] args) {

        // Create two different 
        // User objects
        UserProfile erich = new UserProfile();
        UserProfile jessica = new UserProfile();

        // Invoke methods on 
        // those objects
        erich.set_username("Erich Hauptli");
        erich.set_birthday("August 30, 1982");
        erich.set_education("Michigan State University");
        erich.set_work_history("IBM");
        erich.printStates();

        jessica.set_username("Jessica Hauptli");
        jessica.set_birthday("April 8, 1983");
        jessica.set_education("Michigan State University");
        jessica.set_work_history("Mom");
        jessica.printStates();
    }
}
