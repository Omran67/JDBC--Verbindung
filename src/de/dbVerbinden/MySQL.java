package de.dbVerbinden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL {
	private static final String host = "localhost";
	private static final String port = "8443";
	private static final String database = "mysql-test";
	private static final String username = "root";
	private static final String password = "";
	
	private static Connection con;
	
	public static boolean isConnected() {
		return(con == null ? false : true);
	}
	public static void connect() throws ClassNotFoundException{
		
		if(!isConnected()) {
		
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/user?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin");

		} catch(SQLException e) {
			System.out.println("[MySQL] Verbinden!");
			e.printStackTrace();
			}
		}
	}
	
	public static void disconnected() {
		if(isConnected()) {
			try {
			con.close();
			System.out.println("vebindung geschlossen");
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
	public static void update (String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);
			ps.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
}
