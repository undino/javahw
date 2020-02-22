drop database if exists academy;
create database if not exists academy default character set utf8;
use academy;
create table students
(
    id         int primary key auto_increment,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int          not null,
    group_id   int          not null,
    constraint fk_student_group foreign key (group_id) references groups (id)
);

create table groups
(
    id   int auto_increment primary key,
    name varchar(50) not null
);