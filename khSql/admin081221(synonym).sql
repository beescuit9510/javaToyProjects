--공개 동의어
create public synonym DEPT for KH.DEPARTMENT;
drop public synonym DEPT;

grant select on KH.DEPARTMENT to byunduck;
grant select on KH.EMPLOYEE to byunduck;

revoke select on KH.DEPARTMENT from byunduck;