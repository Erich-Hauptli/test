package sql;

import java.util.ArrayList;

public class DBDemo {
	public static void main(String[] args) throws Exception {

    	
		//String file_name = "people.csv";
		String database = "user";
		
		ArrayList<String> Collumns = QueryDB.query_headers(database);
		
		for(String Collumn : Collumns){
			System.out.println(Collumn);
		}
		
		//UploadToDB.upload_file(database, file_name);
    	
    	//DownloadFromDB.download_all(database);
    	
    	//UploadToDB.modify_line(database, "1", "work", "ESPN");
    	
    	//DownloadFromDB.download_all(database);
    	
    	//DownloadFromDB.download_matches(database, "education", "MSU");
		
		

		
    }
}
