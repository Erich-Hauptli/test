package files;

import java.io.IOException;

public class FileData {
	public static void file_main() throws IOException {
		String file_name = "people.csv";
		
		try{
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			
			int i;
			for(i=0; i<aryLines.length; i++){
				System.out.println(aryLines[i]);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
