CREATE TABLE temp (
	NO NUMBER(4),
	name varchar2(100)
);

SELECT * FROM temp;
INSERT INTO temp VALUES (1,'이지선');

SELECT * FROM scott.emp;
INSERT INTO scott.emp(empno,ename) VALUES (9000,'이지선');



SELECT * FROM scott.emp;