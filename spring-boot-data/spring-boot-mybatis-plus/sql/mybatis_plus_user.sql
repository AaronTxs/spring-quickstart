-- auto Generated on 2019-06-13
-- DROP TABLE IF EXISTS mybatis_annotation_user;
CREATE TABLE mybatis_plus_user (
	id BIGINT ( 15 ) NOT NULL AUTO_INCREMENT COMMENT 'id',
	user_name VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT 'UserName',
	sex INT ( 11 ) NOT NULL DEFAULT - 1 COMMENT 'Sex',
	`password` VARCHAR ( 50 ) NOT NULL DEFAULT '' COMMENT 'Password',
PRIMARY KEY ( id )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT 'mybatis_annotation_user';