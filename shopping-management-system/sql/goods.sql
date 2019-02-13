create table goods
(
gid int(10) primary key auto_increment,
gname varchar(32) not null unique,
gprice double(16,2) not null,
gnum int(10) not null
);