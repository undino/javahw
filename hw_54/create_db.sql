drop database if exists store;
create database if not exists Store default character set utf8;
use Store;
create table roles (
  id int primary key auto_increment,
  role varchar(50) not null
);
insert roles (role)
values
  ('Продавец'),
  ('покупатель');
create table Customers (
    id int primary key auto_increment,
    login varchar(50) not null,
    password varchar(50) not null,
    role_id int not null,
    cash decimal(10, 2) not null default 0.00,
    constraint fk_customer_roll foreign key (role_id) references roles (id)
  );
create table Sellers (
    id int primary key auto_increment,
    login varchar(50) not null,
    password varchar(50) not null,
    role_id int not null,
    cash decimal(10, 2) not null default 0.00,
    constraint fk_sellers_roll foreign key (role_id) references roles (id)
  );
create table Products (
    id int primary key auto_increment,
    type varchar(50) not null,
    title varchar(50) not null,
    quantity int not null,
    price decimal(10, 2) not null default 0.00,
    seller_id int not null,
    constraint fk_product_seller foreign key (seller_id) references sellers (id)
  );
create table Orders (
    id int primary key auto_increment,
    customer_id int not null,
    seller_id int not null,
    product_id int not null,
    constraint fk_order_customer foreign key (customer_id) references Customers (id),
    constraint fk_order_seller foreign key (seller_id) references Sellers (id),
    constraint fk_order_product foreign key (product_id) references Products (id)
  );