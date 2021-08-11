create table MEMBER(
    MEMBER_ID VARCHAR2(20) PRIMARY KEY,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(15) NOT NULL,
    MEMBER_NICK VARCHAR2(30) UNIQUE NOT NULL,
    PHONE CHAR(13),
    MEMBER_BIRTH CHAR(10),
    ENROLL_DATE CHAR(10)
);
    

insert into MEMBER values('id1','pw1','name1',
'nick1','010-1111-1111','2000-09-03',to_char(sysdate, 'yyyy-mm-dd'));
insert into MEMBER values('id2','pw2','name2',
'nick2','010-2222-2222','1999-09-07',to_char(sysdate, 'yyyy-mm-dd'));


create table BOARD(
    BOARD_NO NUMBER PRIMARY KEY,
    BOARD_TITLE VARCHAR(300) NOT NULL,
    BOARD_CONTENT VARCHAR(1000) NOT NULL,
    READ_COUNT NUMBER DEFAULT 0,
    BOARD_WRITER VARCHAR(20) REFERENCES MEMBER(MEMBER_ID),
    REG_DATE DATE DEFAULT SYSDATE,
    COMMENT_COUNT NUMBER DEFAULT 0
);

create table BOARD_FILE(
    BORAD_NO NUMBER REFERENCES BOARD(BOARD_NO),
    FILENAME VARCHAR(300)
);

insert into BOARD values(1,'title1','content1',default,'id1',default,default);

insert into BOARD_FILE values(1,'첨부파일1');
insert into BOARD_FILE values(1,'첨부파일2');

commit;




create table BOARD_COMMENT(
    BC_NO NUMBER PRIMARY KEY,
    BC_CONTENT VARCHAR2(300) NOT NULL,
    BC_WRITER VARCHAR2(20) REFERENCES MEMBER,
    BOARD_NO NUMBER REFERENCES BOARD,
    BC_REG_DATE DATE DEFAULT SYSDATE
);

-- 이렇게 한 세트 당 1 커밋
insert into BOARD_COMMENT values(1,'1등~','id1',1,default);
update BOARD set COMMENT_COUNT = COMMENT_COUNT +1 where BOARD_NO =1;
commit;

insert into BOARD_COMMENT values(2,'아 1등 아님ㅜ','id2',1,default);
update BOARD set COMMENT_COUNT = COMMENT_COUNT +1 where BOARD_NO =1;
commit;




--- comment 갯수 카운트 하기
alter table BOARD drop column COMMENT_COUNT;
select  B.BOARD_NO, B.BOARD_TITLE, B.READ_COUNT, B.BOARD_WRITER,
(select count(*) from BOARD_COMMENT BC where BC.BOARD_NO=B.BOARD_NO ) as "COMMENT_COUNT"
from BOARD B;


select bc.BC_NO, bc.BC_CONTENT, m.MEMBER_NAME
from BOARD_COMMENT bc
JOIN MEMBER m
ON (m.MEMBER_ID = bc.BC_WRITER);

select * from MEMBER;
select * from BOARD;
select * from BOARD_FILE;
select * from BOARD_COMMENT;