CREATE TABLE member(
 NO				number(5), --시퀀스 > sys
 id 			varchar2(30) PRIMARY key,
 password 		varchar2(50) NOT null,
 name 			varchar2(50) NOT null,
 postcode		number(8),
 address		varchar2(100),
 addressdetail 	varchar2(50),
 regdate		date
);