package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UploadToDB {
    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:user.db");
        Statement stat = conn.createStatement();
        //stat.executeUpdate("drop table if exists user;");			//Remove table if it exists
        stat.executeUpdate("create table if not exists user(name, birthday, education, work);");   //Create table
        //stat.executeUpdate("insert table user(name, birthday, education, work);");
        PreparedStatement prep = conn.prepareStatement(
            "insert into user values (?, ?, ?, ?);");
        
        prep.setString(1, "Dan Teller");
        prep.setString(2, "8/11/1986");
        prep.setString(3, "");
        prep.setString(4, "Excavator");
        prep.addBatch();
		
        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        conn.close();
    }
  }