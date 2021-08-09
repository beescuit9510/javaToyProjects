-- TABLE NAME : USER_INFO
-- CREATE TABLE TABLENAME(COLUMN NAME DATATYEP(SIZE), COLUMN NAME DATATYEP(SIZE))

CREATE TABLE USER_INFO(
    USER_NAME VARCHAR2(15),
    USER_ID VARCHAR2(20),
    USER_AGE NUMBER,
    USER_PW VARCHAR2(20),
    USER_EMAIL VARCHAR2(50),
    USER_BIRTH DATE,
    USER_ADDR VARCHAR2(300),
    USER_PHONE CHAR(13)
);

--DROP TABLE USER_INFO;

--CREATE TABLE USER_INFO(
--    USER_NAME VARCHAR2(10)
--);

SELECT * FROM USER_INFO;

COMMENT ON COLUMN USER_INFO.USER_NAME IS '회원이름';
COMMENT ON COLUMN USER_INFO.USER_PHONE IS '회원 전화번호';
