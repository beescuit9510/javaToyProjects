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
            when 1 then emp.SAL_LEVEL := 'F';
            when 2 then emp.SAL_LEVEL := 'E';
            when 3 then emp.SAL_LEVEL := 'D';
            when 4 then emp.SAL_LEVEL := 'C';
            when 5 then emp.SAL_LEVEL := 'B';
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






