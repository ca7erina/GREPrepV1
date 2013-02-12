DROP TABLE IF EXISTS argument_pool;
create table argument_pool(
	id int(3) not null auto_increment,
	passage varchar(2000) not null,
	question varchar(500) ,
	pool_date date not null,
	taken int(1) default 0,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from argument_pool;
	
	
	DROP TABLE IF EXISTS argument_catagory;
	create table argument_catagory(
	id int(3) not null auto_increment,
	kind varchar(50),
	primary key (id),
	unique key (kind)
	)engine=InnoDB default charset=utf8;
	insert into argument_catagory(kind) values("education");
	insert into argument_catagory(kind) values("history");
	insert into argument_catagory(kind) values("science");
	insert into argument_catagory(kind) values("politics");
	insert into argument_catagory(kind) values("society");
	insert into argument_catagory(kind) values("media");
	insert into argument_catagory(kind) values("culture");
	insert into argument_catagory(kind) values("conduct");
select * from argument_catagory;