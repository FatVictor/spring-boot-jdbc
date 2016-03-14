CREATE TABLE IF NOT EXISTS users(
        user_id         INT(11) UNSIGNED NOT NULL,
	user_name       VARCHAR(200) NOT NULL,
	full_name       VARCHAR(250) NOT NULL,
	email           VARCHAR(100) NOT NULL,
        PRIMARY KEY (`user_id`),
        UNIQUE KEY(user_name)
);
INSERT IGNORE INTO users (user_id, user_name, full_name, email) VALUES(1,'admin','Administrator','admin@webmaster.com');
INSERT IGNORE INTO users (user_id, user_name, full_name, email) VALUES(2,'admin2','Administrator2','admin2@webmaster.com');
INSERT IGNORE INTO users (user_id, user_name, full_name, email) VALUES(3,'admin3','Administrator3','admin3@webmaster.com');