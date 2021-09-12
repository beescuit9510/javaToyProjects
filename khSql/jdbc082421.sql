CREATE TABLE book
(
    book_no    NUMBER           NOT NULL, 
    genre      VARCHAR2(20)     NOT NULL, 
    title      VARCHAR2(20)     unique not null, 
    intro      VARCHAR2(200)    NOT NULL, 
    author     VARCHAR2(20)     NOT NULL, 
    stock      number           NOT NULL, 
     PRIMARY KEY (book_no)
)
/
select * from book;
drop table book;

CREATE SEQUENCE book_SEQ
START WITH 1
INCREMENT BY 1;
/
-- meber Table Create SQL
CREATE TABLE member
(
    Member_no    NUMBER          NOT NULL, 
    id           VARCHAR2(20)    NOT NULL, 
    pw           VARCHAR2(20)    NOT NULL, 
    name         VARCHAR2(20)    NOT NULL, 
    phone        CHAR(13)        NOT NULL, 
    grade        NUMBER          NOT NULL, 
     PRIMARY KEY (Member_no)
)
/

select * from member;
commit;
CREATE SEQUENCE member_SEQ
START WITH 1
INCREMENT BY 1;
/

-- rent Table Create SQL
CREATE TABLE rent
(
    rent_no        NUMBER    NOT NULL, 
    member_no      NUMBER    REFERENCES member(member_no) on delete set null, 
    book_no        NUMBER    REFERENCES book(book_no) on delete set null,
    book_title     varchar2(20) REFERENCES book(title) on delete set null,
    start_date     DATE      NOT NULL, 
    end_date       DATE      , 
    rent_status    NUMBER    NOT NULL, 
     PRIMARY KEY (rent_no)
)
/
insert into rent values(rent_seq.nextval,?,?,?,sysdate,null,1);

insert into rent values(rent_seq.nextval,1,3,'공포이야기', sysdate, null, 1);
select * from rent;
delete table rent;
truncate table rent;

CREATE SEQUENCE rent_SEQ
START WITH 1
INCREMENT BY 1;
commit;

select * from book;
update member set id = 'CAT' where id = 'cat';
drop table book;