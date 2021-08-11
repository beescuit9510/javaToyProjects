create view EMP_VIEW
as
select EMP_NAME, EMAIL, PHONE from EMPLOYEE;

create table VIEW_TEST
as
select EMP_NAME, EMAIL, PHONE from EMPLOYEE;


-- table 복사 원본 영향 X view 복사 원본 영향 O;
update VIEW_TEST set PHONE = '01012341234' where EMP_NAME='임시환';
update EMP_VIEW set PHONE = '01012341234' where EMP_NAME='임시환';

rollback;



-- view가 원본 영향이 안가는 경우 !
create view EMP_VIEW2
as
select
e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME
from EMPLOYEE e
left join DEPARTMENT d
on(e.DEPT_CODE=d.DEPT_ID)
left join JOB j
on(j.JOB_CODE=e.JOB_CODE);

-- view의 본 목적은 조회! 편집은 주목적X
-- join/distinct/group by나 그룹함수로 만들어진
-- view의 경우 원래 테이블 편집 불가.


-- create or replace 겹치는 이름의 view 만들기/ 테이블 갱신
create or replace view EMP_VIEW
as
SELECT EMP_NAME, EMAIL, PHONE, DEPT_CODE 
from EMPLOYEE;


-- 원본 테이블에 row가 추가되면 view에서도 추가됨.
create table USER101(
    NAME varchar(20)
);
insert into USER101 values('장변덕');

create view USER101_VIEW
as
select * from USER101;

insert into USER101 values('고양이');
insert into USER101 values('강아지');

select * from USER101;
select * from USER101_VIEW;


--force / noforce 기본은 noforce/ force는 테이블이없는 상태에서 강제로 만드는것/
-- with check option 옵션을 설정한 column값 변경 불가;
-- / with read only 조회O 삽입/수정/삭제X

select * from EMP_VIEW;
select * from VIEW_TEST;
select * from EMPLOYEE;
select * from EMP_VIEW2;






-- sequence 만들기 !
create sequence TEST_SEQ
start with 1 
increment by 1
maxvalue 20
nocycle; --(maxvalue)100 초과시 에러

drop sequence TEST_SEQ;
select TEST_SEQ.NEXTVAL from dual; --요청할때마다 다음 값
select TEST_SEQ.CURRVAL from dual; -- sequence 의 현재 값 next후에 사용가능!

create table SEQ_TEST(
    TEST_NO NUMBER PRIMARY KEY,
    DATA1 VARCHAR2(30) NOT NULL,
    DATA2 VARCHAR2(40) UNIQUE
);

insert into SEQ_TEST values(TEST_SEQ.NEXTVAL,
                            'TEST'||TEST_SEQ.CURRVAL,
                            'TEST'||TEST_SEQ.CURRVAL);

delete from SEQ_TEST where TEST_NO=1;

truncate table SEQ_TEST;
select * from SEQ_TEST;




-- sequence 값 바꾸기 !
create sequence TEST_SEQ3
start with 1 
increment by 1
maxvalue 1000
nocycle;

--start 는 못 바꿈drop으로 삭제후 다시 만들어야함
alter sequence TEST_SEQ3
increment by 10
maxvalue 10000;


--sequence 간단히 만들기 ! start 1/increment by 1
create sequence TEST_SEQ4;

select TEST_SEQ3.NEXTVAL from dual;



-- sequence 실습
create table KH_MEMBER(
    MEMBER_ID NUMBER,
    MEMBER_NAME VARCHAR2(20),
    MEMBER_AGE NUMBER,
    MEMBER_JOIN_COM NUMBER
);

create sequence ID_SEQ
start with 500
increment by 10
maxvalue 1000
nocycle;

create sequence JOIN_COM_SEQ
start with 1
increment by 1
maxvalue 1000
nocycle;

drop sequence ID_SEQ;
drop sequence JOIN_COM_SEQ;
truncate table KH_MEMBER;

insert all into 
KH_MEMBER values(ID_SEQ.NEXTVAL,'홍길동',20,JOIN_COM_SEQ.NEXTVAL)
into KH_MEMBER values(ID_SEQ.NEXTVAL,'김말똥',30,JOIN_COM_SEQ.NEXTVAL)
into KH_MEMBER values(ID_SEQ.NEXTVAL,'삼식이',40,JOIN_COM_SEQ.NEXTVAL)
into KH_MEMBER values(ID_SEQ.NEXTVAL,'고길똥',24,JOIN_COM_SEQ.NEXTVAL)
select 1 from dual;

select * from KH_MEMBER;







--index !!
-- 테이블 값이 몇천이 될때 조회가 인덱스를 이용할때 훨씬 빠름
--하지만 insert delete 등이 많은 테이블은 인덱스가 있으면 훨씬 느림.
create index EMP_IND on EMPLOYEE(EMP_NAME,EMP_NO,HIRE_DATE);

select EMP_NAME, EMP_NO, HIRE_DATE from EMPLOYEE;



--- Synonym!!!
-- table 명을 대신함/ 기본 synonym;
create SYNONYM EMP for EMPLOYEE;


select * from EMP;


