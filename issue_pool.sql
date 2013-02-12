DROP TABLE IF EXISTS issue_pool;
create table issue_pool(
	id int(3) not null auto_increment,
	passage varchar(2000) not null,
	question varchar(500) ,
	pool_date date not null,
	taken int(1) default 0,
	primary key (id)
	)engine=InnoDB default charset=utf8;
	select * from issue_pool;
	
	
	DROP TABLE IF EXISTS issue_catagory;
	create table issue_catagory(
	id int(3) not null auto_increment,
	kind varchar(50),
	primary key (id),
	unique key (kind)
	)engine=InnoDB default charset=utf8;
	insert into issue_catagory(kind) values("education");
	insert into issue_catagory(kind) values("history");
	insert into issue_catagory(kind) values("science");
	insert into issue_catagory(kind) values("politics");
	insert into issue_catagory(kind) values("society");
	insert into issue_catagory(kind) values("media");
	insert into issue_catagory(kind) values("culture");
	insert into issue_catagory(kind) values("conduct");
select * from issue_catagory;