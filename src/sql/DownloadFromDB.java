package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DownloadFromDB {
	public static void download(String database, String[] args) throws Exception {
		String Manager = "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(Manager);
        Statement stat = null;
        //String query = "SELECT * FROM " + database + " WHERE education LIKE 'MSU'";
        String query = "SELECT * FROM " + database;
        //String size = "SELECT COUNT(*) AS count FROM " + database;

        try {
            stat = conn.createStatement();
            //Statement stmt1 = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            //ResultSet rs1 = stmt1.executeQuery(size);
            //int count = rs1.getInt("count");
            
            while (rs.next()) {
            	System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("birthday = " + rs.getString("birthday"));
                System.out.println("education = " + rs.getString("education"));
                System.out.println("work = " + rs.getString("work"));
                System.out.println("\n");
            }
            //System.out.println(count);
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
    }
  }