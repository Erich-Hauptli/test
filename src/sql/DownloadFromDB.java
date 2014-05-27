package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DownloadFromDB {
	public static void download_all(String database) throws Exception {
		String Manager = "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(Manager);
        Statement stat = null;
        String query = "SELECT * FROM " + database;
        //String size = "SELECT COUNT(*) AS count FROM " + database;

        try {
            stat = conn.createStatement();
            //Statement stmt1 = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            //ResultSet rs1 = stmt1.executeQuery(size);
            //int count = rs1.getInt("count");
            
            while (rs.next()) {
            	System.out.println("id = " + rs.getString("id") + "   " + "name = " + rs.getString("name") + " birthday = " + rs.getString("birthday") );
                System.out.println("education = " + rs.getString("education") + "   " + "degree = " + rs.getString("degree") + "   " + "work = " + rs.getString("work") + "\n");
            }
            //System.out.println(count);
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
    }
	
	public static void download_matches(String database, String field, String field_value) throws Exception {
		String Manager = "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(Manager);
        Statement stat = null;
        String query = "SELECT * FROM " + database + " WHERE " + field + " LIKE '" + field_value + "'";
        //String size = "SELECT COUNT(*) AS count FROM " + database;

        try {
            stat = conn.createStatement();
            //Statement stmt1 = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            //ResultSet rs1 = stmt1.executeQuery(size);
            //int count = rs1.getInt("count");
            
            while (rs.next()) {
            	System.out.println("id = " + rs.getString("id") + "   " + "name = " + rs.getString("name") + " birthday = " + rs.getString("birthday") );
                System.out.println("education = " + rs.getString("education") + "   " + "degree = " + rs.getString("degree") + "   " + "work = " + rs.getString("work") + "\n");
            }
            //System.out.println(count);
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
    }
	
	public static ArrayList<String> collect_matches(String database, String field, String field_value) throws Exception {
		String Manager = "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(Manager);
        Statement stat = null;
        String query = "SELECT * FROM " + database + " WHERE " + field + " LIKE '" + field_value + "'";
        //String size = "SELECT COUNT(*) AS count FROM " + database;
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
                        
            while (rs.next()) {
            	String result = rs.getString("id") + "," + rs.getString("name") + "," + rs.getString("birthday") + ",";
            	result = result + rs.getString("education") + "," + rs.getString("degree") + "," + rs.getString("work");
            	results.add(result);
            }
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
		return results;
    }
  }