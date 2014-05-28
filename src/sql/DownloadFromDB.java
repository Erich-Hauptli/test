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
        ArrayList<String> headers = QueryDB.query_headers(database);

        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            
            while (rs.next()) {
            	String result = "";
            	for(String header : headers){
            		result = result + header + "= " +  rs.getString(header) + "  ";
            	}
            System.out.println(result);
            }
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
        ArrayList<String> headers = QueryDB.query_headers(database);

        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            
            while (rs.next()) {
            	String result = "";
            	for(String header : headers){
            		result = result + header + "= " +  rs.getString(header) + "  ";
            	}
            	System.out.println(result);
            }
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
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> headers = QueryDB.query_headers(database);
        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
                        
            while (rs.next()) {
            	int i = 0;
            	String result = null;
            	for(String header : headers){
            		if (i == 0){
            			result = rs.getString(header);
            			i++;
            		}
            		else{
            			result = result + "," + rs.getString(header);
            		}
            	}
            	results.add(result);
            }
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
		return results;
    }
  }