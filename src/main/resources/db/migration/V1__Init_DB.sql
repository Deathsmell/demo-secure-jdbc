create sequence hibernate_sequence start 1 increment 1;
create table client
(
    id       int8 not null,
    address  varchar(255),
    filename varchar(255),
    mail     varchar(255),
    name     varchar(255),
    primary key (id)
);
create table master
(
    id   int8 not null,
    name varchar(255),
    primary key (id)
);
create table master_clients
(
    master_id  int8 not null,
    clients_id int8 not null
);
create table user_role
(
    user_id int8 not null,
    roles   varchar(255)
);
create table usr
(
    id              int8         not null,
    activation_code varchar(255),
    active          boolean,
    filename        varchar(255),
    mail            varchar(255),
    password        varchar(255) not null,
    username        varchar(255) not null,
    master_id       int8,
    primary key (id)
);

alter table if exists master_clients
    add constraint master_clients_client_id_fk unique (clients_id);

alter table if exists usr
    add constraint usr_username_fk unique (username);

alter table if exists master_clients
    add constraint master_clients_client_fk foreign key (clients_id) references client;

alter table if exists master_clients
    add constraint master_clients_master_fk foreign key (master_id) references master;

alter table if exists user_role
    add constraint user_role_usr_fk foreign key (user_id) references usr;

alter table if exists usr
    add constraint usr_master_fk foreign key (master_id) references master;