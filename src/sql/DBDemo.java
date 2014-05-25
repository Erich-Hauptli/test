package sql;

public class DBDemo {
    public static void main(String[] args) throws Exception {

    	
		String file_name = "people.csv";
		String database = "test";
		UploadToDB.upload_file(database, file_name);

    	
    	DownloadFromDB.download(database, null);
    }
}
