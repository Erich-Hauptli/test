package sql;

import java.util.ArrayList;

public class DBDemo {
	public static void main(String[] args) throws Exception {

    	
		String file_name = "people.csv";
		String database = "user";
		String[] headers = {"id", "name", "birthday", "education", "degree", "work", "city"};
		
		UploadToDB.upload_file(database, headers, file_name);
		
		ArrayList<String> Collumns = QueryDB.query_headers(database);
		
		for(String Collumn : Collumns){
			System.out.println(Collumn);
		}
    	
    	DownloadFromDB.download_all(database);
    	
    	UploadToDB.modify_line(database, "1", "work", "ESPN");
    	
    	DownloadFromDB.download_all(database);
    	
    	DownloadFromDB.download_matches(database, "education", "MSU");
		
		

		
    }
}
