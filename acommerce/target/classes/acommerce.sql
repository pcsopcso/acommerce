DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS AUTHORITIES;
DROP TABLE IF EXISTS GROUPS;
DROP TABLE IF EXISTS GROUP_AUTHORITIES;
DROP TABLE IF EXISTS GROUP_MEMBERS;

/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE USERS (
username    varchar(20)     NOT NULL,
name        varchar(20)     NOT NULL,
password    varchar(20)     NOT NULL,
email       varchar(20),
enabled     INTEGER		    NULL
);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (username);

COMMENT ON TABLE users is '회원';
COMMENT ON COLUMN users.username is '아이디';
COMMENT ON COLUMN users.name is '성명';
COMMENT ON COLUMN users.password is '비밀번호';
COMMENT ON COLUMN users.email is '이메일';
COMMENT ON COLUMN users.enabled is '계정사용여부';

/**********************************/
/* Table Name: 권한 */
/**********************************/
CREATE TABLE AUTHORITIES(
		username                      		VARCHAR2(20)		 NOT NULL,
		authority                     		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE AUTHORITIES is '권한';
COMMENT ON COLUMN AUTHORITIES.username is '회원아이디';
COMMENT ON COLUMN AUTHORITIES.authority is '권한';


ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_PK PRIMARY KEY (username, authority);
ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_FK0 FOREIGN KEY (username) REFERENCES users (username);

/**********************************/
/* Table Name: 그룹 */
/**********************************/
CREATE TABLE GROUPS(
		id                            		VARCHAR2(20)		 NOT NULL,
		group_name                    		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE GROUPS is '그룹';
COMMENT ON COLUMN GROUPS.id is '그룹 아이디';
COMMENT ON COLUMN GROUPS.group_name is '그룹 명';


ALTER TABLE groups ADD CONSTRAINT IDX_groups_PK PRIMARY KEY (id);

/**********************************/
/* Table Name: 그룹 권한 관계 */
/**********************************/
CREATE TABLE GROUP_AUTHORITIES(
		group_id                      		VARCHAR2(20)		 NOT NULL,
		authority                     		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE GROUP_AUTHORITIES is '그룹 권한 관계';
COMMENT ON COLUMN GROUP_AUTHORITIES.group_id is '그룹 아이디';
COMMENT ON COLUMN GROUP_AUTHORITIES.authority is '권한';


ALTER TABLE GROUP_AUTHORITIES ADD CONSTRAINT IDX_group_authorities_PK PRIMARY KEY (group_id, authority);
ALTER TABLE GROUP_AUTHORITIES ADD CONSTRAINT IDX_group_authorities_FK0 FOREIGN KEY (group_id) REFERENCES groups (id);

/**********************************/
/* Table Name: 그룹 회원 관계 */
/**********************************/
CREATE TABLE GROUP_MEMBERS(
		group_id                      		VARCHAR2(20)		 NOT NULL,
		username                      		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE GROUP_MEMBERS is '그룹 회원 관계';
COMMENT ON COLUMN GROUP_MEMBERS.group_id is '그룹 아이디';
COMMENT ON COLUMN GROUP_MEMBERS.username is '회원 아이디';


ALTER TABLE GROUP_MEMBERS ADD CONSTRAINT IDX_group_members_PK PRIMARY KEY (group_id, username);
ALTER TABLE GROUP_MEMBERS ADD CONSTRAINT IDX_group_members_FK0 FOREIGN KEY (username) REFERENCES users (username);
ALTER TABLE GROUP_MEMBERS ADD CONSTRAINT IDX_group_members_FK1 FOREIGN KEY (group_id) REFERENCES groups (id);


-- 회원 데이터 입력
INSERT INTO USERS (username, name, password, email, enabled) VALUES('pcso', '박승현', 'pw1', 'pcso@hanwha.com', 1);
INSERT INTO USERS (username, name, password, email, enabled) VALUES ('admin', 'admin', '관리자', 'admin@hanwha.com', 1);

-- 회원 권한 입력
INSERT INTO authorities (username, authority) VALUES ('pcso', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

-- 그룹
INSERT INTO groups (id, group_name) VALUES ('G01', '관리자 그룹');
INSERT INTO groups (id, group_name) VALUES ('G02', '사용자 그룹');

-- 그룹 권한
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_ADMIN');
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_USER');
INSERT INTO group_authorities (group_id, authority) VALUES ('G02', 'ROLE_USER');

-- 그룹 회원
INSERT INTO group_members (group_id, username) VALUES ('G01', 'admin');
INSERT INTO group_members (group_id, username) VALUES ('G02', 'pcso');

