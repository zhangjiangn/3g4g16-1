package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private static Connection conn=null;
    public static Connection getConnection(){
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:127.0.0.1:1521:orcl";
			String username="scott";
			String password="123";
			conn=DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
		
		}
		return conn;	
    }	
	
	public static void main(String[] args) throws SQLException {
		
//		PreparedStatement ps=getConnection().prepareStatement("select * from emp");
//		ResultSet rs=ps.executeQuery();
//		List<Object[]> list=new ArrayList<Object[]>();
//		while (rs.next()) {
//			Object[] obj=new Object[4];
//			obj[0]=rs.getInt(1);
//			obj[1]=rs.getString(2);
//			obj[2]=rs.getString(3);
//			obj[3]=rs.getInt(6);
//			list.add(obj);
//		}
//		for (Object[] o : list) {
//			System.out.println(o[0]+"-------"+o[1]+"------"+o[2]+"------"+o[3]);
//		}
		
		
//		PreparedStatement ps=getConnection().prepareStatement("select * from emp");
//		ResultSet rs=ps.executeQuery();
//		List<Emp> list=new ArrayList<Emp>();
//		while (rs.next()) {
//			Emp emp=new Emp();
//			emp.setEname(rs.getString("ename"));
//			emp.setSal(rs.getInt("sal"));
//			list.add(emp);
//		}
//		for (Emp e : list) {
//			System.out.println(e.getEname()+"------"+e.getSal());
//		}
//		
//		增
//		Emp emp=new Emp();
//		emp.setEmpno(6666);
//		emp.setEname("小莫");
//		emp.setJob("打游戏");
//		emp.setSal(3000);
//		PreparedStatement ps=getConnection().prepareStatement("insert into emp(empno,ename,job,sal) values(?,?,?,?)");
//		ps.setInt(1, emp.getEmpno());
//		ps.setString(2, emp.getEname());
//		ps.setString(3, emp.getJob());
//		ps.setInt(4, emp.getSal());
//		int i = ps.executeUpdate();
//		System.out.println(i);
//
//      改
		Emp emp=new Emp();
		emp.setEname("张三");
		emp.setSal(3000);
		PreparedStatement ps=getConnection().prepareStatement("update emp set ename=? where sal=?  ");
		ps.setString(1, emp.getEname());
		ps.setInt(2, emp.getSal());
		int i=ps.executeUpdate();
		System.out.println(i);
		
	}

}
