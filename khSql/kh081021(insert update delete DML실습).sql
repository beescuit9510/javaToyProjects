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





create table EMP_02
as
select EMP_ID, EMP_NAME, DEPT_CODE
from EMPLOYEE
where 1=0;

create table EMP_03
as
select EMP_ID, EMP_NAME, JOB_CODE
from EMPLOYEE
where 1=0;

SELECT * FROM EMP_01;


-- insert all 다른 테이블 내용 넣기
insert all 
into EMP_02 values(EMP_ID, EMP_NAME, DEPT_CODE)
into EMP_03 values(EMP_ID, EMP_NAME, JOB_CODE)
select EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
from EMPLOYEE;



create table DEPTARTMENT_COPY
as 
select * from DEPARTMENT;





-- update !

create table EMPlOYEE_COPY
as 
select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME, e.SALARY 
from EMPLOYEE e
left join DEPARTMENT d
on (e.DEPT_CODE=d.DEPT_ID )
left join JOB j
on (j.JOB_CODE=e.JOB_CODE);


-- update tableName set column=value, column=value where 
update EMPLOYEE_COPY set SALARY = 2500000 where EMP_NAME='방명수';
update EMPLOYEE_COPY set JOB_NAME = '주임', DEPT_TITLE='회계관리부' where EMP_ID=214;


-- commit / rollback ! 그전 커밋 상태로 돌아가기 !
commit;

update EMPLOYEE_COPY set JOB_NAME = '주임', DEPT_TITLE='회계관리부';

rollback;


-- 테이블 values 이용해서 값 변경 !
update EMPLOYEE_COPY set SALARY = 
(select SALARY from EMPLOYEE_COPY where EMP_NAME = '유재식')
where EMP_NAME = '방명수';

update EMPLOYEE_COPY set SALARY = SALARY*1.1 where EMP_NAME='윤은해';





select * from EMPLOYEE_COPY order by SALARY desc;

-- delete row ! 
delete from EMPLOYEE_COPY where EMP_ID=200;
--delete from EMPLOYEE_COPY where EMP_ID in 
--(select EMP_ID from EMPLOYEE_COPY where JOB_NAME='사원');
select * from EMPLOYEE_COPY;

rollback;







--transaction
-- commit / rollback !!!!!!1
-- rollback : get back to the latest commit;
commit;

create table USER_TBL(  
    USER_NO NUMBER PRIMARY KEY,
    USER_MAME VARCHAR2(20) UNIQUE,
    USER_ADDR VARCHAR2(100)
);


rollback;
--commit을 안하고 rollback 후에도 table은 있음


insert into USER_TBL values(1,'변덕','강서구');
insert into USER_TBL values(2,'고양이','강서구');
insert into USER_TBL values(3,'강아지','강서구');
commit;
rollback;


-- 임시 저장 / rollback to savepointName
insert into USER_TBL values(4,'개구리','강서구');
savepoint test;

insert into USER_TBL values(5,'코끼리','강서구');
rollback to test;
-- 보통 rollback 바로 가장 최근 commit으로 가서 commit 이전/이후 savepoint도 삭제됨.



create table DEL_USER(
    USER_NO NUMBER PRIMARY KEY,
    USER_NAME VARCHAR2(20),
    USER_ADDR VARCHAR(100),
    DEL_DATE DATE
);


-- 조건과 함께 조건에 해당하는 것만 삭제
delete from USER_TBL;

-- rollback이 안됨. 조건에 해당하는 걸 삭제가 아니라 초기화.
truncate table USER_TBL;

--alter table DEL_USER
--add constraint DEL_DATE_DEFAULT default (sysdate, DEL_DATE);
--insert DEL_USER(USER_NO,USER_NAME,USER_ADDR) values(
--    select * from USER_NO = 5;
--);
--DELETE FROM USER_TBL WHERE USER_NO = 5;

select * from USER_TBL;
select * from DEL_USER;






-- DML 실습
create table RUNNINGMAN(
    NO NUMBER NOT NULL,
    ID VARCHAR2(20) UNIQUE,
    PASS VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    NICKNAME VARCHAR2(20) UNIQUE,
    GENDER CHAR(1),
    TEL VARCHAR2(20) DEFAULT '010-0000-0000',
    ADDRESS VARCHAR2(90)
);

insert into RUNNINGMAN values(1,'muhan','1234','유재석',
                        '못생긴형','M','010-4958-2322','압구정');

insert into RUNNINGMAN values(2,'bignose','4444','지석진',
                        '지는해','M',default,'서울')

insert into RUNNINGMAN values(3,'tiger','6658','김종국',
                        '안꼬','M','010-6674-8986','안양');

insert into RUNNINGMAN values(4,'haha','5356','하하',
                        '신분세탁','M','010-8997-1122','서래마을');
                        
insert into RUNNINGMAN values(5,'ace','5555','송지효',
                        '천성임','F',default,'서울시');

insert into RUNNINGMAN values(6,'giraffe','6658','이광수',
                        '중기친구','M','010-2378-9991','남양주');

insert into RUNNINGMAN values(7,'ssapssap','5356','양세찬',
                        '김종국팬','M','010-1215-7777','동두천');

insert into RUNNINGMAN values(8,'doli','5555','전소민',
                        '전두릅','F',default,'일산');


update RUNNINGMAN set PASS = '9999' where NICKNAME='중기친구';

update RUNNINGMAN set TEL = '없음' where TEL= '010-0000-0000';

delete from RUNNINGMAN where NAME='유재석';

commit; 

TRUNCATE table RUNNINGMAN;

select * from RUNNINGMAN;





