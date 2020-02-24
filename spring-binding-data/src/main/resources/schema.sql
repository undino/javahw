-- create schema academy;
-- use academy;
create table groups
(
    id   int auto_increment primary key,
    name varchar(50) not null
);

insert into groups (name)
values ('Java'),
       ('PHP'),
       ('SQL'),
       ('JavaScript');

create table students
(
    id         int primary key auto_increment,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    age        int          not null,
    group_id   int          not null,
    constraint fk_student_group foreign key (group_id) references groups (id)
);

insert into students (first_name, last_name, age, group_id)
VALUES
('Орлов', 'Сергей', 28, 1),
('Энштейн', 'Фльберт', 19, 1),
('Маск', 'Илон', 49, 2),
('Гейтс', 'Билл', 65, 4);
