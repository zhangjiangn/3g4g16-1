package test;

import java.util.List;

import beans.Dept;

import dao.DeptDao;

public class Test {
	public static void main(String[] args) {
		DeptDao dd=new DeptDao();
		Dept d=dd.selectD(2);
		System.out.println(d.getDid()+d.getDname()+d.getRess()+d.getTel());
	}
}
