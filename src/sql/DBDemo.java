package sql;

public class DBDemo {
    public static void main(String[] args) throws Exception {

    	
		String file_name = "people.csv";
		String database = "user";
		UploadToDB.upload_file(database, file_name);
    	
    	DownloadFromDB.download(database, null);
    	
    	UploadToDB.modify_line(database, "1", "work", "ESPN");
    	
    	DownloadFromDB.download(database, null);
    }
}
