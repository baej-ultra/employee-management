create table employee
(
    id         int auto_increment
        primary key,
    first_name varchar(45) null,
    last_name  varchar(45) null,
    email      varchar(45) null
)
    charset = latin1;

create table users
(
    username varchar(50) not null
        primary key,
    password varchar(50) not null,
    enabled  tinyint     not null
)
    charset = latin1;

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint authorities_idx_1
        unique (username, authority),
    constraint authorities_ibfk_1
        foreign key (username) references users (username)
)
    charset = latin1;


