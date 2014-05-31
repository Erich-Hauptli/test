package user;

/*  Test file for user package.  */
public class ProfileDemo {
	public static void main(String[] args) {

        // Create User objects
        UserProfile user = new UserProfile();

        String[] Nick = {"8", "Nick Ellis", "7/5/1982", "MSU", "BS", "Lawyer", "Detroit"};
        user.add_users("Test.csv");
        System.out.println("Display all users who attented MSU");
        user.display_user("education", "MSU");
        user.add_user(Nick);
        System.out.println("Display all users.");
        user.display_all_users();
        System.out.println("Display all users who attented MSU");
        user.display_user("education", "MSU");
        user.modify_field("6", "name", "Krista Hauptli Teller");
        user.modify_field("7", "birthday", "8/10/1985");
        user.modify_field("2", "education", "Michigan State University");
        user.display_user("work", "engineer");
        user.modify_field("1", "work", "IBM");
        System.out.println("Display all users.");
        user.display_all_users();
    }
}
