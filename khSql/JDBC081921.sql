select * from user_tbl;

insert into user_tbl values(1,1);

truncate table user_tbl;
commit;
insert into user_tbl values(220,'22id','pw','n',2,'010-2222-2222');

select count(*) cnt from user_constraints uc where table_name='user_tbl';


create sequence squ;
squ.nextval;