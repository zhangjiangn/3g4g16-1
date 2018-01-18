package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ODBCConnection {
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			//jdbc:oracle:thin:@127.0.0.1:1521:ORCL
			String name="test";
			String pwd="123";
			conn=DriverManager.getConnection(url, name, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
