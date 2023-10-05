-- jisun / 1234 계정으로 테이블 생성 

-- commit 커밋
COMMIT; -- 커밋안하면 업데이트 서버에서 조회불가능
-- rollback 롤백



-- [테이블] member
-- create table 생성
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

SELECT * FROM member; -- create 확인


-- create SEQUENCE 생성
-- 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE seq_member
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;
	   

-- insert data 삽입 
-- 값 삽입
INSERT INTO MEMBER VALUES (seq_member.nextval, 'love','486','윤하',1111,'태양계 화성시','1004-0109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'js','1234','지선',486,'우리집 중간방','960109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'js06','1234','지선',486,'우리집 중간방','960109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'nctzen','0825','시즈니',486,'우리집 중간방','0802',sysdate);

SELECT * FROM member; -- insert 확인
	  

-- update data 업데이트
-- update MEMBER set 컬럼명 = 컬럼명 +1 where no = ? -- 테이블 업데이트



-- delete table 삭제
DROP TABLE member; -- 테이블 삭제
SELECT * FROM member; -- DELETE 테이블 확인



-- delete data 삭제
-- 테이블 값 삭제
DELETE FROM member WHERE NO=1; -- 테이블 값 삭제	  
SELECT * FROM member; -- DELETE data 확인


-- test쿼리
-- 게시판 글 목록 정렬
select count(*) AS count from member where id = '2JISUN';






-- [테이블] board
-- create table 생성
CREATE TABLE board(
 NO				number(5) 		PRIMARY KEY, --시퀀스 > sys
 id 			varchar2(50) 	,
 password 		varchar2(100) 	NOT null,
 name			varchar2(50) 	,
 title 			varchar2(300)	,
 content 		varchar2(2500)	,
 regdate		DATE			, 	--sysdate
 hit			number(5)
);
SELECT * FROM board; -- create 확인


-- create SEQUENCE 생성
-- 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE seq_board
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;
	   

-- insert data 삽입 
-- 값 삽입
	  
-- 게시판 글 100개 자동 추가
BEGIN
    FOR i IN 1..100 LOOP
        INSERT INTO board VALUES (
            seq_board.nextval,
            'cute',
            '111',
            '귀요미' || i,
            '글제목_' || i,
            '내용삽입했어욤' || i,
            sysdate,
            0
        );
    END LOOP;
END;

SELECT * FROM board; -- insert 확인



-- update data 업데이트
-- update board set 컬럼명 = 컬럼명 +1 where no = ? -- 테이블 업데이트
	  
	  
-- delete table 삭제
DROP TABLE board; -- 테이블 삭제
SELECT * FROM board; -- DELETE 테이블 확인



-- delete data 삭제
-- 테이블 값 삭제
DELETE FROM board WHERE NO=1; -- 테이블 값 삭제	  
SELECT * FROM board; -- DELETE data 확인


-- test 쿼리
-- 게시판 글 목록 정렬
SELECT * 
FROM (SELECT rownum AS num,  -- 가상컬럼인 rownum을 추가해서 정렬시킨다.
			 b01.*
		FROM (SELECT *
			  FROM BOARD 
			  ORDER BY NO DESC) b01)
WHERE num>=1 AND num<=10;