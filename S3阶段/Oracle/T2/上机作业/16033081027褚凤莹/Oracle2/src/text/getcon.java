package text;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Emp;


public class getcon {
	static Connection con=null;
    public static Connection getcon(){
    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:127.0.0.1:1521:orcl";
		String name="scott";
		String pwd="123";
		con=DriverManager.getConnection(url, name, pwd);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    return con;
    
    }
    public static List<Emp> selectEmp(){
    	List<Emp> list =new ArrayList<Emp>();
    	try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Emp");
		
			while (rs.next()) {
				Emp e=new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setMgr(rs.getInt("mgr"));
				e.setSal(rs.getInt("sal"));
				list.add(e);
				
			}
//			for (Emp emp : list) {
//				System.out.println(emp.getEmpno()+"------"+emp.getEname()+"------"+emp.getMgr()+"------"+emp.getSal());
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    }
    public static int upEmp(String sql){//修改
    	Statement st;
    	int rs = 0;
		try {
			st = con.createStatement();
			rs=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return rs;	
    }
    public static String selectEname(String sql){
    	Emp emp=new Emp();
    	ResultSet rs;
    	String ename=null;
		try {
			Statement st=con.createStatement();
			rs=st.executeQuery(sql);
			while (rs.next()) {
			  ename=emp.setEname(rs.getString("ename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ename;
    }
	public static void main(String[] args) {
		System.out.println(getcon());//连接数据库
		List<Emp> list =selectEmp();//查询
		for (Emp emp : list) {
			System.out.println(emp.getEmpno()+"------"+emp.getEname()+"------"+emp.getMgr()+"------"+emp.getSal());
		}
		System.out.println("修改了"+upEmp("update emp set ename='张三'where empno=7369")+"条数据");//修改
		System.out.println(selectEname("select ename from Emp where empno=7369"));//查询单个数据
		
		
		
	}
	

}
