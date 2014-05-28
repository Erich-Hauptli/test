package connections;

import java.util.ArrayList;

import sql.QueryDB;
import user.UserProfile;

public class ConnectionsCheck implements Connections{
	
	ArrayList<String> results = new ArrayList<String>();
	ArrayList<String> collumns = new ArrayList<String>();
	
    public void find_same(String common_field, String common_field_value, String[] compare_fields) {
        try {
        	UserProfile user = new UserProfile();
        	results = user.collect_users(common_field, common_field_value);
        	collumns = user.query_collumns();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        for(String compare_field : compare_fields){
        	int i = 0;
        	for(String collumn : collumns){
        		if(collumn.equalsIgnoreCase(compare_field)){
        			break;
        		}
        		else i++;
        	}

	        ArrayList<String> Points = new ArrayList<String>();
	        for (String result : results){
	        	String[] split = result.split("\\s*,\\s*");
	        	boolean found = false;
	        	for (String point : Points) {
	        	    if (point.equals(split[i])) {
	        	    	found = true;
	        	        break;
	        	    }
	        	}
	        	if(found == false){
	        		Points.add(split[i]);
	        	}
	        }
	        float size = results.size();
	        for(String point : Points){
	        	float count = 0;
	        	for (String result : results){
	        		String[] split = result.split("\\s*,\\s*");
	        		if(split[i].equals(point)){
	        			count++;
	        		}
	        	}
	        	//System.out.println(count + "/" + size);
	        	float percentage = ((count * 100) / size);
	        	String percent = String.format("%.2f", percentage);
	        	String output = point + ": " + percent + "%";
	        	System.out.println(output);
	        }
	        System.out.println("\n");
        }
    }

}
