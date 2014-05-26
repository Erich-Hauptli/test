package connections;

import java.util.ArrayList;

import user.UserProfile;

public class ConnectionsCheck implements Connections{
	
	public void find_same(String field, String field_value){
		UserProfile user = new UserProfile();
		ArrayList<String> results = new ArrayList<String>();{
			try {
				results = user.collect_users(field, field_value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}{
			for(String result : results){
				System.out.println(result);
			}
		}
	}

}
