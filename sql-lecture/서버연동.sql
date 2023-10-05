SELECT * 
FROM MEMBER;

DROP TABLE MEMBER;

CREATE TABLE member(
 NO				number(5), --시퀀스 > sys
 id 			varchar2(30) PRIMARY key,
 password 		varchar2(100) NOT null,
 name 			varchar2(50) NOT null,
 email 			varchar2(200) NOT null,
 tel 			varchar2(200) NOT null,
 postcode		number(8),
 address		varchar2(100),
 addressdetail 	varchar2(50),
 regdate		DATE,
 profile		varchar2(300) 
);



DROP SEQUENCE seq_member;

CREATE SEQUENCE seq_member
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;