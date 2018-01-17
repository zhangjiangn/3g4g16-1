package cn.qhit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.qhit.model.Dept;
import cn.qhit.odbc.ODBC;

public class DeptDao {
	static Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	public List<Dept> select1(){
		List<Dept> list=new ArrayList<Dept>();
		try {
			con=ODBC.getConnection();
			st=con.createStatement();
			String sql="select * from dept";
			rs=st.executeQuery(sql);
			while(rs.next()){
				Dept dept=new Dept();
				dept.setDid(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setTel(rs.getString(3));
				dept.setRess(rs.getString(4));
				list.add(dept);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Dept select2(int did){
		Dept dept=null;
		try {
			con=ODBC.getConnection();
			String sql="select * from dept where did=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,did);
			rs=ps.executeQuery();
			while(rs.next()){
				dept=new Dept();
				dept.setDid(rs.getInt("did"));
				dept.setDname(rs.getString("dname"));
				dept.setTel(rs.getString("tel"));
				dept.setRess(rs.getString("ress"));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
    }
	public void insert(Dept dept){
		try {
			con=ODBC.getConnection();
			String sql="insert into Dept values(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,dept.getDid());
			ps.setString(2,dept.getDname());
			ps.setString(3,dept.getTel());
			ps.setString(4,dept.getRess());
			ps.execute();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public int delete(int did){
		 int i=0;
     	try {
        	con=ODBC.getConnection();
         	String sql="delete from dept where did=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, did);
		    i=ps.executeUpdate();
		    con.close();
     	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
     	return i;
     }
	public int update(Dept dept) {
		int i=0;
		try {
        	con=ODBC.getConnection();
         	String sql="update dept set dname=?,tel=?,ress=? where did=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,dept.getDname());
			ps.setString(2,dept.getTel());
			ps.setString(3,dept.getRess());
			ps.setInt(4,dept.getDid());
			i=ps.executeUpdate();
			con.close();
     	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return i;
	}
}
