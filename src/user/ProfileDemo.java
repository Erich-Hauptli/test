package user;

public class ProfileDemo {
    public static void main(String[] args) {

        // Create User objects
        UserProfile user = new UserProfile();

        String[] Nick = {"8", "Nick Ellis", "7/5/1982", "MSU", "Lawyer"};
        user.add_users("people.csv");
        user.display_user("education", "MSU");
        user.add_user(Nick);
        user.display_all_users();
        user.display_user("education", "MSU");
        user.modify_username("6", "Krista Hauptli Teller");
        user.modify_birthday("7", "8/10/1985");
        user.modify_education("2", "Michigan State University");
        user.display_user("education", "MSU");
        user.modify_work_history("1", "IBM");
        user.display_all_users();
    }
}
