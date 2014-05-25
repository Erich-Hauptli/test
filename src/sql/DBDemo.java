package sql;

public class DBDemo {
    public static void main(String[] args) throws Exception {

        // Create two different 
        // User objects
   	
    	String[] erich = {"1", "Erich Hauptli", "August 30, 1982", "MSU", "Engineer"};
    	String[] jessica = {"2","Jessica Hauptli", "April 8, 1983", "MSU", "Mom"};
    	String[] lukas = {"3","Lukas Hauptli", "June 23, 2012", "NA", "Kiddo"};
    	String[] leslie = {"4","Leslie Hauptli", "April 6, 1955", "MSU", "Banker"};
    	String[] jurg = {"5","Jurg Hauptli", "April 25, 1955", "MSU", "Engineer"};
    	String[] krista = {"6","Krista Teller", "September 13, 1984", "OAK", "Analyst"};
    	String[] dan = {"7","Dan Teller", "August 11, 1986", "NA", "Excavator"};

        // Invoke methods on 
        // those objects
    	UploadToDB.upload(erich);
    	UploadToDB.upload(jessica);
    	UploadToDB.upload(lukas);
    	UploadToDB.upload(leslie);
    	UploadToDB.upload(jurg);
    	UploadToDB.upload(krista);
    	UploadToDB.upload(dan);
    	
    	DownloadFromDB.download(null);
    }
}
