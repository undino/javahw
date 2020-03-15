create table users(
    id int auto_increment primary key ,
    login varchar(50) not null ,
    password varchar(50) not null ,
    email varchar(50) not null ,
    phone_number int not null ,
    gender varchar(10)
);
insert into users (login, password, email, phone_number, gender)
values
('Bob', 'qwerty', 'test@gmail.com', '063360063', 'male');
insert into users (login, password, email, phone_number, gender)
values
('Jorj', '1111', 'joj@gmail.com', '0501212121', 'male');