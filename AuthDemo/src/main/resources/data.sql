DELETE FROM user_account_roles;
DELETE FROM role;
DELETE FROM user_account;
INSERT INTO role ("id", "name") VALUES ( 1, 'ROLE_USER' );
INSERT INTO role ("id", "name") VALUES ( 2, 'ROLE_ADMIN' );
INSERT INTO role ("id", "name") VALUES ( 3, 'ROLE_MANAGER' );