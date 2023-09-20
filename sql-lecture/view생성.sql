CREATE OR REPLACE VIEW v_emp01
AS 
SELECT empno,ename,hiredate FROM emp;
--view를 생성하려면 권한을 받아야 한다.
--sys에서 권한을 줌 > 돌아와서 위의 코드 실행 > 생성
SELECT  * from v_emp01;


-- view 삭제
DROP VIEW v_emp02;
-- view 생성
CREATE VIEW v_emp02 AS
SELECT empno,ename,job,deptno FROM emp
WHERE deptno = 20;
SELECT  * from v_emp02;
SELECT * FROM User_views;



SELECT * FROM EMP;

SELECT rownum, e.* FROM emp e ORDER BY sal DESC ;


SELECT * 
FROM (SELECT rownum AS ranking, e.* FROM 
			 (SELECT * FROM EMP ORDER BY sal DESC) e)
WHERE ranking BETWEEN 3 AND 6;



SELECT rownum, e.* 
SELECT * FROM EMP;
SELECT *
FROM EMP e
WHERE HIREDATE < (SELECT HIREDATE
					FROM EMP
					WHERE ENAME = 'SCOTT' );
				
				
-- 각 부서의 월급 제일 많이 받는 사람의 
SELECT * FROM EMP;
SELECT max(sal) 
FROM EMP 
GROUP BY DEPTNO ;

SELECT * FROM EMP 
WHERE sal IN (SELECT max(sal) FROM EMP GROUP BY DEPTNO);


SELECT * FROM EMP;

--1.
SELECT * 
FROM EMP 
WHERE job = (SELECT JOB 
			FROM EMP
			WHERE ENAME = 'ALLEN');
		
--2.
SELECT avg(sal)
FROM EMP ;
SELECT *
FROM EMP
WHERE sal>(SELECT avg(sal)
FROM EMP );

--3.
SELECT job
FROM EMP 
WHERE DEPTNO = 30;
SELECT *
FROM EMP e 
WHERE DEPTNO = 10 AND job NOT in(SELECT job
									FROM EMP 
									WHERE DEPTNO = 30);

--4.

SELECT *
FROM EMP
WHERE sal >(SELECT max(sal)
FROM EMP 
WHERE JOB = 'SALESMAN');


























































				
				

