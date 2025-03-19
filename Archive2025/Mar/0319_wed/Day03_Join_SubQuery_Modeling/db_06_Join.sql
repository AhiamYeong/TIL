USE `ssafy_corporation`;

# Q1. 카타시안 곱 
-- SELECT empno, ename, job

# Q2. 사번 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회

-- INNER JOIN 키워드 사용해보자.
SELECT *
FROM emp
INNER JOIN dept 
ON emp.DEPTNO = dept.DEPTNO
WHERE EMPNO = 7788;

-- using
SELECT ename, job, deptno, dname
FROM emp
INNER JOIN dept
USING (deptno)
WHERE EMPNO = 7788;

-- 부서 없는 직원 고용
INSERT INTO emp VALUES (7777, "애옹", "MANAGER", 7839, "2025-03-19", 1000, NULL, NULL);
-- 고용한 직원은 등장하지 않음 // 부서가 없으니까
-- NULL 허용 시 이슈 있을 수 있음
-- 없는 부서를 가라로 하나 만들어서 넣는 게 오히려 좋을 수도 있다. 
SELECT ename, emp.DEPTNO, dept.DNAME FROM emp, dept WHERE emp.DEPTNO = dept.deptno;

-- OUTER JOIN (한 쪽 table에 기준 두고 사용하기)
SELECT ename, emp.DEPTNO, dept.DNAME 
-- 기준이 emp, emp에 있는 데이터는 전부 출력하고 + dept에서 붙을 수 있는 정보들 싹 나오겠당 
FROM emp
LEFT OUTER JOIN dept
ON emp.DEPTNO = dept.deptno;


-- 셀프 조인
-- 모든 사원의 이름, 매니저번호, 매니저이름 가져오기
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;

SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1
LEFT OUTER JOIN emp e2
ON e1.mgr = e2.empno;

-- 비 동등 조인(Non-Equi JOIN)


