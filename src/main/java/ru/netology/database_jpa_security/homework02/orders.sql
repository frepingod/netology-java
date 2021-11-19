create table ORDERS
(
    id           int primary key auto_increment,
    date         timestamp not null default now(),
    customer_id  int       not null,
    product_name text      not null,
    amount       int       not null,
    foreign key (customer_id) references CUSTOMERS (id) on delete cascade
);