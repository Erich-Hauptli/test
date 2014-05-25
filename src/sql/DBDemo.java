package sql;

public class DBDemo {
    public static void main(String[] args) throws Exception {

    	
		String file_name = "people.csv";
		UploadToDB.upload_file(file_name);

    	
    	DownloadFromDB.download(null);
    }
}
