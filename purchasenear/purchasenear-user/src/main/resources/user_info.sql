create table user_info(
	id bigint  unsigned NOT NULL AUTO_INCREMENT,
	phone varchar(11) unique,
	real_name varchar(16)   NOT NULL DEFAULT '',
	password	varchar(24)	 NOT NULL DEFAULT '',
	credit	bigint  NOT NULL default	1000	,
	regist_time	datetime,
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB COLLATE='utf8_general_ci';