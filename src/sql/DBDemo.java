package sql;

import java.io.IOException;

import files.ReadFile;

public class DBDemo {
    public static void main(String[] args) throws Exception {

    	
		String file_name = "people.csv";
		
		try{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			
			int i;
			for(i=0; i<aryLines.length; i++){
				String line = aryLines[i];
				String[] split = line.split("\\s*,\\s*");
				UploadToDB.upload(split);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
    	
    	DownloadFromDB.download(null);
    }
}
