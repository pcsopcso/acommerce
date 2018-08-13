DROP TABLE IF EXISTS oauth_client_details;
/*
 DROP TABLE IF EXISTS user; 
 */

create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);


INSERT INTO oauth_client_details
(
	client_id, 
	client_secret,
	resource_ids, 
	scope, 
	authorized_grant_types, 
	web_server_redirect_uri, 
	authorities, 
	access_token_validity, 
	refresh_token_validity, 
	additional_information, 
	autoapprove
)
VALUES
(
	'test1',
	'pw',
	null, 
	'read,write', 
	'authorization_code,password, implicit, refresh_token',
	null,
	'ROLE_YOUR_CLIENT',
	36000,
	2592000,
	null,
	null
);


INSERT INTO oauth_client_details
(
	client_id, 
	client_secret,
	resource_ids, 
	scope, 
	authorized_grant_types, 
	web_server_redirect_uri, 
	authorities, 
	access_token_validity, 
	refresh_token_validity, 
	additional_information, 
	autoapprove
)
VALUES
(
	'test2',
	'pw',
	null, 
	'read', 
	'authorization_code,password, implicit, refresh_token',
	null,
	'ROLE_YOUR_CLIENT',
	36000,
	2592000,
	null,
	null
);
/*
CREATE TABLE user (
id    			LONG   NOT NULL AUTO_INCREMENT,
username       	varchar(20)     NOT NULL,
password    	varchar(100)     NOT NULL,
usertype      	varchar(1),
regdate     	datetime NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY user_name (username)
);
*/
/*
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `reg_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
*/
/*
insert into user(username, password, usertype, regdate) values('user1','$2a$10$c2gaIRsG6xDw1NtC12WkuuKAz06kVk3bxaHGhuTAAA7uTvxIK5J/q','2',now())
*/