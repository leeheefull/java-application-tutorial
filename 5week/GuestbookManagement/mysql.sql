DROP DATABASE IF EXISTS tutoring;
CREATE DATABASE tutoring;
USE tutoring;

create table guestbook(
	id int NOT NULL primary key auto_increment,
    person_Name varchar(20) NOT NULL,
    content varchar(100) NOT NULL,
    regdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into guestbook (person_name, content)
values("홍길동", "안녕하세요. 처음 방문해 봅니다.");
insert into guestbook (person_name, content)
values("안중근", "대한 독립 만세");

select * from guestbook;