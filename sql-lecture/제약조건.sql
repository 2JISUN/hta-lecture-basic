-- 제약조건
-- 값을 무조건 입력 받아야 함
SELECT *FROM emp;


-- primary key not null unique
-- id, no, 
DROP TABLE new_emp01; --삭제
CREATE TABLE new_emp01 ( --생성
	NO number(4) 	   CONSTRAINT emp01_no_pk 		PRIMARY KEY,
	name varchar2(100) CONSTRAINT emp01_name_nn 	NOT NULL,
	jumin varchar2(13) CONSTRAINT emp01_jumin_nn 	NOT NULL	
					   CONSTRAINT emp01_jumin_uk 	UNIQUE,
	salary number(10)  CONSTRAINT emp01_salary_ck 	CHECK(salary>1000),
	deptno number(2,0) CONSTRAINT emp01_deptno_fk 	REFERENCES dept(deptno)
);

SELECT *FROM new_emp01;
SELECT * FROM SCOTT.new_emp01;
ALTER SESSION SET CURRENT_SCHEMA = SCOTT;


INSERT INTO new_emp01 VALUES (1,'이지선',9601092000000,5000,20);
INSERT INTO new_emp01 VALUES (2,'이마크',9908021000000,30);
INSERT INTO new_emp01 VALUES (3,'황런쥔',0003241000000,30);
SELECT *FROM new_emp01;

CREATE SEQUENCE emp_seq
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	9999
	   NOCYCLE	
	   nocache ;

-- 오라클이 자동 증가시킴 > 무조건 증가 > 삭제 개념 없음
SELECT emp_seq.nextval FROM dual;

INSERT INTO new_emp01 VALUES (emp_seq.nextval,'이제노',0004241000000,30);
SELECT *FROM new_emp01;


ALTER SEQUENCE emp_seq
				MAXVALUE 99999;


DROP TABLE dept03; --삭제
CREATE TABLE dept03 ( --생성
	deptno number(2,0) CONSTRAINT emp01_deptno_nn 	PRIMARY KEY,
	dname varchar2(30) CONSTRAINT emp01_name_nn 	UNIQUE,
	loc	  varchar2(30) CONSTRAINT emp01_loc_nn 		NOT NULL		   
);
SELECT *FROM dept03;


CREATE SEQUENCE dept_seq
	   INCREMENT BY 1
	   START WITH 	1
	   MINVALUE 	1
	   MAXVALUE 	9999
	   NOCYCLE	
	   nocache ;

INSERT INTO dept03 VALUES (dept_seq.nextval,'이제노','서울');
INSERT INTO dept03 VALUES (dept_seq.nextval,'정재현','뉴욕');
INSERT INTO dept03 VALUES (dept_seq.nextval,'김동영','구리');
SELECT *FROM dept03;

SELECT * FROM all_constraints;





DROP TABLE emp_const; --삭제
CREATE TABLE emp_const (
	NO 		 number(4)	CONSTRAINT emp_const_no_uk UNIQUE,
	empno 	 number(4)  CONSTRAINT emp_const_empno_pk PRIMARY KEY,
	ename 	 varchar2(30) CONSTRAINT emp_const_ename_nn NOT NULL,
	job  	 varchar2(30),
	tel 	 varchar2(13) CONSTRAINT emp_const_tel_uk UNIQUE,
	hiredate DATE,
	sal 	 number(7,2)  CONSTRAINT emp_const_sal_ck 
									 CHECK (sal >= 1000 AND sal <= 9999),
	comm 	 number(7,2),
	deptno 	 number(2) 	  CONSTRAINT emp_const_deptno_fk REFERENCES dept(deptno)
);
SELECT * FROM emp_const;

drop sequence emp_const_seq; -- 시퀀스 삭제
CREATE SEQUENCE emp_const_seq -- 시퀀스 생성
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  MAXVALUE 9999
  CACHE 100
  CYCLE ;

-- 데이터 삽입 쿼리
-- 데이터 삽입 쿼리 (수정)
INSERT INTO emp_const VALUES 
(emp_const_seq.nextval,7777, '이름', '직업', '123-456-7890', '2023-09-11', 5000, NULL, 10);
SELECT * FROM emp_const;
SELECT * FROM user_constraints;








































































