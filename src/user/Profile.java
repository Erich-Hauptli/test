package user;

public interface Profile {
	void add_user(String[] user);
	
	void add_users(String file);
	
    void modify_username(String id, String name);

    void modify_birthday(String id, String birthday);

    void modify_education(String id, String education);

    void modify_work_history(String id, String work);
    
    void display_all_users();
    
    void display_user(String field, String search_term);
}
