package cn.qhit.odbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBC {
	private static Connection con=null;
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:127.0.0.1:1521:orcl";
			String name="system";
			String pwd="123";
			con=DriverManager.getConnection(url, name, pwd);
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
