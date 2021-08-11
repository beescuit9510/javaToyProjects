
select constraint_name, constraint_type from user_constraints
where table_name='EMPLOYEE';
--P : primary key
--r : foreign key
--c : check or not null
--u : unique



select table_name, column_name, constraint_name
from user_cons_columns
where table_name = 'EMPLOYEE'
union
select table_name, constraint_name, constraint_type
from user_constraints
where table_name='EMPLOYEE'
order by 3 desc;

select * from user_tables;
desc EMPLOYEE;


SELECT * FROM USER_TABLES;

-- 테이블 복사 !
CREATE TABLE COPY_EMPLOYEE
AS
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE FROM EMPLOYEE;
--(조회결과 대로 테이블 생성, 칼럼/자료형(길이) 복사, 제약조건은NOT NULL)
SELECT * FROM COPY_EMPLOYEE;

select table_name, column_name, constraint_name
from user_cons_columns
where table_name = 'COPY_EMPLOYEE';


-- 테이블 틀만 복사 !
CREATE TABLE COPY_EMPLOYEE2
AS
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE FROM EMPLOYEE
WHERE 1=0;
--(조회결과 대로 테이블 생성, 칼럼/자료형(길이) 복사, 제약조건은NOT NULL)
SELECT * FROM COPY_EMPLOYEE2;


