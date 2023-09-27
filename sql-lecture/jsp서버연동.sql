-- 테스트 테이블 필드 생성 01
-- id, password
CREATE TABLE test(
 NO			number(4), --시퀀스 > sys
 id 		varchar(30),
 password 	varchar(50),
 age 		varchar(3),
 birthyear	number(4),
 regdate	date
);

-- 테스트 테이블 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE NO_seq
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;

-- 테이블 값 삽입
INSERT INTO test VALUES (NO_seq.nextval, 'jisun', '1234','28','2023-09-11');


-- 업데이트 확인
DELETE FROM test WHERE NO=1; -- 테이블 값 삭제
SELECT * FROM test; -- 테이블 확인
DROP TABLE test; -- 테이블 삭제
COMMIT; -- 커밋안하면 업데이트 서버에서 조회불가능






-- 회원 테이블 필드 생성02

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






-- 회원 테이블 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE seq_member
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;

-- 회원 테이블 값 삽입
INSERT INTO MEMBER VALUES (seq_member.nextval, 'love','486','윤하',1111,'태양계 화성시','1004-0109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'js','1234','지선',486,'우리집 중간방','960109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'js06','1234','지선',486,'우리집 중간방','960109',sysdate);
INSERT INTO MEMBER VALUES (seq_member.nextval, 'nctzen','0825','시즈니',486,'우리집 중간방','0802',sysdate);



-- 회원 업데이트 확인
DELETE FROM member WHERE NO=1; -- 테이블 값 삭제
SELECT * FROM member; -- 테이블 확인
DROP TABLE member; -- 테이블 삭제
COMMIT; -- 커밋안하면 업데이트 서버에서 조회불가능



select count(*) AS count from member where id = '2JISUN';



-- 게시판 테이블 필드 생성03

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

-- 게시판 테이블 필드 > NO > 시퀀스 만들기
CREATE SEQUENCE seq_board
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	99999
	   NOCYCLE	
	   nocache ;

	  
	  
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

-- 게시판 글 목록 정렬
SELECT * 
FROM (SELECT rownum AS num,  -- 가상컬럼인 rownum을 추가해서 정렬시킨다.
			 b01.*
		FROM (SELECT *
			  FROM BOARD 
			  ORDER BY NO DESC) b01)
WHERE num>=1 AND num<=10;
	  
	  
	  


-- 게시판 테이블 업데이트 확인
DELETE FROM board WHERE NO BETWEEN 101 AND 400; -- 테이블 값 삭제
--update board set hit = hit +1 where no = ? -- 테이블 업데이트
SELECT * FROM board; -- 테이블 확인
DROP TABLE board; -- 테이블 삭제

-- 게시판 테이블 커밋
COMMIT; -- 커밋안하면 업데이트 서버에서 조회불가능

-- 쿼리 테스트
SELECT * 
FROM board
WHERE CONTENT LIKE '%0%'; 
















