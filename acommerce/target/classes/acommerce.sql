DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
Id            varchar(20)        NOT NULL,
password       varchar(20)        NOT NULL,
name             varchar(20)       NOT NULL,
email             varchar(50),
PRIMARY KEY                    (Id)
);

INSERT INTO USERS VALUES('pcso', 'pw1', '박승현', 'pcso@hanwha.com');
