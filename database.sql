/*create database matrix;*/
use matrix;

#----CREATE TABLES

create table if not exists COUNTRIES(
	ID int AUTO_INCREMENT,
    COUNTRY varchar(50) not null,
    PRIMARY KEY (ID)
);

create table if not exists PERSONS(
	ID int AUTO_INCREMENT,
    FIRST_NAME varchar(50) not null,
    LAST_NAME varchar(50) not null,
    AGE INT not null,
    FK_COUNTRY INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (FK_COUNTRY) REFERENCES COUNTRIES(ID)
);

#----INSERTS

INSERT INTO COUNTRIES (COUNTRY) value('Argentina'), ('Chile'),('Uruguay'),('Estados Unidos'), ('España'),('Canada');
INSERT INTO PERSONS (FIRST_NAME, LAST_NAME, AGE, FK_COUNTRY) 
	value('Homero','Simpson',45,4),('Rick','Sanchez',50,4),('Ted','Mosby',30,4),('Robin','Scherbatsky',29,6),('Dipper','Pines',12,5),('Mabel','Pines',12,5);
INSERT INTO PERSONS (FIRST_NAME, LAST_NAME, AGE) 
	value('Gon','Freecss',14),('Killua','Zoldyc',14),('Spike','Spiegel',39);

select * from Persons;

#----JOINS

SELECT * FROM PERSONS P
	LEFT JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY;

SELECT * FROM PERSONS P
	RIGHT JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY;

SELECT * FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY;

#----FILTER AND SORT

SELECT sum(p.age), c.country FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY
    where p.age >= 18
    group by c.country
	order by c.country asc;

#----GROUP AND COUNT

SELECT count(p.id),c.country  FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY
    group by c.country;

#----UNION

SELECT p.* FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY
    where p.age <= 18
union
SELECT p.* FROM PERSONS P
	where p.fk_country is null;

#----SUBQUERIES AND AVERAGE

SELECT c.id, c.country, (select if(p.fk_country is null,0,avg(p.age)) from PERSONS P where p.fk_country = c.id) as persons FROM COUNTRIES C;

#----LIMIT
SELECT id FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY;

#----INTERSECT (SQL)

SELECT p.id FROM PERSONS P
	INNER JOIN COUNTRIES C ON C.ID = P.FK_COUNTRY
    where p.age <= 18
intersect
SELECT p.id FROM PERSONS P
	where p.fk_country is null;

#devolveria lo siguiente:

SELECT DISTINCT p.id
FROM PERSONS P
WHERE p.id IN (SELECT p2.id FROM PERSONS P2);

CREATE TABLE BYTES (
	bytes binary(16),
	varbytes varbinary(100)
);

insert into BYTES (bytes, varbytes) values ('9fad5e9eefdfb449','9fad5e9eefdfb449');

select * from bytes;
