drop database testDB;
create database testDB;
insert testDB.user (id, active, password, username) VALUES (1, TRUE, 123, 'admin');
insert testDB.client (id, address, name) VALUES (1, 'Византия', 'Первый пидр');