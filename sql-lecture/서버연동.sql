-- 테이블 필드 생성
-- id, password
CREATE TABLE test(
 NO			number(4), --시퀀스 > sys
 id 		varchar(30),
 password 	varchar(50),
 age 		varchar(3),
 birthyear	number(4),
 regdate	date
);

-- 테이블 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE NO_seq
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	9999
	   NOCYCLE	
	   nocache ;

-- 테이블 값 삽입
INSERT INTO test VALUES (NO_seq.nextval, 'jisun', '1234','28','2023-09-11');


-- 업데이트 확인
DELETE FROM test WHERE NO=1; -- 테이블 값 삭제
SELECT * FROM test; -- 테이블 확인
DROP TABLE test; -- 테이블 삭제
COMMIT; -- 커밋안하면 업데이트 서버에서 조회불가능
