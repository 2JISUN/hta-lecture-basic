--1. 덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후 사원의 이름, 급여, 인상된 급여를 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여,
		sal+300 AS 인상된급여
FROM emp;

--2.사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력하시오, 연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
	sal AS 급여,
	sal*12 +100 AS 연간_총_수입
FROM emp
ORDER BY sal desc;

--3.급여가 2000을 넘는 사원의 이름과 급여를 표현, 급여가 많은 것부터 작은 순으로 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여
FROM emp
WHERE sal>2000
ORDER BY sal desc;

--4.사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		DEPTNO AS 부서번호
FROM emp
WHERE EMPNO=7788;


--5.급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여
FROM emp
WHERE sal<2000 OR sal>3000;


--6.1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당업무, 입사일을 출력하시오.

SELECT * FROM emp;
SELECT ENAME AS 사원명,
		job AS 담당업무,
		TO_CHAR(HIREDATE,'yy/mm/dd') AS 입사일
FROM emp
WHERE HIREDATE BETWEEN '1980-02-20' AND '1981-05-01';

--7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		DEPTNO AS 부서번호
FROM emp
WHERE DEPTNO IN(20,30)
ORDER BY ENAME desc;

--8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력, 이름순(오름차순)으로 출력하시오.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		sal AS 급여,
		DEPTNO AS 부서번호
FROM emp
WHERE (sal BETWEEN 2000 AND 3000) AND (DEPTNO IN(20,30))
ORDER BY ENAME;


--9. 
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		TO_CHAR(HIREDATE,'yy/mm/dd') AS 입사일
FROM emp
WHERE TO_CHAR(HIREDATE,'yyyy') LIKE '1981';


--10. 
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		JOB AS 담당업무
FROM emp
WHERE MGR IS null;


--11. ???
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		SAL AS 급여,
		COMM AS 커미션
FROM emp
WHERE COMM IS NOT NULL AND COMM !=0
ORDER BY COMM desc;


--12.
SELECT * FROM emp;
SELECT ENAME AS 사원명
FROM emp
WHERE ENAME LIKE '__R%';


--13.
SELECT * FROM emp;
SELECT ENAME AS 사원명
FROM emp
WHERE ENAME LIKE '%A%' and ENAME LIKE '%E%';

--14.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		job AS 담당업무,
		SAL AS 급여
FROM emp
WHERE SAL NOT in(1600,950,1300);

--15.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		SAL AS 급여,
		COMM AS 커미션
FROM emp
WHERE COMM >=500;


--16.
SELECT * FROM emp;
SELECT ENAME AS 사원명,
		SUBSTR(TO_CHAR(HIREDATE),1,2)  AS 입사_년,
		SUBSTR(TO_CHAR(HIREDATE),4,2) AS 입사_달
FROM emp;

--17.
SELECT * FROM emp;
SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'yy/mm/dd') AS HIREDATE,SAL ,COMM,DEPTNO
FROM emp
WHERE SUBSTR(TO_CHAR(HIREDATE),4,2) =4;

--18.
SELECT * FROM emp;
SELECT EMPNO,ENAME,JOB,MGR,TO_CHAR(HIREDATE,'yy/mm/dd') AS HIREDATE,SAL ,COMM,DEPTNO
FROM emp
WHERE MOD (EMPNO,2)=0;


--19.
SELECT * FROM emp;
SELECT TO_CHAR(HIREDATE,'yy') AS YY,
		TO_CHAR(HIREDATE,'mm') AS MM ,
		TO_CHAR(HIREDATE,'dd') AS DD
FROM emp;

--20.
SELECT TO_DATE((TO_char(SYSDATE,'YYYY-mm-dd')))-TO_DATE('2023-01-01') 
FROM dual;

--21.
SELECT * FROM emp;
SELECT nvl(MGR,0)
FROM emp;



--22.
SELECT * FROM emp;
SELECT ENAME AS 이름,
		SAL AS 급여,
		CASE 
          WHEN JOB like 'ANALIST' THEN SAL + 200
          WHEN JOB like 'SALESMAN' THEN SAL + 180
          WHEN JOB like 'MANAGER' THEN SAL + 150
          WHEN JOB like 'CLERK' THEN SAL + 100
       END AS 인상된급여
FROM emp;

SELECT ENAME AS "이름",
       SAL AS "급여",
       DECODE(JOB, 
              'ANALIST', SAL + 200,
              'SALESMAN', SAL + 180,
              'MANAGER', SAL + 150,
              'CLERK', SAL + 100) AS "인상된급여"
FROM emp;


--23.
SELECT * FROM emp;
SELECT max(SAL) AS 최고액,
		min(SAL) AS 최저액,
		sum(SAL) AS 총액,
		avg(SAL) AS 평균
FROM emp;

--24.
SELECT * FROM emp;
SELECT max(SAL) AS 최고액,
		min(SAL) AS 최저액,
		sum(SAL) AS 총액,
		round(avg(SAL),0) AS 평균
FROM emp
GROUP BY JOB;

--24.
SELECT * FROM emp;
SELECT JOB AS 담당업무,
		max(SAL) AS 최고액,
		min(SAL) AS 최저액,
		sum(SAL) AS 총액,
		round(avg(SAL),0) AS 평균
FROM emp
GROUP BY JOB;


--25.
SELECT * FROM emp;
SELECT JOB AS 담당업무,
		COUNT(*) AS 사원수
FROM emp
GROUP BY JOB;


--26.
SELECT * FROM emp;
SELECT COUNT(*) AS 관리자수
FROM emp
WHERE JOB LIKE 'MANAGER';


--27.
SELECT * FROM emp;
SELECT 
		max(SAL) AS 최고액,
		min(SAL) AS 최저액,
		max(SAL) - min(SAL) AS 차액
FROM emp;


--28.
SELECT * FROM emp;
SELECT 
		job AS 직급,
		min(SAL) AS 최저액
FROM emp
GROUP BY job
HAVING min(SAL)>=2000;


--29.
SELECT * FROM emp;
SELECT 
		DEPTNO AS 부서번호,
		COUNT(*)  AS 사원수,
		ROUND(AVG(sal),2) AS 평균급여
FROM emp
GROUP BY DEPTNO
ORDER BY DEPTNO desc;

--30.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
SELECT 
		e.DEPTNO AS 부서번호,
		d.DNAME AS 부서이름,
		d.LOC AS 지역명,
		COUNT(*)  AS 사원수,
		ROUND(AVG(sal),0) AS 평균급여
FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
GROUP BY e.DEPTNO, d.DNAME, d.LOC
ORDER BY e.DEPTNO desc;



--31.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT 
		e.DEPTNO AS 부서번호,
		sum(e.sal) AS 총액,
		d.DNAME AS 부서명
FROM emp e, DEPT d
WHERE e.DEPTNO = d.DEPTNO
GROUP BY e.DEPTNO, d.DNAME
ORDER BY e.DEPTNO;



--32.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT e.ENAME AS 사원명,
		e.DEPTNO AS 부서번호,
		d.DNAME AS 부서이름
FROM emp e
	JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO
WHERE e.ENAME LIKE 'SCOTT'
ORDER BY e.DEPTNO;



--33.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT e.ENAME AS 사원이름,
		d.DNAME AS 부서이름,
		d.LOC AS 지역명
FROM emp e
	JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO
ORDER BY e.ENAME;



--34.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT emp.EMPNO AS "사원번호",
       DEPT.LOC AS "지역명",
       emp.JOB AS "담당업무"
FROM emp
JOIN DEPT USING (DEPTNO)
WHERE emp.DEPTNO = 10
ORDER BY emp.ENAME;



--35.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT emp.ENAME AS "사원이름",
		DEPT.DNAME AS "부서이름",
       DEPT.LOC AS "지역명"
FROM emp natural join DEPT 
ORDER BY emp.ENAME;


--36.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT e.ENAME AS "이름",
		d.DNAME AS "부서명"
FROM emp e
	JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO
WHERE e.ENAME LIKE '%A%'
ORDER BY e.ENAME;


--37. ???
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT emp.ENAME AS "사원명",
		emp.JOB AS "업무",
		emp.DEPTNO AS "부서번호",
		DEPT.DNAME AS "부서명"
FROM emp natural join DEPT 
WHERE DEPT.LOC  LIKE 'NEW YORK'
ORDER BY emp.ENAME;



--38.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT e1.EMPNO AS "사원번호",
       e1.ENAME AS "사원이름",
       e2.EMPNO AS "관리자번호",
       e2.ENAME AS "관리자이름"
FROM emp e1
	LEFT JOIN emp e2 
	ON e1.MGR = e2.EMPNO
ORDER BY e2.ENAME;

--39.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT  e1.ENAME AS "사원이름",
		e1.EMPNO AS "사원번호"
FROM emp e1
	LEFT JOIN emp e2 
	ON e1.MGR = e2.EMPNO
UNION
SELECT  e3.ENAME AS "사원이름",
		e3.EMPNO AS "사원번호"
FROM emp e3
WHERE e3.MGR IS NULL
ORDER BY "사원번호" DESC;


--40.
SELECT e.ENAME AS "사원의 이름", 
		e.DEPTNO AS "부서 번호"
FROM emp e
	JOIN emp s 
	ON e.DEPTNO = s.DEPTNO
WHERE s.ENAME = 'SCOTT';


--41.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;


SELECT e.ENAME AS "사원의 이름",
       TO_CHAR(e.HIREDATE, 'YY/MM/DD') AS "입사일"
FROM emp e
	JOIN emp w 
	ON e.HIREDATE < w.HIREDATE AND w.ENAME = 'WARD';


--42.
SELECT * FROM emp;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

SELECT e1.ENAME AS "사원의 이름",
       TO_CHAR(e1.HIREDATE, 'YY/MM/DD') AS "사원 입사일",
       TO_CHAR(e2.HIREDATE, 'YY/MM/DD') AS "관리자 입사일",
       e2.ENAME AS "관리자 이름"
FROM emp e1
JOIN emp e2 ON e1.MGR = e2.EMPNO
WHERE e1.HIREDATE < e2.HIREDATE;

--43. sql(오라클)에서 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
SELECT e1.ENAME AS "사원의 이름",
       e1.JOB AS "담당업무"
FROM emp e1
JOIN emp e2 ON e1.JOB = e2.JOB
WHERE e2.EMPNO = 7788 AND e1.EMPNO <> 7788;

--위 쿼리에서 e1은 모든 사원을 나타내며, e2는 사원 번호가 7788인 사원을 나타냅니다. 두 테이블을 담당 업무(JOB)를 기준으로 조인하고, 담당 업무가 같으면서 사원 번호가 7788이 아닌 경우를 선택합니다. 결과로는 사원의 이름과 담당 업무가 출력됩니다.



--44. sql(오라클)에서 사원 번호가 7499인 사원보다 급여가 많은 사원을 표시하시오.
SELECT e.ENAME AS "사원의 이름",
       e.JOB AS "담당업무",
       e.SAL AS "급여"
FROM emp e
WHERE e.SAL > (SELECT SAL FROM emp WHERE EMPNO = 7499)
  AND e.EMPNO <> 7499;

--위 쿼리에서는 먼저 서브쿼리를 사용하여 사원 번호가 7499인 사원의 급여를 가져옵니다. 그런 다음 메인 쿼리에서는 서브쿼리의 결과와 비교하여 급여가 더 많은 사원을 선택합니다. 또한, 사원 번호가 7499인 사원은 제외하기 위해 e.EMPNO <> 7499 조건을 추가합니다. 결과로는 이름, 담당 업무 및 급여가 출력됩니다.


--45. sql(오라클)에서 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
SELECT ENAME AS "사원의 이름",
       SAL AS "급여",
       JOB AS "담당업무"
FROM emp
WHERE SAL = (SELECT MIN(SAL) FROM emp);

--위 쿼리에서 서브쿼리를 사용하여 가장 낮은 급여를 찾고, 메인 쿼리에서는 해당 급여와 같은 사원의 이름, 급여 및 담당 업무를 선택합니다. 결과로는 최소 급여를 받는 사원의 정보가 출력됩니다.




--46. sql(오라클)에서 평균급여가 가장 적은 직급과 직급의 평균을 구하시오.
SELECT JOB AS "담당업무",
       AVG(SAL) AS "평균급여"
FROM emp
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG_SAL) FROM (SELECT JOB, AVG(SAL) AS AVG_SAL FROM emp GROUP BY JOB));

--이 쿼리는 먼저 emp 테이블을 직급 (JOB)으로 그룹화하고 각 직급의 평균 급여를 계산합니다. 그런 다음 HAVING 절을 사용하여 평균 급여가 최소인 직급을 선택합니다. 결과로는 평균 급여가 가장 적은 직급과 해당 직급의 평균 급여가 출력됩니다.




--47. sql(오라클)에서 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
SELECT e.ENAME AS "사원명",
       e.SAL AS "급여",
       e.DEPTNO AS "부서번호"
FROM emp e
WHERE (e.DEPTNO, e.SAL) IN (
    SELECT DEPTNO, MIN(SAL)
    FROM emp
    GROUP BY DEPTNO
);


--이 쿼리는 먼저 서브쿼리를 사용하여 각 부서별로 최소 급여를 계산합니다. 그런 다음 메인 쿼리에서 각 부서의 최소 급여를 받는 사원을 선택하고 이름, 급여, 부서번호를 출력합니다. 결과로는 각 부서의 최소 급여를 받는 사원의 정보가 나타납니다.




--48. sql(오라클)에서 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시하시오.
SELECT EMPNO AS "사원번호",
       ENAME AS "이름",
       JOB AS "담당 업무",
       SAL AS "급여"
FROM emp
WHERE JOB <> 'ANALYST'
AND SAL < (SELECT MIN(SAL) FROM emp WHERE JOB = 'ANALYST');


--위 쿼리에서는 먼저 서브쿼리를 사용하여 ANALYST 업무의 최소 급여를 계산합니다. 그런 다음 메인 쿼리에서 업무가 ANALYST가 아니고 급여가 해당 최소 급여보다 작은 사원을 선택하여 출력합니다. 결과로는 요구사항을 만족하는 사원의 정보가 나타납니다.




--49.sql(오라클)에서 부하직원이 없는 사원의 이름을 표시하시오.
SELECT ENAME AS "사원명"
FROM emp
WHERE EMPNO NOT IN (SELECT DISTINCT MGR FROM emp WHERE MGR IS NOT NULL);

--위 쿼리는 먼저 서브쿼리를 사용하여 부하직원이 있는 사원의 관리자 번호를 가져옵니다. 그런 다음 메인 쿼리에서 관리자 번호가 서브쿼리의 결과에 없는 경우를 선택하여 출력합니다. 결과로는 부하직원이 없는 사원의 이름이 나타납니다.




--50.sql(오라클)에서 부하직원이  있는 사원의 이름을 표시하시오.
SELECT DISTINCT E.ENAME AS "사원명"
FROM EMP E
WHERE E.EMPNO IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL);

--위 쿼리는 먼저 서브쿼리를 사용하여 부하직원이 있는 사원의 관리자 번호를 가져옵니다. 그런 다음 메인 쿼리에서 관리자 번호가 서브쿼리의 결과에 있는 경우를 선택하여 중복된 결과를 제거하고, 결과로는 부하직원이 있는 사원의 이름이 나타납니다.



--51.sql(오라클)에서 BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
SELECT ENAME AS "사원명",
       TO_CHAR(HIREDATE, 'YY/MM/DD') AS "입사일(yy/mm/dd)"
FROM emp
WHERE DEPTNO IN (SELECT DEPTNO FROM emp WHERE ENAME = 'BLAKE') AND ENAME <> 'BLAKE';

--위 쿼리에서는 서브쿼리를 사용하여 BLAKE의 부서 번호를 가져옵니다. 그런 다음 메인 쿼리에서 BLAKE가 아닌 다른 사원 중 해당 부서 번호에 속하는 사원의 이름과 입사일을 선택합니다. 결과로는 BLAKE와 동일한 부서에 속한 다른 사원의 정보가 출력됩니다.



--52.sql(오라클)에서 급여가 전체 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
SELECT EMPNO AS "사원번호",
       ENAME AS "사원명",
       SAL AS "급여"
FROM emp
WHERE SAL > (SELECT AVG(SAL) FROM emp)
ORDER BY SAL;

--위 쿼리에서는 먼저 서브쿼리를 사용하여 전체 사원의 평균 급여를 계산합니다. 그런 다음 메인 쿼리에서 평균 급여보다 많은 급여를 받는 사원의 사원 번호, 이름 및 급여를 선택하고, 급여를 오름차순으로 정렬하여 출력합니다. 결과로는 조건을 만족하는 사원들의 정보가 나타납니다.




--53.sql(오라클)에서 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
SELECT E1.EMPNO AS "사원번호",
       E1.ENAME AS "사원명"
FROM emp E1
WHERE E1.ENAME LIKE '%K%' AND E1.DEPTNO IN (
    SELECT DISTINCT DEPTNO
    FROM emp E2
    WHERE E2.ENAME LIKE '%K%' AND E1.EMPNO <> E2.EMPNO
);

--위 쿼리에서는 먼저 E1은 이름에 'K'가 포함된 사원을 나타내며, E2는 같은 부서에서 일하는 다른 사원을 나타냅니다. E1에서 이름에 'K'가 포함되고, 동시에 E2에서도 이름에 'K'가 포함되며 E1의 사원 번호와 다른 사원의 사원 번호가 다른 경우를 선택합니다. 결과로는 조건을 만족하는 사원들의 사원 번호와 이름이 출력됩니다.




--54.sql(오라클)에서 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
SELECT e.ENAME AS "사원명",
       e.DEPTNO AS "부서번호",
       e.JOB AS "담당업무"
FROM emp e
JOIN DEPT d ON e.DEPTNO = d.DEPTNO
WHERE d.LOC = 'DALLAS';

--위 쿼리에서는 emp 테이블과 DEPT 테이블을 조인하여 부서 위치가 'DALLAS'인 부서에 속한 사원의 이름, 부서번호 및 담당업무를 선택합니다. 결과로는 조건을 만족하는 사원들의 정보가 출력됩니다.



--55.sql(오라클)에서 KING에게 보고하는 사원의 이름과 급여를 표시
SELECT e.ENAME AS "사원명",
       e.SAL AS "급여"
FROM emp e
WHERE e.MGR = (SELECT EMPNO FROM emp WHERE ENAME = 'KING');

--위 쿼리에서는 먼저 KING의 사원 번호를 서브쿼리를 사용하여 가져옵니다. 그런 다음 메인 쿼리에서 KING을 관리자로 갖고 있는 사원들의 이름과 급여를 선택합니다. 결과로는 KING에게 보고하는 사원들의 이름과 급여가 출력됩니다.


--56.sql(오라클)에서 RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
SELECT ENAME AS "사원명",
       DEPTNO AS "부서번호",
       JOB AS "담당업무"
FROM emp
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');


--위 쿼리에서는 먼저 'RESEARCH' 부서의 부서 번호를 서브쿼리를 사용하여 가져옵니다. 그런 다음 메인 쿼리에서 해당 부서 번호에 속하는 사원들의 이름, 부서번호 및 담당업무를 선택합니다. 결과로는 RESEARCH 부서의 사원들의 정보가 출력됩니다.



--57.sql(오라클)에서 전체 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
SELECT e.EMPNO AS "사원 번호",
       e.ENAME AS "사원명",
       e.SAL AS "급여"
FROM emp e
WHERE e.SAL > (SELECT AVG(SAL) FROM emp)
AND e.ENAME LIKE '%M%'
AND e.DEPTNO IN (
    SELECT DEPTNO
    FROM emp
    WHERE ENAME LIKE '%M%'
);


--위 쿼리에서는 먼저 서브쿼리를 사용하여 전체 사원의 평균 월급을 계산합니다. 그런 다음 메인 쿼리에서 급여가 평균 월급보다 많고 이름에 'M'이 포함되며 동일한 부서에 근무하는 사원을 선택하여 사원 번호, 이름, 급여를 출력합니다. 결과로는 조건을 만족하는 사원들의 정보가 출력됩니다.


--58.sql(오라클)에서 평균급여가 가장 적은 업무를 찾으시오.
SELECT JOB AS "업무"
FROM emp
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG_SAL) FROM (SELECT JOB, AVG(SAL) AS AVG_SAL FROM emp GROUP BY JOB));

--위 쿼리에서는 먼저 직급 (JOB)으로 그룹화하여 각 업무의 평균 급여를 계산합니다. 그런 다음 HAVING 절을 사용하여 평균 급여가 가장 적은 업무를 선택합니다. 결과로는 평균 급여가 가장 적은 업무가 출력됩니다.



--59.sql(오라클)에서 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
SELECT E.ENAME AS "사원명"
FROM EMP E
WHERE E.DEPTNO = (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER' AND ROWNUM = 1);


위 쿼리에서는 먼저 'MANAGER' 업무를 가진 사원 중 하나의 부서 번호를 서브쿼리를 사용하여 가져옵니다. 그런 다음 메인 쿼리에서 해당 부서 번호에 속하는 사원들의 이름을 선택하여 출력합니다. 결과로는 'MANAGER'와 동일한 부서에 소속된 사원의 이름이 출력됩니다.



--위 쿼리에서는 먼저 'MANAGER' 업무를 가진 사원 중 하나의 부서 번호를 서브쿼리를 사용하여 가져옵니다. 그런 다음 메인 쿼리에서 해당 부서 번호에 속하는 사원들의 이름을 선택하여 출력합니다. 결과로는 'MANAGER'와 동일한 부서에 소속된 사원의 이름이 출력됩니다.


































































