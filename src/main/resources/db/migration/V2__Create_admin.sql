insert into usr
    (id, activation_code, active, filename, mail, password, username)
VALUES (1,
        null,
        true,
        null,
        'johndeathsmell@gmail.com',
        123,
        'admin');
insert into user_role (user_id, roles)
VALUES (
        1,
        'ADMIN'
       );
insert into user_role (user_id, roles)
VALUES (
           1,
           'MASTER'
       );
insert into user_role (user_id, roles)
VALUES (
           1,
           'USER'
       );
insert into user_role (user_id, roles)
VALUES (
           1,
           'GUEST'
       );