insert into roles (role) values ('ADMIN'), ('USER');
--username : admin; password: admin
insert into users(username, password) values ('admin', '$2a$12$AA0wnkqIpbW/CCNHEfrOCOShoYkHrqyERUzuMjNWTme.guwIVkSoC');
insert into user_roles(user_id, role_id) values (1, 1);
