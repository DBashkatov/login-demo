DELETE
FROM user_account_roles;
DELETE
FROM role;
DELETE
FROM user_info;
DELETE
FROM user_account;
DELETE
FROM enrollment;
DELETE
FROM question_type;
DELETE
FROM question;
DELETE
FROM speciality;
DELETE
FROM source;
DELETE
FROM city;

INSERT INTO enrollment
VALUES (1,  current_timestamp, current_timestamp, current_timestamp, current_timestamp, current_timestamp);

INSERT INTO role ("id", "name")
VALUES (1, 'ROLE_USER');
INSERT INTO role ("id", "name")
VALUES (2, 'ROLE_ADMIN');
INSERT INTO role ("id", "name")
VALUES (3, 'ROLE_MANAGER');


INSERT INTO user_account (id, password, email)
VALUES (1,  'password', 'user@user');

INSERT INTO user_account_roles (user_id, roles_id)
VALUES (1, 1);

INSERT INTO speciality (id, description, name)
VALUES (1, 'description1', 'speciality1');
INSERT INTO speciality (id, description, name)
VALUES (2, 'description2', 'speciality2');
INSERT INTO speciality (id, description, name)
VALUES (3, 'description3', 'speciality3');

INSERT INTO source (id, name)
VALUES (1, 'source1');
INSERT INTO source (id, name)
VALUES (2, 'source2');
INSERT INTO source (id, name)
VALUES (3, 'source3');
INSERT INTO source (id, name)
VALUES (4, 'source4');
INSERT INTO source (id, name)
VALUES (5, 'source5');


INSERT INTO city (id, name)
VALUES (1, 'city1');
INSERT INTO city (id, name)
VALUES (2, 'city2');

INSERT INTO question_type(id, name)
VALUES (1, 'text');
INSERT INTO question_type(id, name)
VALUES (2, 'radio');
INSERT INTO question_type(id, name)
VALUES (3, 'checkbox');