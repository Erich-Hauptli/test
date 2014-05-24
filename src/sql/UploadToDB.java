package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UploadToDB {
    public static void main(String[] args) throws Exception {
    	
    	//String size = "SELECT COUNT(*) AS count FROM user";
    	    	
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:user.db");
        Statement stmt = conn.createStatement();
        //Statement stmt1 = conn.createStatement();
        //stat.executeUpdate("drop table if exists user;");			//Remove table if it exists
        stmt.executeUpdate("create table if not exists user(id, name, birthday, education, work);");   //Create table
        
        //ResultSet rs1 = stmt1.executeQuery(size);
        //int count = rs1.getInt("count");
        //System.out.println(count);
        
        //stat.executeUpdate("insert table user(name, birthday, education, work);");
        PreparedStatement prep = conn.prepareStatement(
            "insert into user values (?, ?, ?, ?, ?);");
        
        prep.setString(1, "1");
        prep.setString(2, "Erich Hauptli");
        prep.setString(3, "8/30/1982");
        prep.setString(4, "MSU");
        prep.setString(5, "Engineer");
        prep.addBatch();
		
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        conn.close();
    }
  }