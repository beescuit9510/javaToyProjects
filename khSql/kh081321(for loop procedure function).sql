set serveroutput on;
 
 
 --전체 구문 !
DECLARE
    ID number;
BEGIN
    select EMP_ID
    into ID
    from EMPLOYEE
    where EMP_NAME='송종기';
    DBMS_OUTPUT.PUT_LINE(ID);
EXCEPTION
    when NO_DATA_FOUND then DBMS_OUTPUT.PUT_LINE('NO DATA!');
END;
/



-- 서브쿼리 이용!
declare
    NAME varchar2(20);
    DEPTMENT_TITLE VARCHAR2(20);
    J_NAME VARCHAR2(30);
begin
    select E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
    into NAME, DEPTMENT_TITLE, J_NAME
    from EMPLOYEE E
    left join DEPARTMENT D
    on(E.DEPT_CODE=D.DEPT_ID )
    left join JOB J 
    on(J.JOB_CODE=E.JOB_CODE)
    where E.EMP_ID='200';
    DBMS_OUTPUT.PUT_LINE(NAME);
    DBMS_OUTPUT.PUT_LINE(DEPTMENT_TITLE);
    DBMS_OUTPUT.PUT_LINE(J_NAME);
end;
/


-- 값 대입하기 넣기!
DECLARE
    DATA1 NUMBER;
    DATA2 VARCHAR2(20);
    DATA3 VARCHAR(20);
BEGIN
    DATA1 := 100;
    DATA2 := '안녕하세요';
    DATA3 := 'HI';
    DBMS_OUTPUT.PUT_LINE(DATA1);
    DBMS_OUTPUT.PUT_LINE(DATA2);
    DBMS_OUTPUT.PUT_LINE(DATA3);
END;
/




create table TEST_EMP
as
select EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
from EMPLOYEE
where 1=0;

select * from TEST_EMP;


-- 값 받아오기 
declare
    id number;
    name varchar(20);
    d_code varchar(10);
    j_code varchar(10);
begin
     id := &사번;
     name := '&이름';
     d_code := '&부서코드';
     j_code := '&직급코드';
    insert into TEST_EMP values(id,name,d_code,j_code);
end;
/



-- 값 테이블에서 검색하기 검색해서 대입하기 !
declare
    id number;
    name varchar(20);
    d_code varchar(10);
    j_code varchar(10);
begin
    select EMP_NAME, EMP_ID, DEPT_CODE, JOB_CODE
    into name, id, d_code, j_code
    from EMPLOYEE
    where EMP_ID='&사원번호';
    insert into TEST_EMP values(id,name,d_code,j_code);
end;
/




-- 1 참조형 ! TYPE !
declare
    ID EMPLOYEE.EMP_ID%TYPE;
    NAME EMPLOYEE.EMP_NAME%TYPE;
    D_CODE EMPLOYEE.DEPT_CODE%TYPE;
    J_CODE EMPLOYEE.JOB_CODE%TYPE;
BEGIN
    SELECT EMP_ID,EMP_NAME,DEPT_CODE,JOB_CODE
    INTO ID, NAME, D_CODE, J_CODE
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE(ID);
    DBMS_OUTPUT.PUT_LINE(NAME);
    DBMS_OUTPUT.PUT_LINE(D_CODE);
    DBMS_OUTPUT.PUT_LINE(J_CODE);
END;
/



-- 2 참조형 ROWTYPE !
declare
    USERINFO EMPLOYEE%ROWTYPE;
begin
    select EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
    into USERINFO.EMP_ID, USERINFO.EMP_NAME, 
    USERINFO.DEPT_CODE, USERINFO.JOB_CODE
    from EMPLOYEE
    where EMP_ID='202';
    DBMS_OUTPUT.PUT_LINE(USERINFO.EMP_ID);
    DBMS_OUTPUT.PUT_LINE(USERINFO.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(USERINFO.JOB_CODE);
    DBMS_OUTPUT.PUT_LINE(USERINFO.DEPT_CODE);

end;
/



-- 3 참조형 RECORD ! ROW와 비슷하지만, 내부구성을 바꿈
DECLARE
    TYPE MY_RECORD IS RECORD(
        MYID    EMPLOYEE.EMP_ID%TYPE,
        MYNAME  EMPLOYEE.EMP_NAME%TYPE,
        MY_D_CODE EMPLOYEE.DEPT_CODE%TYPE,
        MY_J_CODE EMPLOYEE.JOB_CODE%TYPE
    );
    MY  MY_RECORD;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
    INTO MY
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE(MY.MYID);
    DBMS_OUTPUT.PUT_LINE(MY.MYNAME);
    DBMS_OUTPUT.PUT_LINE(MY.MY_D_CODE);
    DBMS_OUTPUT.PUT_LINE(MY.MY_J_CODE);
END;
/






--- 실습1/2/3
declare 
    id EMPLOYEE.EMP_ID%type;
    name EMPLOYEE.EMP_NAME%type;
    dcode EMPLOYEE.DEPT_CODE%type;
    jcode EMPLOYEE.JOB_CODE%type;
begin
    select EMP_ID,EMP_NAME,DEPT_CODE,JOB_CODE
    into id,name,dcode,jcode
    from EMPLOYEE
    where EMP_NAME='송종기';
    DBMS_OUTPUT.PUT_LINE(id);
    DBMS_OUTPUT.PUT_LINE(name);
    DBMS_OUTPUT.PUT_LINE(dcode);
    DBMS_OUTPUT.PUT_LINE(jcode);
end;
/


declare
    type myrecord is record(
        id   EMPLOYEE.EMP_ID%TYPE,
        name   EMPLOYEE.EMP_NAME%TYPE,
        depart_title DEPARTMENT.DEPT_TITLE%TYPE,
        j_name JOB.JOB_NAME%TYPE
    );
    my myrecord;
begin
    select e.EMP_ID ,e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME
    into my
    from EMPLOYEE e
    left join DEPARTMENT d
    on(e.DEPT_CODE=d.DEPT_ID )
    left join JOB j
    on(j.JOB_CODE=e.JOB_CODE)
    where e.EMP_NAME='&이름';
    DBMS_OUTPUT.PUT_LINE(my.id);
    DBMS_OUTPUT.PUT_LINE(my.name);
    DBMS_OUTPUT.PUT_LINE(my.depart_title);
    DBMS_OUTPUT.PUT_LINE(my.j_name);

end;
/
    

declare
    emp EMPLOYEE%ROWTYPE;
    depart DEPARTMENT%ROWTYPE;
begin
    select e.EMP_NAME, e.EMP_NO, e.HIRE_DATE, e.DEPT_CODE, d.DEPT_TITLE
    into emp.EMP_NAME, emp.EMP_NO, emp.HIRE_DATE, emp.DEPT_CODE, depart.DEPT_TITLE
    from EMPLOYEE e
    left join DEPARTMENT d
    on(e.DEPT_CODE=d.DEPT_ID)
    where  EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE(emp.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE(emp.EMP_NO);
    DBMS_OUTPUT.PUT_LINE(emp.HIRE_DATE);
    DBMS_OUTPUT.PUT_LINE(emp.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE(depart.DEPT_TITLE);
end;
/







--조건문 !
declare
    id EMPLOYEE.EMP_ID%TYPE;
    name EMPLOYEE.EMP_NAME%TYPE;
    sal EMPLOYEE.SALARY%TYPE;
    bo EMPLOYEE.BONUS%TYPE;
begin
    select EMP_ID, EMP_NAME, SALARY, BONUS
    into id,name,sal,bo
    from EMPLOYEE
    where EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE(id);
    DBMS_OUTPUT.PUT_LINE(name);
    DBMS_OUTPUT.PUT_LINE(sal);
    DBMS_OUTPUT.PUT_LINE('보너스 : '||bo*100||'%');
    if(bo is null)
    then
    DBMS_OUTPUT.PUT_LINE('보너스가 없는 사원');
    end if;
end;
/


--if else if then else 조건문 !
declare 
    gender number;
    name EMPLOYEE.EMP_NAME%TYPE;
    d_code EMPLOYEE.DEPT_CODE%TYPE;
begin
    select EMP_NAME, DEPT_CODE, SUBSTR(EMP_NO,8,1)
    into name,d_code,gender
    from EMPLOYEE
    where EMP_ID='&사원번호';
    DBMS_OUTPUT.PUT_LINE(name);
    DBMS_OUTPUT.PUT_LINE(gender);
    DBMS_OUTPUT.PUT_LINE(d_code);
    if(gender in (1,3))
    then
    DBMS_OUTPUT.PUT_LINE('남자 사원 입니다.');
    elsif(gender in (2,4))
    then
    DBMS_OUTPUT.PUT_LINE('여자 사원 입니다.');
    else
    DBMS_OUTPUT.PUT_LINE('사원의 성별을 알 수 없습니다.');
    end if;
end;
/

-- case 문 !!  
declare 
    gender number;
    gender_char char(3);
    name EMPLOYEE.EMP_NAME%TYPE;
    d_code EMPLOYEE.DEPT_CODE%TYPE;
begin
    select EMP_NAME, DEPT_CODE, SUBSTR(EMP_NO,8,1)
    into name,d_code,gender
    from EMPLOYEE
    where EMP_ID='&사원번호';
    DBMS_OUTPUT.PUT_LINE(name);
    DBMS_OUTPUT.PUT_LINE(gender);
    DBMS_OUTPUT.PUT_LINE(d_code);
    case gender
    --- 같은 경우의 수가 2가지 이상 일땐 가장 첫번째만 실행;
        when 1 then gender_char := '남';
        when 2 then gender_char := '여';
        when 1 then DBMS_OUTPUT.PUT_LINE('남자 사원 입니다.');
        when 2 then DBMS_OUTPUT.PUT_LINE('여자 사원 입니다.');
        else DBMS_OUTPUT.PUT_LINE('사원의 성별을 알수 없습니다.');
    end case;
    DBMS_OUTPUT.PUT_LINE(gender_char);
end;
/






-- 실습 !
declare
    name EMPLOYEE.EMP_NAME%TYPE;
    depart_title DEPARTMENT.DEPT_TITLE%TYPE;
begin
    select e.EMP_NAME, d.DEPT_TITLE
    into name, depart_title
    from EMPLOYEE e
    left join DEPARTMENT d
    on(e.DEPT_CODE=d.DEPT_ID)
    where e.EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('이름 :'||name);
    if( depart_title is null)
    then
    DBMS_OUTPUT.PUT_LINE('부서가 없는 사원 입니다');
    else
    DBMS_OUTPUT.PUT_LINE('부서명: '||depart_title);
    end if;
end;
/

declare
    emp EMPLOYEE%ROWTYPE;
    depart DEPARTMENT%ROWTYPE;
begin
    select e.EMP_ID, e.EMP_NAME, e.DEPT_CODE, e.JOB_CODE, d.DEPT_TITLE
    into emp.EMP_ID,emp.EMP_NAME,emp.DEPT_CODE,emp.JOB_CODE, depart.DEPT_TITLE
    from EMPLOYEE e
    left join DEPARTMENT d
    on(e.DEPT_CODE=d.DEPT_ID)
    where e.EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('사번: '||emp.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('직원 이름: '||emp.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드: '||emp.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('부서명: '||depart.DEPT_TITLE);
    if(emp.JOB_CODE in ('J1','J2'))
    then
    DBMS_OUTPUT.PUT_LINE('소속값: 임원진');
    else
    DBMS_OUTPUT.PUT_LINE('소속값: 일반직원');
    end if;
end;
/

declare
    emp EMPLOYEE%ROWTYPE;
begin
    select EMP_ID, EMP_NAME, SALARY, SAL_LEVEL
    into emp.EMP_ID,emp.EMP_NAME, emp.SALARY, emp.SAL_LEVEL
    from EMPLOYEE
    where EMP_ID='&사번';
    if(emp.SALARY between 1000000 and 1990000)
    then
    emp.SAL_LEVEL := 'E';
    elsif(emp.SALARY between 2000000 and 2990000)
    then
    emp.SAL_LEVEL := 'D';
    elsif(emp.SALARY between 3000000 and 3990000)
    then
    emp.SAL_LEVEL := 'C';
    elsif(emp.SALARY between 4000000 and 4990000)
    then
    emp.SAL_LEVEL := 'B';
    elsif(emp.SALARY > 5000000)
    then
    emp.SAL_LEVEL := 'A';
    end if;
    DBMS_OUTPUT.PUT_LINE('사번: '||emp.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('직원 이름: '||emp.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드: '||emp.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('급여: '||emp.SALARY);
    DBMS_OUTPUT.PUT_LINE('급여 등급: '||emp.SAL_LEVEL);
end;
/



declare
    emp EMPLOYEE%ROWTYPE;
begin
    select EMP_ID, EMP_NAME, SALARY, SAL_LEVEL
    into emp.EMP_ID,emp.EMP_NAME, emp.SALARY, emp.SAL_LEVEL
    from EMPLOYEE
    where EMP_ID='&사번';
    case FLOOR(emp.SALARY/1000000)
            when 0 then emp.SAL_LEVEL := 'F';
            when 1 then emp.SAL_LEVEL := 'E';
            when 2 then emp.SAL_LEVEL := 'D';
            when 3 then emp.SAL_LEVEL := 'C';
            when 4 then emp.SAL_LEVEL := 'B';
            else emp.SAL_LEVEL := 'A';
    end case;
    DBMS_OUTPUT.PUT_LINE('사번: '||emp.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('직원 이름: '||emp.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드: '||emp.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('급여: '||emp.SALARY);
    DBMS_OUTPUT.PUT_LINE('급여 등급: '||emp.SAL_LEVEL);
end;
/



select * from EMPLOYEE;





set serveroutput on;

-- 1 반복문 loop ! 무한 반복 ! 

declare
    num number := 1;
begin
    loop 
    if num>5
    then exit;
    end if;
    DBMS_OUTPUT.PUT_LINE(num);
    num := num+1;
    end loop;
end;
/



-- 2 반복문  for loop !! 
--declare
begin
    for num in 1..5 loop
    DBMS_OUTPUT.PUT_LINE(num);
    end loop;
end;
/


-- 3 반복문 reverse for loop ! 거꾸로 for문
begin
    for num in reverse 1..5 loop
    DBMS_OUTPUT.PUT_LINE(num);
    end loop;
end;
/


-- for  문 이용해서 출력 !
declare
    emp EMPLOYEE_COPY%ROWTYPE;
begin
    for num in 1..4 loop
        select EMP_NAME, DEPT_TITLE
        into emp.EMP_NAME,emp.DEPT_TITLE
        from EMPLOYEE_COPY
        where EMP_ID = 200+num;
        DBMS_OUTPUT.put_line('이름 : '||emp.EMP_NAME);
        DBMS_OUTPUT.PUT_LINE('부서명 : '||emp.DEPT_TITLE);
    end loop;
end;
/





-- for 이용해서 값 넣기 !

truncate table EMPLOYEE_COPY;

declare
 emp EMPLOYEE%ROWTYPE;
 d_title DEPARTMENT.DEPT_TITLE%TYPE;
 j_name JOB.JOB_NAME%TYPE;
begin
    for num in 1..10 loop
        select e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE, j.JOB_NAME, e.SALARY
        into emp.EMP_ID, emp.EMP_NAME, d_title, j_name,emp.SALARY
        from EMPLOYEE e
        left join DEPARTMENT d
        on(e.DEPT_CODE=d.DEPT_ID)
        left join JOB j
        on(e.JOB_CODE=j.JOB_CODE)
        where e.EMP_ID=200+num;
        insert into EMPLOYEE_COPY values(emp.EMP_ID,emp.EMP_NAME,d_title,j_name,emp.SALARY);
    end loop;
end;
/


-- 랭킹출력 !
select T2.*
from
(select rownum as rnum, T.* from
(select EMP_NAME, NVL(BONUS, 0) from EMPLOYEE order by SALARY DESC) T
) T2 
where T2.rnum = 1;



declare
    keyword varchar2(20);
    ranking number;
    emp EMPLOYEE%ROWTYPE;
begin
    keyword := '&키워드 입력 :';

    case keyword
        when '급여' then 
            DBMS_OUTPUT.PUT_LINE('--------급여 랭킹 TOP 5--------');
        when '보너스' then
            DBMS_OUTPUT.PUT_LINE('--------보너스 랭킹 TOP 5--------');
        when '입사일' then
            DBMS_OUTPUT.PUT_LINE('--------입사일 랭킹 TOP 5--------');
    end case;
    select rownum, T.EMP_NAME, T.SALARY
    into ranking, emp.EMP_NAME, emp.SALARY
    from
    (select EMP_NAME, (select if(keyword='급여', SALARY, keyword='보너스', BONUS, HIRE_DATE) from EMPLOYEE)
    from EMPLOYEE order by (select if(keyword='급여', SALARY, keyword='보너스', BONUS, HIRE_DATE) from EMPLOYEE) DESC) T
    where rownum =1;
    DBMS_OUTPUT.PUT_LINE(ranking);
    DBMS_OUTPUT.PUT_LINE(emp.SALARY);
    DBMS_OUTPUT.PUT_LINE(emp.EMP_NAME);
end;
/





-- 프로시저 리턴 xxx
-- 함수 리턴 ooo


--- 프로시저!!!!!!!!!! 공부 필수 !
create table test_member(
    member_id varchar2(20) primary key,
    member_name varchar2(20) not null,
    member_age number
);

create table ref_test_member(
    num number primary key,
    member_id varchar2(20) references test_member(member_id)
);

create sequence ref_sequence;
insert into test_member values('user01','유저1',20);
insert into test_member values('user02','유저2',21);
insert into test_member values('user03','유저3',22);
insert into test_member values('user04','유저4',23);

insert into ref_test_member values(ref_sequence.nextval, 'user03');
select * from test_member;
select * from ref_test_member;

savepoint savepoint1;
commit;
rollback;



-- 프로시저 정의하기 만드는 법!
create or replace procedure del_test_member(ID TEST_MEMBER.MEMBER_ID%TYPE)
-- parameter 정의할때 길이 지정 X ex) ID vacrchar2 
IS
BEGIN
    DELETE FROM REF_TEST_MEMBER WHERE MEMBER_ID=ID;
    DELETE FROM TEST_MEMBER WHERE MEMBER_ID=ID;
END;
/

create or replace procedure del_test_member2(name varchar2)
IS
    id test_member.member_id&type;
BEGIN
    select member_id
    into id
    from test_member
    where MEMBER_NAME=name;
    DELETE FROM REF_TEST_MEMBER WHERE MEMBER_ID=ID;
    DELETE FROM TEST_MEMBER WHERE MEMBER_ID=ID;
END;
/


-- 프로시저 사용법!!
EXEC del_test_member('user01');




--함수 ! 정의하기 만드는 법 !
create or replace function annual_salary(sal number, bo number)
return number
is
    calc_sal number;
begin
    calc_sal := (sal+(sal*NVL(bo, 0)))*12;
    return calc_sal;
end;
/

create or replace function annual_salary2(id EMPLOYEE.EMP_ID%TYPE)
return number
is
    sal number;
    bo number;
    calc_sal number;
begin
    select SALARY, BONUS
    into sal,bo
    from EMPLOYEE
    where EMP_ID=id ;
    calc_sal := (sal+(sal*NVL(bo, 0)))*12;
    return calc_sal;
end;
/

select EMP_NAME, (annual_salary(SALARY, BONUS)) as "연봉"
from EMPLOYEE;

select EMP_NAME, (annual_salary2(EMP_ID)) as "연봉"
from EMPLOYEE;





create table product(
    pcode number primary key,
    pname varchar2(30),
    brand varchar2(30),
    price number,
    stock number
);

create sequence p_sequence;

create table pro_inout(
    no number primary key,
    prode number references product(pcode),
    pdate date,
    amount number,
    status char(6) check(status in ('입고','출고'))
);

create sequence io_sequence;


insert into product values(p_sequence.nextval,'에어팟프로','애플',240000,0);
insert into product values(p_sequence.nextval,'갤럭시버즈','삼성',240000,0);
insert into PRO_INOUT values(io_sequence.nextval,1,sysdate,10,'입고');
update product set stock = 10 where pcode = 1;


create or replace procedure product_inout(p_name product.pname%type, amount number, isOut varchar2)
is
    p_code product.pcode%type;
    p_amount product.stock%type;
    r_amount number;
begin
    select pcode, stock
    into p_code, p_amount
    from product
    where pname = p_name;
    if(isOut like '출고')
        then r_amount := amount*-1;
    else
        r_amount := amount;
    end if;
    
    if(p_amount+r_amount<0)
        then DBMS_OUTPUT.PUT_LINE('출고가 불가합니다. 상품이 부족합니다.');
    else
        insert into pro_inout values(io_sequence.nextval, p_code,sysdate,amount,isOut);
        update product set stock = stock+r_amount where pname = p_name;
    end if;
end;
/

rollback;
exec product_inout('에어팟프로',5,'입고');
exec product_inout('에어팟프로',5,'출고');
exec product_inout('에어팟프로',20,'출고');
exec product_inout('에어팟프로',9,'출고');

select *from product;
select * from pro_inout;

