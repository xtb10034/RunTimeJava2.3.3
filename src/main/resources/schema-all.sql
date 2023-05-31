DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

Insert into people(person_id,first_name,last_name) values(1,'a1','a1');

Insert into people(person_id,first_name,last_name) values(2,'b1','b2');

Insert into people(person_id,first_name,last_name) values(3,'c1','c2');
