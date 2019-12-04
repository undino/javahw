create databases if not exists academy

create table if not exists groups (
    id integer primary key auto_increment not null,
    name varchar(10) not null unique CHECK(name !=''),
    rating integer not null CHECK(rating >= 0 AND rating <= 5),
    year integer not null CHECK(year >= 1 AND year <= 5)
);
	
create table if not exists departaments (
    id int auto_increment not null primary key unique,
    financing decimal(5,2) not null default 0.00 CHECK(financing >= 0),
    name varchar(100) not null unique CHECK(name != '')
);

create table if not exists faculties (
    id int auto_increment not null primary key,
    name varchar(100) not null unique CHECK(name !='')
);
 
 create table if not exists teacher (
    id int auto_increment not null primary key,
    employmentdate date not null CHECK(employmentdate > '01.01.1990'),
    name varchar(65535) not null CHECK(name !=''),
    premium decimal(5,2) not null default 0 CHECK(premium >=0),
    salary decimal(5,2) not null CHECK(salary > 0),
    surname varchar(65535) not null CHECK(surname != '')
);