create table usr (
id bigserial NOT NULL primary key auto_increment,
username varchar(64),
password varchar(64),
role varchar(64)
);
