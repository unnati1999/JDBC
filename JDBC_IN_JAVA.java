package com.jini;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class MyJdbc{
	static Connection conn=null;
	static PreparedStatement prepared=null;
	public static void main(String[] args)
	{
		makeJdbcConnection();
		addintoDB("aman",11,"bilsi");
		addintoDB("unnati",34,"badaun");
	}
	private static void makeJdbcConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/unnati","root","");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private static void addintoDB(String name,int rollno,String city) {
		try {
			String insertQuery="INSERT INTO var VALUES(?,?,?)";
			prepared=conn.prepareStatement(insertQuery);
			prepared.setString(1, name);
			prepared.setInt(2, rollno);
			prepared.setString(3, city);
			prepared.executeUpdate();
			prepared.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
