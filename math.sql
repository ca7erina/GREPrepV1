DROP TABLE IF EXISTS math;
create table math(
	id int(3) not null auto_increment,
	frequence int(2) not null,
	picture varchar(100) not null,
	question varchar(500) not null,
	answer varchar(200) not null,
	answer_info varchar(500) not null,
	catagory varchar(50) not null,
	history_date date not null,
	taken int(1) default 0,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from math;