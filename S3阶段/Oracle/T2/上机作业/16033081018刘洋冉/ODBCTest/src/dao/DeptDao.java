package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Dept;

import odbc.ODBCConnection;

public class DeptDao {
	Connection conn=ODBCConnection.getConnection();
	public int updateDept(Dept d){
		int i=0;
		String sql="update dept set dname= ? where did=2";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, d.getDname());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Dept> selectDept(){
		List<Dept> dlist=new ArrayList<Dept>();
		String sql="select * from dept";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Dept d=new Dept();
				d.setDid(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setTel(rs.getString(3));
				d.setRess(rs.getString(4));
				dlist.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}
	
	public Dept selectD(int did){
		Dept d=new Dept();
		String sql="select * from dept where did="+did;
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				d.setDid(rs.getInt(1));
				d.setDname(rs.getString(2));
				d.setTel(rs.getString(3));
				d.setRess(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
