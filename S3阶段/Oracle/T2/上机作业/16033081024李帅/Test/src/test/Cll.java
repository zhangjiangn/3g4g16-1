package test;

import java.util.ArrayList;
import java.util.List;

import dao.Ass;
import bean.Emp;

public class Cll {
	
	public static void main(String[] args) {
		Emp emp =new Emp();
		Ass as=new  Ass();
		//查询两种方法
//		List<Emp> list=as.find();
//		for (Emp e : list) {
//			System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getJob()+" "+e.getHiredate());
//		}
//		List<Object[]> list=as.select();
//		for (Object[] o: list) {
//			System.out.println(o[0]+"   "+o[1]+"   "+o[2]+"   "+o[3]);
//		}
//		
		//添加
//	    emp.setEmpno(6);
//	    emp.setEname("dsa");
//	    emp.setJob("asdas");
//	    emp.setHiredate("asdasd");
//	    as.add(emp);
//		
		//改
//		emp.setEmpno(7369);
//		emp.setEname("dasd");
//		emp.setJob("qwewdasd");
//		as.update(emp);
//		
		//删除
		//as.delete(1);
		
		
	}

}
