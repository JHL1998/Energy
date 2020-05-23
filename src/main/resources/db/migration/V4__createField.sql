create table field
(
	id bigint auto_increment,
	name varchar(40) null,
	capacity int null,
	`load` int null,
	electric bigint null,
	time datetime null,
	constraint field_pk
		primary key (id)
);
