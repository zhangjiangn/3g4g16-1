package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Emp;

public class Ass {
	Connection conn=ODBC.getConnection();
	
	
	
   public List<Emp> find(){
	   List<Emp> list=new ArrayList<Emp>();
	   try {
		   
		   PreparedStatement ps=conn.prepareStatement("select * from emp");
		   ResultSet rs=ps.executeQuery();
		  
		  while(rs.next()){
			  Emp emp=new Emp();
			  emp.setEmpno(rs.getInt("empno"));
			  emp.setEname(rs.getString("ename"));
			  emp.setJob(rs.getString("job"));
			  emp.setHiredate(rs.getString("hiredate"));
			  list.add(emp);
			  
		  }
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;

   }
   public List<Object[]> select(){
	   List<Object[]> list =new ArrayList<Object[]>();
	   try {
		PreparedStatement ps=conn.prepareStatement("select * from emp");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Object[] ob=new Object[4] ;
			ob[0]=rs.getObject(1);
			ob[1]=rs.getObject(2);
			ob[2]=rs.getObject(3);
			ob[3]=rs.getObject(4);
			list.add(ob);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	return list;
	   
   }
	public int add(Emp emp){
		int i=0;
		try {
		
			PreparedStatement ps=conn.prepareStatement("insert into emp(empno,ename,job,hiredate) values(?,?,?,?)");
			
			ps.setInt(1,emp.getEmpno());
			ps.setString(2,emp.getEname() );
			ps.setString(3,emp.getJob() );
			ps.setString(4,emp.getHiredate());
			i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}
	public int update(Emp emp){
		int i=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update emp set ename=?,job=? where empno=?");
			ps.setString(1, emp.getEname());
			ps.setString(2,emp.getJob());
			ps.setInt(3, emp.getEmpno());
			i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public int delete(int emp){
		int i=0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from emp where empno=?");
			
			ps.setInt(1, emp);
			i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
  }
