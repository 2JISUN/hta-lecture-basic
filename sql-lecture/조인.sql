SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;


SELECT *
FROM emp e, SALGRADE s  
WHERE e.sal BETWEEN  s.LOSAL  AND s.HISAL ;


SELECT *
FROM emp e, DEPT d 
WHERE e.job = 'MANAGER' AND e.DEPTNO = d.DEPTNO ;

--데이터 하나 넣기...
INSERT INTO emp (empno,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)
values(8000,'TIGER','CLERK',NULL,sysdate,1380,NULL,null);




--퀴즈 : https://jjang051-oracle-quiz04.netlify.app/quiz.html
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
	
--1. 
--ansi
SELECT e.DEPTNO AS 부서정보,
		d.DNAME AS 직무
FROM emp e
	JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO 
WHERE SAL >2000
ORDER BY e.DEPTNO;
	
--oracle
-- Oracle SQL에서는 테이블 간의 조인을 FROM 절에 
-- 테이블 목록을 나열하는 방식으로 수행할 수 있습니다. 
-- JOIN 조건은 WHERE 절에 명시되며, 열 별칭은 이중 인용부호(")로 묶어야 합니다. 
-- 기타 SQL 문법은 ANSI SQL과 유사하게 사용할 수 있습니다.

SELECT e.DEPTNO AS "부서정보",
       d.DNAME AS "직무"
FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
  AND SAL > 2000
ORDER BY e.DEPTNO;


--2. 
--ansi
SELECT e.DEPTNO AS 부서정보,
		d.DNAME AS 직무,
		TRUNC(avg(e.SAL),0) AS 평균급여,
		max(e.SAL) AS 최대급여,
		min(e.SAL) AS 최소급여,
		COUNT(*)  AS cnt
FROM emp e
	JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO 
GROUP BY e.DEPTNO, d.DNAME --select절의 모든 컬럼을 GROUP by에 모두 적어줘야 오류가 발생하지 않음
ORDER BY e.DEPTNO;

--oracle
-- Oracle SQL에서도 테이블 간의 조인은 FROM 절에 테이블 목록을 나열하여 수행되며, 
-- 열 별칭은 이중 인용부호(")로 묶어야 합니다. 
-- GROUP BY 구문은 ANSI SQL과 동일하게 사용할 수 있습니다. 
-- 기타 SQL 문법은 ANSI SQL과 유사하게 사용할 수 있습니다.
SELECT e.DEPTNO AS "부서정보",
       d.DNAME AS "직무",
       TRUNC(AVG(e.SAL), 0) AS "평균급여",
       MAX(e.SAL) AS "최대급여",
       MIN(e.SAL) AS "최소급여",
       COUNT(*) AS "cnt"
FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
GROUP BY e.DEPTNO, d.DNAME
ORDER BY e.DEPTNO;


--3. 
--ansi
SELECT d.DEPTNO AS 부서정보, --주의
		d.DNAME AS 직무,
		e.EMPNO AS 사원번호,
		e.ENAME AS 사원이름,
		e.JOB AS 직업,
		e.SAL AS 월급
FROM emp e
	FULL OUTER JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO 
ORDER BY e.DEPTNO;

--oracle
-- Oracle SQL에서도 테이블 간의 FULL OUTER JOIN은 FULL OUTER JOIN 구문으로 수행할 수 있습니다.
-- 열 별칭은 이중 인용부호(")로 묶어야 하며, 
-- ORDER BY 절은 필요에 따라 사용할 수 있습니다. 
-- 주의할 점은 Oracle에서는 FULL OUTER JOIN을 지원하지만 
-- 일반적으로 LEFT JOIN, RIGHT JOIN, INNER JOIN을 더 많이 사용합니다.
SELECT d.DEPTNO AS "부서정보",
       d.DNAME AS "직무",
       e.EMPNO AS "사원번호",
       e.ENAME AS "사원이름",
       e.JOB AS "직업",
       e.SAL AS "월급"
FROM emp e
FULL OUTER JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
ORDER BY d.DEPTNO;






	

--4. 
--ansi
SELECT * FROM emp;
SELECT * FROM DEPT; --deptno
SELECT * FROM SALGRADE; --sal
SELECT d.DEPTNO AS 부서번호, --주의
		d.DNAME AS 사원정보,
		e.EMPNO AS 사원번호,
		e.ENAME AS 사원이름,
		e.MGR AS 직속상관번호,
		e.SAL AS 월급,
		s.LOSAL AS 최저월급,
		s.HISAL AS 최고월급,
		s.GRADE AS 월급등급,
		e.MGR AS MGR_EMPNO,
		e.MGR AS MGR_NAME
FROM emp e
	FULL OUTER JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO 
		FULL OUTER JOIN SALGRADE s 
		ON e.sal BETWEEN s.LOSAL AND s.HISAL
ORDER BY d.DEPTNO, e.EMPNO;


--oracle
-- Oracle SQL에서도 열 별칭은 이중 인용부호(")로 묶어야 하며, 
-- ORDER BY 절은 필요에 따라 사용할 수 있습니다. 
-- 위의 예제는 주어진 ANSI SQL 쿼리를 Oracle SQL 형식으로 변환한 것입니다.
SELECT d.DEPTNO AS "부서번호",
       d.DNAME AS "사원정보",
       e.EMPNO AS "사원번호",
       e.ENAME AS "사원이름",
       e.MGR AS "직속상관번호",
       e.SAL AS "월급",
       s.LOSAL AS "최저월급",
       s.HISAL AS "최고월급",
       s.GRADE AS "월급등급",
       e.MGR AS "MGR_EMPNO",
       e.MGR AS "MGR_NAME"
FROM emp e
FULL OUTER JOIN DEPT d
ON e.DEPTNO = d.DEPTNO
FULL OUTER JOIN SALGRADE s
ON e.SAL BETWEEN s.LOSAL AND s.HISAL
ORDER BY d.DEPTNO, e.EMPNO;

















