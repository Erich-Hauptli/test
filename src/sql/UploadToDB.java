package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import files.ReadFile;

public class UploadToDB {
	
    public static void upload_line(String[] args) throws Exception { 	
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:user.db");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("create table if not exists user(id, name, birthday, education, work);");   //Create table
        PreparedStatement prep = conn.prepareStatement(
            "insert into user values (?, ?, ?, ?, ?);");
        
        prep.setString(1, args[0]);
        prep.setString(2, args[1]);
        prep.setString(3, args[2]);
        prep.setString(4, args[3]);
        prep.setString(5, args[4]);
        prep.addBatch();
		
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
        conn.close();
    }
    
    public static void upload_file(String filename) throws Exception{
		try{
			ReadFile file = new ReadFile(filename);
			String[] aryLines = file.OpenFile();
			
			int i;
			for(i=0; i<aryLines.length; i++){
				String line = aryLines[i];
				String[] split = line.split("\\s*,\\s*");
				UploadToDB.upload_line(split);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
    }
    
  }