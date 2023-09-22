--권한 부여
GRANT CREATE VIEW TO SCOTT;

alter session set "_ORACLE_SCRIPT"=true; 



CREATE USER mark IDENTIFIED BY 1234;
-- 접속 권한 부여
--GRANT CREATE SESSION, CREATE TABLE, unlimited tablespace TO mark;
GRANT CONNECT, resource, dba TO mark;
GRANT SELECT , INSERT , UPDATE, DELETE ON sys.test TO C##jisun;
