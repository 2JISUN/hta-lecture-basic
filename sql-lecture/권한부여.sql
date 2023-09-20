-- 계정 생성
CREATE USER C##jisun identified BY 1234;
-- 계정 삭제
DROP USER C##jisun;

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER jisun identified BY 1234; --계정 생성
GRANT CREATE SESSION, CREATE TABLE, unlimited tablespace TO jisun; --접속권한 부여

GRANT SELECT ON scott.emp TO jisun;
GRANT insert ON scott.emp TO jisun;
GRANT delete ON scott.emp TO jisun;
GRANT update ON scott.emp TO jisun;

REVOKE SELECT ,INSERT ,UPDATE, DELETE ON scott.emp FROM jisun;


DROP ROLE myRole;
CREATE ROLE C##myRole;
GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SYNONYM 
TO C##myRole; --접속권한 부여

DROP USER C##jisun02; --계정삭제
CREATE USER C##jisun02 identified BY 1234; --계정 생성
GRANT C##myRole TO jisun;



-- 계정 생성
CREATE USER C##abcd identified BY 1234;  -- 계정생성
-- 접속 권한 부여
GRANT CREATE SESSION, CREATE TABLE, unlimited tablespace TO C##abcd; --접속권한 부여

-- 쿼리 권한 부여
GRANT SELECT ON scott.emp TO C##abcd;
GRANT SELECT ON scott.dept TO C##abcd;
GRANT SELECT ON scott.SALGRADE  TO C##abcd;

-- 권환 회수
REVOKE SELECT ON scott.emp FROM C##abcd;
REVOKE SELECT ON scott.dept FROM C##abcd;
REVOKE SELECT ON scott.SALGRADE FROM C##abcd;








