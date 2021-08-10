create table copy_department
as
select * from DEPARTMENT;


-- 1 column 추가 !
alter table copy_department
add(add_col1 varchar2(10));

-- column 추가 with default values
alter table copy_department
add(add_col2 number default(10));




-- 2 column datatype 변경
alter table copy_department
modify DEPT_ID varchar2(2);
--modify DEPT_ID varchar2(1);
-- DEPT_ID는 D%형식이라 모든 데이터는 최소 2길이. varchar2(1byte) 불가능

-- 여러개 column datatype 변경
alter table copy_department
modify DEPT_ID char(2)
modify ADD_COL1 char(5);



-- 3 제약 조건 추가 !

-- 제약 조건 검색 !
select UC.CONSTRAINT_NAME,
    UC.CONSTRAINT_TYPE,
    UC.TABLE_NAME,
    UCC.COLUMN_NAME,
    UC.SEARCH_CONDITION
from USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC 
ON(UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'COPY_DEPARTMENT';  -- 반드시 대문지


-- PRIMARY KEY 추가 !
alter table copy_department
add constraint copy_department_PK primary key (DEPT_ID);
-- ADD contraint 제약조건이름, 제약조건 설정.

-- UNIQUE 추가 !
alter table copy_department
add constraint copy_department_uni unique(DEPT_TITLE);

-- not null 추가 !
alter table copy_department
modify ADD_COL2 constraint copy_department_nn1 not null;
--modify ADD_COL1 constraint copy_department_nn1 not null;
--COL1은 NULL 이 기본값이기에 NOT NULL 불가




-- 4 column 삭제 !
alter table copy_department
drop column ADD_COL1 ; -- ADD COL1 안 데이터도 같이 삭제
-- 삭제된 column이 다른 table의 foreign key로 참조된 키 일 경우 문제가 생길수 있음.




--5 제약조건 삭제

alter table copy_department
drop constraint copy_department_uni;


-- NOT NULL 삭제할땐 MODIFY
alter table copy_department
modify ADD_COL2 NULL;





--6 COLUMN NAME 변경
alter table copy_department
rename column ADD_COL2 to ADD_COL;



--7 contraint name 변경
alter table copy_department
rename constraint SYS_C007093 to department_id_nn;


--8 table name 변경
alter table copy_department
rename to change_table_name;

select * from change_table_name;

alter table change_table_name
rename to copy_department;

select * from copy_department;


--- drop : 객체 삭제;

drop table copy_department;
