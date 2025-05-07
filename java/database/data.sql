BEGIN TRANSACTION;

INSERT INTO users (username, first_name, last_name, email, password_hash,role) VALUES ('user','logan', 'hughes', 'test@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username, first_name, last_name, email, password_hash,role) VALUES ('admin','Juston', 'Johnson', 'test1@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;
