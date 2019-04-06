INSERT INTO ROLE_T VALUES(null, 'ADMIN');
INSERT INTO ROLE_T VALUES(null, 'EMPLOYEE');
INSERT INTO ROLE_T VALUES(null, 'USER');


--Dodanie usera Admin
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS_ID) VALUES ('admin@wp.pl', 'admin', true, 'admin', 'admin', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', null)
INSERT INTO USER_ROLES_T VALUES(1, 1)

--Dodanie usera Zarzadca
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS_ID) VALUES ('employee@wp.pl', 'Jan', true, 'Nowak', 'employee', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', null)
INSERT INTO USER_ROLES_T VALUES(2, 2)

--Dodanie usera User
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS_ID) VALUES ('user@wp.pl', 'Tomasz', true, 'Kowalski', 'user', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', null)
INSERT INTO USER_ROLES_T VALUES(3, 3)