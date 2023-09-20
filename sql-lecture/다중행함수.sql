SELECT * FROM emp;

SELECT MIN(sal), max(sal)  
FROM emp;

SELECT MIN(HIREDATE), max(HIREDATE)  
FROM emp;


SELECT * FROM emp;
SELECT  DEPTNO 부서번호, avg(SAL) 부서별평균월급
FROM emp
GROUP BY DEPTNO;


SELECT * FROM emp;
SELECT  JOB 직업, sum(SAL) 직업별월급합계
FROM emp
GROUP BY JOB
ORDER BY sum(SAL);

SELECT * FROM emp;
SELECT  DEPTNO 직업, avg(SAL) 부서별월급평균
FROM emp
GROUP BY DEPTNO
ORDER BY avg(SAL);


SELECT * FROM emp;
SELECT  DEPTNO 부서, sum(sal),sum(SAL+nvl(comm,0)) 부서별월급평균
FROM emp
GROUP BY DEPTNO
ORDER BY avg(SAL+comm);


--부서별 월급의 평균이 2000
SELECT * FROM emp;
SELECT  DEPTNO 부서, avg(SAL) 부서별월급평균
FROM emp
GROUP BY DEPTNO
HAVING avg(SAL)>=2000
ORDER BY avg(SAL);


SELECT * FROM emp;

SELECT  DEPTNO , JOB , avg(SAL) FROM emp
WHERE sal<3000
GROUP BY DEPTNO, job
HAVING avg(SAL)>=2000
ORDER BY DEPTNO;


SELECT * FROM emp;
SELECT deptno, job, count(*), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY DEPTNO, job
ORDER BY DEPTNO, job;

SELECT * FROM emp;
SELECT job, 
		LISTAGG(ENAME, ', ') WITHIN GROUP (ORDER BY ENAME) AS names
FROM emp
GROUP BY job;



SELECT DEPTNO, 
	   job, 
	   AVG(sal) AS 평균월급
FROM emp
GROUP BY GROUPING SETS ((DEPTNO, job))
ORDER BY DEPTNO;

SELECT * FROM emp;
SELECT EMPNO, 
	   JOB, 
	   SUM(sal) AS total_salary
FROM emp
GROUP BY ROLLUP(EMPNO), JOB;



SELECT * FROM emp;
SELECT EMPNO, 
			 job, 
			 SUM(sal) AS total_salary
FROM emp
GROUP BY CUBE (EMPNO, job);




SELECT * FROM 테이블명;
SELECT 
FROM 테이블명
WHERE 
GROUP BY 
HAVING 
ORDER BY ;


--1.
SELECT * FROM emp;
SELECT DEPTNO,max(sal), MIN(sal), count(*) 
FROM emp
GROUP BY DEPTNO
ORDER BY DEPTNO;



--2.
SELECT * FROM emp;
SELECT job, count(*)
FROM emp
GROUP BY job
HAVING count(*)>=3
ORDER BY count(*);


--3.
SELECT * FROM emp;
SELECT DEPTNO 부서, EXTRACT (YEAR FROM HIREDATE) 년도, count(*) 년도별입사인원
FROM emp
GROUP BY DEPTNO, EXTRACT (YEAR FROM HIREDATE)
ORDER BY DEPTNO;


--4.
SELECT * FROM emp;
SELECT nvl2(comm, 'O','X') AS "보너스 여부",
		COUNT(*) AS 인원수 	
FROM emp
GROUP BY nvl2(comm, 'O','X');



--5.
SELECT * FROM emp;
SELECT DEPTNO AS 부서,  
		EXTRACT (YEAR FROM HIREDATE) AS 입사년, 
		count(*) AS 년도별입사인원,
		max(sal) AS 최고월급, 
		sum(sal) AS 월급합 ,
		avg(sal) AS 월급평균

FROM emp
GROUP BY ROLLUP (DEPTNO, EXTRACT (YEAR FROM HIREDATE))
ORDER BY DEPTNO;





--1
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여,
		sal+300 AS 인상된급여
FROM emp;

--2.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
	sal AS 급여,
	sal*12 +100 AS 연간_총_수입
FROM emp
ORDER BY sal desc;

--3.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여
FROM emp
WHERE sal>2000
ORDER BY sal desc;

--4.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		DEPTNO AS 부서번호
FROM emp
WHERE EMPNO=7788;




































