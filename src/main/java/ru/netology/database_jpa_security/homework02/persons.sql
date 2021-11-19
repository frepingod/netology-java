create table PERSONS
(
    name           varchar(255),
    surname        varchar(255),
    age            int,
    phone_number   varchar(16) default 'номер не указан',
    city_of_living text not null,
    PRIMARY KEY (name, surname, age)
);