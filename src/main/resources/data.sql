
DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id           BIGINT      NOT NULL,
    user_name     VARCHAR(50) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    primary key (id)
);
INSERT INTO account
VALUES (1, 'pelle', 'skrutte');
INSERT INTO account
VALUES (2, 'lelle', 'skrutte');
INSERT INTO account
VALUES (3, 'melle', 's');