DROP TABLE IF EXISTS reading;
create table reading(
	id int(3) not null auto_increment,
	frequence int(2) ,
	passage varchar(5000) ,
	catagory varchar(50) ,
	history_date date ,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from reading;
	
	
	
	DROP TABLE IF EXISTS reading_verbal;
    create table reading_verbal(
    id int(3) not null auto_increment,
	reading_id int(3) not null ,
	question varchar(500),
	choice varchar(2000) ,
	answer varchar(50),
	answer_info varchar(500) ,
	taken int(1) default 0,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from reading_verbal;
	