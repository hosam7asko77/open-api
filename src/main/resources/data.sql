DROP TABLE IF EXISTS laptop_info;

CREATE TABLE laptop_info (
id INT AUTO_INCREMENT  PRIMARY KEY,
name VARCHAR(250) NOT NULL,
company VARCHAR(250) NOT NULL,
price INT NOT NULL,
ram INT NOT NULL
);
-- create table user (
-- id INT AUTO_INCREMENT  PRIMARY KEY,
-- email varchar(128) not null,
-- password varchar(128) not null
-- );
-- create table user_role (
-- user_id int not null,
-- name varchar(64) not null,
-- foreign key (user_id) references user(id),
-- primary key (user_id, name)
-- );
INSERT INTO laptop_info (id,name, company, price,ram) VALUES
(1,'notebook', 'HP', 1400,8 ),
(2,'Alienware', 'Alienware', 2000,16 ),
(3,'Macbook Pro', 'Apple', 4000,32 ),
(4,'Asus', 'Asus', 1400,4 ),
(5,'Macbook Air ', 'Apple', 2000,8 ),
(6,'Dell', 'Dell', 1400,8 ),
(7,'Dv5', 'HP', 1400,8 );
-- insert into user (id, email, password)
-- values (1, 'hosam7asko@ex.com', '$2a$10$FCyrzMfeXmqf0gzPh9mtaO8a5Tl6bUHviotQIVuHY1xBYANGEbAY6'),(2, 'hosam@ex.com', '$2a$10$FCyrzMfeXmqf0gzPh9mtaO8a5Tl6bUHviotQIVuHY1xBYANGEbAY6');
-- insert into user_role (user_id, name)
-- values (1, 'USER'), (1, 'ADMIN'),(2, 'USER');