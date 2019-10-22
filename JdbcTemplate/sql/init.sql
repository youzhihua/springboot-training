CREATE DATABASE test DEFAULT character set = 'utf8';

use test;

create table book(
	`id` int(10) PRIMARY KEY auto_increment,
	`book_name` VARCHAR(100) not null DEFAULT '',
	`book_author` VARCHAR(100) not null DEFAULT ''
)DEFAULT CHARSET= utf8 ;

insert into book(book_name,book_author) values('Java编程规范','James Gosling');
insert into book(book_name,book_author) values('Java核心技术：卷I基础知识','James Gosling');
insert into book(book_name,book_author) values('Java数据结构和算法','James Gosling');
insert into book(book_name,book_author) values('Java与模式','James Gosling');