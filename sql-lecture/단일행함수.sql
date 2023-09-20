SELECT ename, INITCAP(ename) 
FROM emp;

--dual 가짜 테이블 dummy용 테이블
SELECT LENGTH ('SCOTT') FROM dual;

--concat은 매게변수 2개까지만 허용함 
--concat 대신 || 기호를 더 많이 사용함 (개수제한이 없기때문에)
--string자르기
SELECT * FROM emp;
SELECT job, substr(job,1,2)
FROM emp;

SELECT * FROM emp;
SELECT substr('scott',1,2)
FROM emp;

SELECT * FROM dual;
SELECT substr('scott',1,2) --sc
FROM dual;

SELECT * FROM dual;
SELECT substr('scott',-3,2) --ot
FROM dual;

SELECT job FROM emp;
SELECT substr(job,-3,3)
FROM emp;

SELECT * FROM dual;
SELECT substr(job,-3,3)
FROM emp;


--이름과 근속년수
SELECT * FROM emp;
SELECT ENAME, HIREDATE AS 근속년수
FROM emp;


SELECT SYSDATE ,
	   TO_CHAR(SYSDATE,'MONTH','NLS_DATE_LANGUAGE = JAPANESE') 일본월
FROM dual;

--날짜 형식
SELECT * FROM emp;
SELECT TO_CHAR(HIREDATE, 'YY/MON/DD', 'NLS_DATE_LANGUAGE = ENGLISH') 날짜
FROM emp;


SELECT TO_CHAR(SYSDATE,'D'),
		TO_CHAR(SYSDATE,'DY'),
		TO_CHAR(SYSDATE,'DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE,'DDD') AS "365중에서",
		TO_CHAR(SYSDATE,'WW') "몇주차",
		TO_CHAR(SYSDATE,'Q') "몇분기"
FROM dual;


SELECT TO_NUMBER('11')
FROM dual;



--퀴즈

--1.
SELECT * FROM emp;
SELECT rpad(SUBSTR(ENAME,3,2), LENGTH(ENAME),'*')
FROM emp;


--2.
--일당 = 월급/21.5
--시급 = 일당/8

SELECT * FROM emp;
SELECT TRUNC(sal/21.5,2) AS 일당,
		ROUND((sal/21.5)/8, 1) AS 시급
FROM emp;


--3.
SELECT * FROM emp;
SELECT ENAME,
		HIREDATE AS 입사일,
    	to_char(next_day(add_months (HIREDATE, 3),'월요일'), 'YYYY-MM-DD') AS "전환일(월요일)"
FROM emp;



SELECT * FROM emp;
SELECT ename, comm,
		CASE 
			WHEN comm IS NULL THEN '해당없음'
			WHEN comm =0 	  THEN '커미션 없음'
			WHEN comm >0 	  THEN '커미션 : ' || comm
		END 
FROM emp;
		






































