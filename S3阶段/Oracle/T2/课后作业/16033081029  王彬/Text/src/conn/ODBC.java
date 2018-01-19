package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class ODBC {
	
	public static Connection conn=null;
	
	public static Connection getconn(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			conn=DriverManager.getConnection(url, "scott", "123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)  {	
//		String sql="select * from emp";
//		PreparedStatement ps=getconn().prepareStatement(sql);
//		ResultSet rs=ps.executeQuery();
		//第一种
//		List<Object[]> list=new ArrayList<Object[]>();
//		while (rs.next()) {
//			Object[] obj=new Object[4];
//			obj[0]=rs.getInt(1);
//			obj[1]=rs.getString(2);
//			obj[2]=rs.getString(3);
//			obj[3]=rs.getInt(4);
//			list.add(obj);
//		}
//		for (Object[] o : list) {
//			System.out.println(o[0]+"-----"+o[1]+"----"+o[2]+"-------"+o[3]);
//		}
		//第二种
//		List<Emp> list=new ArrayList<Emp>();
//		while (rs.next()) {
//			Emp emp=new Emp();
//			emp.setEmpno(rs.getInt("empno"));
//			emp.setEname(rs.getString("ename"));
//			list.add(emp);
//		}
//		for (Emp emp : list) {
//			System.out.println(emp.getEmpno()+"---"+emp.getEname());
//		}
		
		//修改
		try {
		
			String sql="update emp set ename='foor' where empno=? ";
			Emp emp=new Emp();
			emp.setEmpno(7902);
			int i=0;
			PreparedStatement ps=null;
			ps=getconn().prepareStatement(sql);
			ps.setInt(1, emp.getEmpno());
			i= ps.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
