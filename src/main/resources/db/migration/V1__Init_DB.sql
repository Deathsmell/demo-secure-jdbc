create table client
(
    id       bigint not null,
    address  varchar(255),
    filename varchar(255),
    mail     varchar(255),
    name     varchar(255),
    primary key (id)
) engine = InnoDB;

create table hibernate_sequence
(
    next_val bigint
) engine = InnoDB;

insert into hibernate_sequence
values (1);

insert into hibernate_sequence
values (1);

create table user
(
    id              bigint       not null,
    activation_code varchar(255),
    active          bit,
    filename        varchar(255),
    mail            varchar(255),
    password        varchar(255) not null,
    username        varchar(255) not null,
    primary key (id)
) engine = InnoDB;

create table user_role
(
    user_id bigint not null,
    roles   varchar(255)
) engine = InnoDB;

alter table user
    add constraint client_user_fk unique (username);

alter table user_role
    add constraint user_role_user_fk
        foreign key (user_id) references user (id);
