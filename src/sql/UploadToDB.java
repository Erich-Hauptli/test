package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import files.ReadFile;

public class UploadToDB {
	
    public static void upload_line(String database, String[] args) throws Exception {
    	String[] Collumn_Names = {"id", "name", "birthday", "education", "degree", "work", "city"};
    	String Names = "";
    	String Q = null;
    	for(String Name : Collumn_Names){
    		if (Names.equals("")){
    			Names = Name;
    			Q = "?";
    		}
    		else{
    			Names = Names + "," + Name;
    			Q = Q + ",?";
    		}
    	}
    	
        Class.forName("org.sqlite.JDBC");
        String manager =  "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(manager);
        Statement stmt = conn.createStatement();
        String Update = "create table if not exists " + database + "(" + Names + ");";
        stmt.executeUpdate(Update);   //Create table
        String Prepared = "insert into " + database + " values ("+ Q + ");";
        PreparedStatement prep = conn.prepareStatement(Prepared);
        
        for(int i = 0; i<Collumn_Names.length; i++){
        	prep.setString(i+1, args[i]);
        }
        prep.addBatch();
		
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
        conn.close();
    }
    
    public static void modify_line(String database, String id, String field, String field_value) throws Exception {
        Class.forName("org.sqlite.JDBC");
        String manager =  "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(manager);
        Statement stmt = conn.createStatement();
        String Modify = "Update " + database + " SET " + field;
        Modify = Modify + "='" + field_value + "' WHERE id='" + id + "'";
        stmt.executeUpdate(Modify);
		
        conn.setAutoCommit(false);
        conn.setAutoCommit(true);
        conn.close();
    }
    
    public static void upload_file(String database, String filename) throws Exception{

		try{
			ReadFile file = new ReadFile(filename);
			String[] aryLines = file.OpenFile();
			
			int i;
			for(i=0; i<aryLines.length; i++){
				String line = aryLines[i];
				String[] split = line.split("\\s*,\\s*");
				UploadToDB.upload_line(database, split);
			}
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
    }
    
  }