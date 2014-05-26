package user;

import sql.DownloadFromDB;
import sql.UploadToDB;


public class UserProfile implements Profile{
		String database = "user";

	    public void add_user(String[] user_info) {
	        try {
	        	UploadToDB.upload_line(database, user_info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	    public void add_users(String file) {
	        try {
	        	UploadToDB.upload_file(database, file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void modify_username(String id, String name) {
	        try {
	        	UploadToDB.modify_line(database, id, "name", name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    public void modify_birthday(String id, String birthday) {
	        try {
	        	UploadToDB.modify_line(database, id, "birthday", birthday);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    public void modify_education(String id, String education) {
	        try {
	        	UploadToDB.modify_line(database, id, "education", education);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	    public void modify_work_history(String id, String work) {
	        try {
	        	UploadToDB.modify_line(database, id, "work", work);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void display_all_users() {
	        try {
	        	DownloadFromDB.download_all(database);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public void display_user(String field, String search_term) {
	        try {
	        	DownloadFromDB.download_matches(database, field, search_term);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
