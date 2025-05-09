BEGIN TRANSACTION;

DROP TABLE IF EXISTS jobs,users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	phone_number varchar(50),
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE jobs (
	job_id SERIAL PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	customer_name VARCHAR(50) NOT NULL,
	customer_email varchar(50) NOT NULL,
	customer_number VARCHAR(50),
	location VARCHAR(100) NOT NULL,
	job_date TIMESTAMP NOT NULL,
	material_cost NUMERIC(10, 2) NOT NULL,
	price NUMERIC(10, 2) NOT NULL,
	user_id INTEGER NOT NULL,
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);
--    IDEAS
-- phone number and company name for users to register???

COMMIT TRANSACTION;
