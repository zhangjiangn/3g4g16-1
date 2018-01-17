create database Student
create table student(
 sid int primary key identity(1,1),
 snam nvarchar(20) not null check(len(snam)>1),
 sex nvarchar(1) not null default '男',
 class nvarchar(20) null,
 city nvarchar(20) null,
 birth varchar(30) null
)
create table course(
 cid int primary key identity(1,1),
 cnam nvarchar(20) not null unique
)
create table score(
 scid int primary key identity(1,1),
 sid int not null foreign key references student(sid),
 cid int not null foreign key references course(cid),
 score decimal(5,1)
)
insert into student values('tom','男','1990-09-19','st1201','广东')
insert into student values('jack','男','1996-12-18','st1201','江西')
insert into student values('kelly','女','1992-03-12','st1202','湖北')
insert into student values('red','女','1991-07-21','st1202','广东')
insert into student values('green','女','1995-12-11','st1202','湖北')
insert into student values('blue','男','1994-11-25','st1201','湖南')
insert into course values('C语言')
insert into course values('java')
insert into course values('jsp')
insert into course values('oracle')
insert into score(sid,cid,score) values(1,1,70)
insert into score(sid,cid,score) values(1,2,50)
insert into score(sid,cid,score) values(1,3,60)
insert into score(sid,cid,score) values(2,1,87.5)
insert into score(sid,cid,score) values(2,2,92.5)
insert into score(sid,cid,score) values(2,3,100)
insert into score(sid,cid,score) values(3,1,75)
update score set score=score+5
delete from score where sid=3 and cid=1