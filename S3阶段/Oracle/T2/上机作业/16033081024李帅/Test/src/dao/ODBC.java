package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBC {
	private static  Connection conn=null;
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:localhost:1521:orcl";
			String name="scott";
			String pwd="123";
			conn=DriverManager.getConnection(url, name, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
