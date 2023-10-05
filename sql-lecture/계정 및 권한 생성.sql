--[계정] 생성
CREATE USER jisun IDENTIFIED BY 1234;

--[권한] 부여
alter session set "_ORACLE_SCRIPT"=true;  --C## 안 붙이고 이름붙이기 
--[권한] 부여 > 전체 : 접근, 생성, 삭제 등등..
GRANT CONNECT, resource, dba TO jisun; -- 전체
-- GRANT SELECT , INSERT , UPDATE, DELETE ON sys.test TO jisun;