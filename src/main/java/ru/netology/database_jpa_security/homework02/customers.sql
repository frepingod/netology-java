create table CUSTOMERS
(
    id           int primary key auto_increment,
    name         text not null,
    surname      text not null,
    age          int  not null,
    phone_number varchar(16) default 'номер не указан'
);