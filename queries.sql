-- Part 1: Test it with SQL
-- 1) Create Table users--
CREATE TABLE user(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30),
pwHash VARCHAR(30),
email int not null
);