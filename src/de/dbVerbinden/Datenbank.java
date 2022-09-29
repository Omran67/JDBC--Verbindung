package de.dbVerbinden;
import java.sql.*;

public class Datenbank {
	
	public static void main(String[] args) {
	
	String url = "jdbc:mysql://localhost:3307/fortbildung?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	String user = "root";
	String password = "";

try (Connection conn = DriverManager.getConnection(url,user,password)){
	System.out.println("got connected to Sql");
	
	String query  ="SELECT * FROM `dozent` ORDER BY `dozent`.`UESATZ` ASC ";
	
	Statement stmt = conn.createStatement();
	
	ResultSet rs = stmt.executeQuery(query);
	
	int colums = rs.getMetaData().getColumnCount();
	
	for (int i = 1; i <= colums ; i++) {     
		System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
		
		System.out.println();
		System.out.println("_____________________________");
		
		while(rs.next()) {
			for(int i1 = 1; i1<= colums; i1++) 
				System.out.print(String.format("%15s",rs.getString(i1)));
		}
		rs.close();
		stmt.close();
	}
}catch(SQLException ex) {
	System.out.println(ex.getMessage());
}

	}
}