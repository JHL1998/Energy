create table user
(
    id           bigint auto_increment
        primary key,
    username     varchar(20)   null,
    password     varchar(20)   null,
    name         varchar(5)    null,
    tel          char(11)      null,
    email        varchar(30)   null,
    gmt_create   mediumtext    null,
    gmt_modified mediumtext    null,
    status       int default 0 null,
    token        varchar(36)   null
);
