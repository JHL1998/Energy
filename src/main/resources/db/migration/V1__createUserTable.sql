create table user
(
	id bigint auto_increment,
	username varchar(20) null,
	password varchar(20) null,
	name varchar(5) null,
	tel char(11) null,
	email varchar(30) null,
	gmt_create long null,
	gmt_modified long null,
	constraint user_pk
		primary key (id)
);
