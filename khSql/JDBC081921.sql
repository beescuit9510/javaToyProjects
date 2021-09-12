select * from user_tbl;

insert into user_tbl values(1,1);

truncate table user_tbl;
commit;
insert into user_tbl values(220,'22id','pw','n',2,'010-2222-2222');

select count(*) cnt from user_constraints uc where table_name='user_tbl';


create sequence squ;
squ.nextval;


create table board_tbl(
    board_no number primary key,
    board_title varchar2(100),
    board_content varchar2(300),
    board_writer number references user_tbl(user_no) on delete set null,
    board_count number,
    enroll_date date default sysdate
);

create sequence board_squ;
drop sequence borad_squ;
insert into board_tbl values(borad_squ.nextval,'제목01','내용1',5,0,default);
insert into board_tbl values(borad_squ.nextval,'제목02','내용5',5,0,default);
insert into board_tbl values(borad_squ.nextval,'제목03','내용5',5,0,default);
insert into board_tbl values(borad_squ.nextval,'제목04','내용5',5,0,default);
insert into board_tbl values(borad_squ.nextval,'제목05','내용5',5,0,default);

truncate table board_tbl;
drop table board_tbl;
select * from board_tbl order by board_no ;
select * from user_tbl;

rollback;
commit;


select board_no, board_title, board_writer, board_count, enroll_date, board_content
from board_tbl where 1 = 1
order by board_no ;
