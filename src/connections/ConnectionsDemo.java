package connections;

public class ConnectionsDemo {
	public static void main(String[] args) {

		ConnectionsCheck connection = new ConnectionsCheck();
		
		String[] fields = {"education", "degree", "city"}; 
		connection.find_same("work", "engineer", fields);
	
	}
}
