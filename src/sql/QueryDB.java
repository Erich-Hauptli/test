package sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryDB {
	public static ArrayList<String> query_headers(String database) throws Exception {
		ArrayList<String> Collumns = new ArrayList<String>();
        Class.forName("org.sqlite.JDBC");
        String manager =  "jdbc:sqlite:" + database + ".db";
        Connection conn = DriverManager.getConnection(manager);
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getColumns(null, null, database, null);
        while (rs.next()) {
        	String result = rs.getString(4);
        	Collumns.add(result);
        }
		
        conn.setAutoCommit(false);
        conn.setAutoCommit(true);
        conn.close();
        return Collumns;
	}
}
