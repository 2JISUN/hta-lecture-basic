--데이터 조작어

CREATE TABLE emp02 AS SELECT * FROM emp; --테이블 복사
SELECT * FROM emp02; --복사 확인
DROP TABLE emp02;--복사 객체 삭제
DROP TABLE emp02 CASCADE CONSTRAINTS;--권한 무시 삭제
CREATE TABLE emp02 AS SELECT * FROM emp WHERE 1 <> 1;

--테이블 삭제
DROP TABLE my_table;
--테이블 생성
CREATE TABLE my_table (
	num number(3),
	name varchar2(100),
	birth DATE
);


SELECT * FROM my_table;

INSERT INTO my_table (num,name,birth) VALUES(1,'이지선',sysdate);
INSERT INTO my_table VALUES(2,'이마크','1999-08-02');
INSERT INTO my_table (num,name) VALUES(3,'황런쥔');
INSERT INTO my_table (num,name) VALUES(4,'이제노');
INSERT INTO my_table VALUES(4,'이해찬',to_date('08-09-2023','DD-MM-YYYY'));
COMMIT;
ROLLBACK;
SELECT * FROM my_table;


DELETE FROM my_table WHERE Num=4;





--퀴즈


--1.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

CREATE TABLE DEPT02 AS SELECT * FROM DEPT; --테이블 복사
SELECT * FROM DEPT02; --복사 확인

INSERT INTO DEPT02 VALUES(50,'oracle','busan');
INSERT INTO DEPT02 VALUES(60,'java','ilsan');
INSERT INTO DEPT02 VALUES(70,'c##','daegu');
INSERT INTO DEPT02 VALUES(80,'css','jeju');

DELETE FROM DEPT02 WHERE DEPTNO BETWEEN 10 AND 40; -- 값 삭제
COMMIT;


--2.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

DROP TABLE emp02;--테이블 삭제
CREATE TABLE emp02 AS SELECT * FROM emp; --테이블 복사
SELECT * FROM emp02; --복사 확인

UPDATE emp02
SET DEPTNO = 50 
WHERE DEPTNO = 30 AND sal>(SELECT AVG(SAL) 
							FROM emp02 
							WHERE DEPTNO = 30); --값 업데이트
							
							
--3.
UPDATE emp02
SET sal = sal*1.1, DEPTNO = 60
WHERE DEPTNO = 10 AND HIREDATE < (select max(HIREDATE)
									from emp02); --값 업데이트

SELECT * FROM emp02; 


--4.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

DELETE FROM emp02 e
		FULL OUTER JOIN SALGRADE s
		ON e.sal BETWEEN  s.LOSAL AND s.HISAL
WHERE s.GRADE=5; -- 값 삭제


-- 단계 1: 삭제할 사원 번호를 선택
SELECT e.*
FROM emp02 e
	JOIN SALGRADE s 
	ON e.sal BETWEEN s.LOSAL AND s.HISAL
WHERE s.GRADE = 5;

-- 단계 2: 선택한 사원 번호를 삭제
DELETE FROM emp02
WHERE (DEPTNO, EMPNO) IN (
						  SELECT e.DEPTNO, 
						  		 e.EMPNO
						  FROM emp02 e
							  JOIN SALGRADE s 
							  ON e.sal BETWEEN s.LOSAL AND s.HISAL
						  WHERE s.GRADE = 5
						);

SELECT * FROM emp;
SELECT * FROM emp02; --king 삭제됨










