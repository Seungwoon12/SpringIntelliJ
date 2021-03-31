create table member (
    member_no int auto_increment primary key,
    email varchar(100) not null,
    password varchar(100) not null,
    postcode varchar(100) not null,
    address varchar(100) not null,
    detail varchar(100) not null
);