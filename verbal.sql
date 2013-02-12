DROP TABLE IF EXISTS verbal;
create table verbal(
	id int(3) not null auto_increment,
	question varchar(200),
	choice varchar(200) ,
	answer varchar(50),
	answer_info varchar(500) ,
	history_date date not null,
	frequence int(3) default 0,
	taken int(1) default 0,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from verbal;