package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

	
	// Connection with Postgre database.
	private String address = "127.0.0.1";
	private String port = "5432";
	private String nameDatabase = "EnterpriseManager";
    private String url = "jdbc:postgresql://"+address+":"+port+"/"+nameDatabase;  
    private String username = "postgres";  
    private String password = "postgres";  
    private String driver = "org.postgresql.Driver";
	
	
    public DatabaseConnection() { }
    
    
	
	/**
	 * @return A connection with the database.
	 */
	public Connection getConnection(){
		Connection conn = null;
		try {
			
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	

}
