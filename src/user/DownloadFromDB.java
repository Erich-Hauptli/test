package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DownloadFromDB {
	public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:user.db");
        Statement stat = null;
        String query = "SELECT * FROM user WHERE education LIKE 'MSU'";

        try {
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("birthday = " + rs.getString("birthday"));
                System.out.println("education = " + rs.getString("education"));
                System.out.println("work = " + rs.getString("work"));
                System.out.println("\n");
            }
        } catch (SQLException e ) {
        } finally {
            if (stat != null) { stat.close(); }
        }
    }
  }