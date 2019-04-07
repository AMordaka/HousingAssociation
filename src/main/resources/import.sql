INSERT INTO ROLE_T VALUES(1, 'ADMIN');
INSERT INTO ROLE_T VALUES(2, 'EMPLOYEE');
INSERT INTO ROLE_T VALUES(3, 'USER');


--Dodanie usera Admin
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS) VALUES ('admin@wp.pl', 'admin', true, 'admin', 'admin', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', 'Komorniki 12 97-200 Wolborz')
INSERT INTO USER_ROLES_T VALUES(1, 1)

--Dodanie usera Zarzadca
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS) VALUES ('employee@wp.pl', 'Jan', true, 'Nowak', 'employee', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', 'ul. Kopernika 31 81-211 Lodz')
INSERT INTO USER_ROLES_T VALUES(2, 2)

--Dodanie usera User
insert into user_t(EMAIL, FIRST_NAME, IS_ACTIVE, LAST_NAME, LOGIN, PASSWORD, ADDRESS) VALUES ('user@wp.pl', 'Tomasz', true, 'Kowalski', 'user', '$2a$10$qGv4Z8WBcuQLH02GKN97UuRtn5MPUjwpw16wF.JjCoRZt1sC.HmaS', 'ul. Wiosenna 11 91-122 Lublin')
INSERT INTO USER_ROLES_T VALUES(3, 3)