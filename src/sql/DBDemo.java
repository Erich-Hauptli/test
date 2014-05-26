package sql;

public class DBDemo {
    public static void db_main() throws Exception {

    	
		String file_name = "people.csv";
		String database = "user";
		UploadToDB.upload_file(database, file_name);
    	
    	DownloadFromDB.download_all(database);
    	
    	UploadToDB.modify_line(database, "1", "work", "ESPN");
    	
    	DownloadFromDB.download_all(database);
    	
    	DownloadFromDB.download_matches(database, "education", "MSU");
    }
}
