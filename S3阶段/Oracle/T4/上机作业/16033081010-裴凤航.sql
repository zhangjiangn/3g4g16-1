select * from emp
--每页个数*当前页      每页个数*（当前页-1）
select * from (select rownum r,e.* from emp e where rownum<=10) where r>5 

--1、列出至少有一个员工的所有部门。
select distinct  dname  from dept d ,emp e where e.deptno=d.deptno(+)
--2、列出薪金比“SMITH”多的所有员工。
select * from emp where sal>(select sal from emp where ename='SMITH')
--3、列出所有员工的姓名及其直接上级的姓名。
select e.empno,e.ename,m.ename,m.empno from emp e,emp m where e.mgr=m.empno
--4、列出受雇日期早于其直接上级的所有员工。
select * from emp 

