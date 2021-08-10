create table EMP_01(
    EMP_ID number,
    EM_NAME varchar2(30),
    DEPT_TITLE varchar2(20)
);

-- 누락된 사항이 없고 순서가 일치해야함
insert into EMP_01 values(100,'변덕',null);
insert into EMP_01 values(101,'고양','교육부');

insert into EMP_01 (DEPT_TITLE, EMP_ID, EMP_NAME) 
values('총무부',103, '강아지');

--() 안에 없는 값은 NULL;
insert into EMP_01 (EMP_ID, EMP_NAME)values(104,'원숭이');


-- default값은 원래없었으면 alter 후에나 바뀜 !
alter table EMP_01
modify DEPT_TITLE default '부서가없음';

insert into EMP_01 (EMP_ID,EMP_NAME)values(105,'코끼리');

--조회 결과 넣기 !
insert into EMP_01 (
    select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE
    from employee e
    left join department d
    on (e.DEPT_CODE=d.DEPT_ID)
);


SELECT * FROM EMP_01;
