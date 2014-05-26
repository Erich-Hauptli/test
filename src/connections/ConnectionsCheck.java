package connections;

import java.util.ArrayList;

import user.UserProfile;

public class ConnectionsCheck implements Connections{
	
	ArrayList<String> results = new ArrayList<String>();	
	
    public void find_same(String field, String field_value) {
        try {
        	UserProfile user = new UserProfile();
        	results = user.collect_users(field, field_value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ArrayList<String> Points = new ArrayList<String>();
        for (String result : results){
        	String[] split = result.split("\\s*,\\s*");
        	boolean found = false;
        	for (String point : Points) {
        	    if (point.equals(split[3])) {
        	        found = true;
        	        break;
        	    }
        	}
        	if(found == false){
        		Points.add(split[3]);
        	}
        }
        int size = results.size();
        for(String point : Points){
        	int count = 0;
        	for (String result : results){
        		String[] split = result.split("\\s*,\\s*");
        		if(split[3].equals(point)){
        			count++;
        		}
        	}
        	String output = point + ": " + count + "/" + size;
        	System.out.println(output);
        }
    }

}
