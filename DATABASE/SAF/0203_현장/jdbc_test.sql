use scottdb;


create table myemp
as
select empid, concat(fname, ' ', lname) name, phone, jobid, deptid
from emp
where deptid in (10, 20, 30, 40, 60, 70);

select * from myemp;