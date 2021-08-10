
-- NOT NULL
CREATE TABLE USER_NOTNULL(
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15),
    USER_GENDER VARCHAR2(10)
);

SELECT * FROM USER_NOTNULL;
INSERT INTO USER_NOTNULL VALUES('USER1','1234','BYUNDUCK','남');
INSERT INTO USER_NOTNULL VALUES('USER1',NULL,'BYUNDUCK','남');




-- UNIQUE
CREATE TABLE USER_UNIQUE(
    USER_ID VARCHAR2(20) UNIQUE,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15),
    USER_GENDER VARCHAR2(10)
);


SELECT * FROM USER_UNIQUE;
INSERT INTO USER_UNIQUE VALUES('USER1','1234','BYUNDUCK','남');
INSERT INTO USER_UNIQUE VALUES('USER1',NULL,'BYUNDUCK','남');
INSERT INTO USER_UNIQUE VALUES(NULL,'1234','BYUNDUCK','남');
INSERT INTO USER_UNIQUE VALUES(NULL,'1234','BYUNDUCK','남');





-- UNIQUE AND NOT NULL
CREATE TABLE USER_UNIQUE2(
    USER_ID VARCHAR2(20) UNIQUE NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15) UNIQUE,
    USER_GENDER VARCHAR2(10)
);

SELECT * FROM USER_UNIQUE2;
INSERT INTO USER_UNIQUE2 VALUES('USER1','1234','BYUNDUCK','남');
INSERT INTO USER_UNIQUE2 VALUES('USER1',NULL,'BYUNDUCK','남');
INSERT INTO USER_UNIQUE2 VALUES(NULL,'1234','BYUNDUCK','남');
INSERT INTO USER_UNIQUE2 VALUES(NULL,'1234','BYUNDUCK','남');







-- UNIQUE COLUMN LEVEL --> TABLE LEVEL DECLAREATION
CREATE TABLE USER_UNIQUE3(
    USER_ID VARCHAR2(20) NOT NULL, -- NOT NULL CANNOT BE DECLARED IN TABLE LEVEL
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15),
    USER_GENDER VARCHAR2(10),
    UNIQUE(USER_ID)  -- TABLE LEVEL
);




-- TABLE LEVEL DECLAREATION
CREATE TABLE USER_UNIQUE3(
    USER_ID VARCHAR2(20) NOT NULL,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15),
    USER_GENDER VARCHAR2(10),
    UNIQUE(USER_ID, USER_NAME)  -- TABLE LEVEL
    --테이블레벨 UNIQUE는 USER_ID, USER_NAME, ETC 모두 다 같은지만 체크.
);

INSERT INTO USER_UNIQUE3 VALUES('USER1','1234','BYUNDUCK','남');
INSERT INTO USER_UNIQUE3 VALUES('USER1','1234','USER1','남');









-- PRIMARY KEY : UNIQUE + NOT NULL 테이블 당 하나
CREATE TABLE USER_PRIMARY(
    USER_ID VARCHAR2(20) PRIMARY KEY, --COLUMN LEVEL
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15) UNIQUE,
    USER_GENDER VARCHAR2(10)
--    PRIMARY KEY(USER_ID) -- TABLE LEVEL
);
INSERT INTO USER_PRIMARY VALUES('USER1','1234','BYUNDUCK','남');
INSERT INTO USER_PRIMARY VALUES('HAPPY','1234','변덕이','남');





-- CHECK !
CREATE TABLE USER_CHECK(
    USER_ID VARCHAR2(20) PRIMARY KEY, --COLUMN LEVEL
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15) UNIQUE,
    USER_GENDER CHAR(1) CHECK(USER_GENDER IN ('M','F'))
--    USER_GENDER CHAR(1) CHECK(USER_GENDER IN ('M','F')) NOT NULL
);

INSERT INTO USER_CHECK VALUES('USER1','1234','BYUNDUCK','F');
INSERT INTO USER_CHECK VALUES('USER2','1234','변덕','M');
INSERT INTO USER_CHECK VALUES('USER3','1234','CAT',NULL); --NULL 은 가능! NOT NULL을 따로 해야함





-- DEFAULT 

CREATE TABLE TEST_DEFAULT(
    BOARD_TITLE VARCHAR(300),
    READ_COUNT NUMBER DEFAULT 0
);


INSERT INTO TEST_DEFAULT VALUES ('제목1',0);
INSERT INTO TEST_DEFAULT (BOARD_TITLE) VALUES('제목3'); 
--자동으로 DEFAULT 값을 대입 
--INSET과 문법이 약간 다름.



CREATE TABLE USER_TBL1(
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15) NOT NULL,
    NICKNAME VARCHAR(30) UNIQUE
);

INSERT INTO USER_TBL1 VALUES('USER1','PW1','유저1','TEST1');
INSERT INTO USER_TBL1 VALUES('USER2','PW1','유저2','TEST2');
INSERT INTO USER_TBL1 VALUES('USER3','PW1','유저3','TEST3');

SELECT * FROM USER_TBL1;





-- FOREIGN KEY 

CREATE TABLE BOARD1(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR(30) NOT NULL,
    BOARD_CONTENT VARCHAR(100) NOT NULL,
    BOARD_WRITER VARCHAR(30) REFERENCES USER_TBL1(USER_ID),
    --유저테이블1의 유저 아이디를 참조 !
    REG_DATE DATE
    
);

SELECT * FROM BOARD1;

INSERT INTO BOARD1 VALUES(1,'TITLE1','CONTENT1','USER1',SYSDATE);
INSERT INTO BOARD1 VALUES(2,'TITLE1','CONTENT1','USER2',SYSDATE);
INSERT INTO BOARD1 VALUES(3,'TITLE1','CONTENT1','USER3',SYSDATE);
INSERT INTO BOARD1 VALUES(4,'TITLE1','CONTENT1','USER4',SYSDATE); 
--USER4는 없음.



-- TABLE LEVEL FOREIN KEY
CREATE TABLE BOARD2(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR(30) NOT NULL,
    BOARD_CONTENT VARCHAR(100) NOT NULL,
    BOARD_WRITER VARCHAR(30),
    REG_DATE DATE,
    FOREIGN KEY (BOARD_WRITER) REFERENCES USER_TBL1(NICKNAEM)
    -- TABLE LEVEL
);

DELETE BOARD2;

INSERT INTO BOARD2 VALUES(1,'TITLE1','CONTENT1','TEST1',SYSDATE);
INSERT INTO BOARD2 VALUES(2,'TITLE1','CONTENT1','TEST2',SYSDATE);
INSERT INTO BOARD2 VALUES(3,'TITLE1','CONTENT1','TEST3',SYSDATE);
INSERT INTO BOARD2 VALUES(4,'TITLE1','CONTENT1','TEST4',SYSDATE); 
--USER4는 없음.







-- COLUMN 생략 가능
CREATE TABLE BOARD3(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR(30) NOT NULL,
    BOARD_CONTENT VARCHAR(100) NOT NULL,
    BOARD_WRITER VARCHAR(30),
    REG_DATE DATE,
    FOREIGN KEY (BOARD_WRITER) REFERENCES USER_TBL1 --COLUMN 생략시 RIMARY KEY로 참조!
);

INSERT INTO BOARD3 VALUES(1,'TITLE1','CONTENT1','USER1',SYSDATE);

DELETE FROM USER_TBL1 WHERE USER_ID = 'USER1';
SELECT * FROM USER_TBL1;





-- TABLE FOREIN KEY with on delete clause
CREATE TABLE USER_TBL2(
    USER_ID VARCHAR2(20) PRIMARY KEY,
    USER_PW VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(15) NOT NULL,
    NICKNAME VARCHAR(30) UNIQUE
);


CREATE TABLE BOARD11(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR(30) NOT NULL,
    BOARD_CONTENT VARCHAR(100) NOT NULL,
    BOARD_WRITER VARCHAR(30),
    REG_DATE DATE,
    FOREIGN KEY (BOARD_WRITER) REFERENCES USER_TBL2 on delete set null
    -- ON DELETE CASCADE / ON DELETE set null
);

DROP TABLE BOARD11;

DELETE FROM USER_TBL2 WHERE USER_ID='user02';
SELECT * FROM BOARD11;
SELECT * FROM USER_TBL2;

INSERT INTO USER_TBL2 VALUES('user01','1234','유저01','테스트1');
INSERT INTO USER_TBL2 VALUES('user02','12345','유저02','테스트2');
INSERT INTO USER_TBL2 VALUES('user03','1235','유저03','테스트3');

INSERT INTO BOARD11 VALUES(1,'제목1','내용1','user01',SYSDATE);
INSERT INTO BOARD11 VALUES(2,'제목2','내용2','user02',SYSDATE);
INSERT INTO BOARD11 VALUES(3,'제목3','내용3','user01',SYSDATE);
INSERT INTO BOARD11 VALUES(4,'제목4','내용4','user02',SYSDATE);
INSERT INTO BOARD11 VALUES(5,'제목5','내용5','user01',SYSDATE);





CREATE TABLE SHOP_MEMBER(
    MEMBER_ID VARCHAR2(20) PRIMARY KEY,
    MEMBER_PW VARCHAR(30) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL
);

CREATE TABLE PRODUCT(
    PRODUCT_NO NUMBER PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(100) NOT NULL,
    PRODUCT_DETAIL VARCHAR2(200) NOT NULL,
    PRODUCT_PRICE NUMBER
);

CREATE TABLE SHOP_BUY(
    BUY_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) REFERENCES SHOP_MEMBER(MEMBER_ID),
    PRODUCT_NO NUMBER REFERENCES PRODUCT(PRODUCT_NO),
    AMOUNT NUMBER,
    BUY_DATE DATE
);




















CREATE TABLE EXPERT_TBL(
    MEMBER_CODE number primary key, -- 회원전용코드 
    MEMBER_ID varchar2(20) UNIQUE, -- 회원 아이디
    MEMBER_PWD varchar2(20) NOT NULL, -- 회원 비밀번호
    MEMBER_NAME varchar2(10)NOT NULL, -- 회원 이름
    MEMBER_ADDR varchar2(50) NOT NULL,-- 회원 거주지
    GENDER char(3) check(GENDER IN ('남','여')), 
    PHONE char(13)
);

CREATE TABLE  Company_TBL(
    MEMBER_CODE number references EXPERT_TBL on delete cascade,
    SKILL varchar2(50)	
);

INSERT INTO EXPERT_TBL VALUES(1,'ID1','PW1','NAME1','ADDR1','여','01012341234');
INSERT INTO EXPERT_TBL VALUES(2,'ID2','PW2','NAME2','ADDR2','여','01012341234');

INSERT INTO Company_TBL VALUES(1,'SKILL1');
INSERT INTO Company_TBL VALUES(2,'SKILL1');

DELETE FROM EXPERT_TBL WHERE MEMBER_CODE = 1;

SELECT * FROM Company_TBL;

select constraint_name, constraint_type from user_constraints;








