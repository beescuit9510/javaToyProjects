create table member(
    member_id varchar(20) primary key,
    member_pw varchar(20) not null,
    member_name varchar(20) not null,
    member_addr varchar(300),
    member_phone char(13),
    member_age number,
    enroll_date date
);


insert into member values('byunduck1234','1234','변덕','서울시 강서구','010-5555-5555',9, sysdate);
insert into member values('cat1234','2222','고양','서울시 강서구','010-2222-2222',9, sysdate);
insert into member values('dog1234','3333','개','서울시 강남구','010-3333-3333',2, sysdate);
insert into member values('bunny1234','4567','토깽이','서울시 강서구','010-4444-5555',21, sysdate);
insert into member values('duck1234','5678','오리','서울시 강서구','010-5555-5555',42, sysdate);

insert into member values('elephant','0000','코끼리','서울시 구로구','010-1234-5555',22, sysdate);

select * from member;
commit;