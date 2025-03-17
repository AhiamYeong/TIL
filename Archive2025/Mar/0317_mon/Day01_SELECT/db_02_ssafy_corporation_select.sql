USE SSAFY_CORPORATION;

# Q1. 모든 사원 모든 정보 검색
SELECT * FROM emp;
# Q2-1. 사원이 근무하는 부서 번호
# 나눠서 쓰는 걸 권장~ 헷갈릴 수 이씀
SELECT deptno 
FROM emp;

# Q2-2. 사원이 근무하는 부서 번호(중복제거)
SELECT DISTINCT deptno
FROM emp;

# Q3. 사원의 이름, 부서번호, 업무 조회
# 여러 col: comma로 구분 
SELECT ename, deptno, job
FROM emp;

# Q4. 사원의 이름, 사번, 급여*12 (연봉), 업무 조회
SELECT ename, empno "사번", sal * 12 AS 연봉, job
# sal이 마음에 안 들어 > alias 이용해서 별칭 지정 
FROM emp;

# Q5. 사원의 이름, 사번, 커미션, 급여, 커미션 포함 급여 조회
# 덧셈 연산 했을 경우 null이면 덧셈 연산도 null 나오게 됨 
# ifnull: comm = null이면 대체하기 
SELECT ename, empno, comm, sal, sal + ifnull(comm, 0)
FROM emp;

# Q6. 모든 사원의 사번, 이름, 급여, 급여 등급  조회 (5000 이상 -> 높은연봉, 2000 이상 -> 평균 연봉, 그 외 -> 낮은연봉)
SELECT empno, ename, sal,
	CASE WHEN sal >= 5000 THEN "높은 연봉"
		WHEN sal >= 2000 THEN "평균 연봉"
        ELSE "낮은 연봉"
        
	END "연봉 등급"
FROM emp;
# 세미콜론 잘 붙여주기~ 

# Q7. 부서 번호가 30인 사원중 급여가 1500 이상인 사원의 이름, 급여, 부서번호 조회
# 조건1 부서번호 == 30, 조건2 급여 >= 1500
# 찾기 이름/급여/부서번호
SELECT ename, sal, deptno
FROM emp
# 등호 1개가 확인하는거
WHERE deptno = 30 AND sal >= 1500;


# Q8. 부서번호가 20 또는 30인 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 30 OR deptno = 20;


# Q9. 부서번호가 20,30이 아닌 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT ename, sal, deptno
FROM emp
WHERE NOT (deptno = 30 OR deptno = 20);
# 30번도 아니고 20번도 아닌? > (deptno != 30 AND deptno <> 20)
# 모두 같은 의미 


# Q10. 업무가 MANAGER, ANALYST, PRESIDENT 인 사원의 이름, 사번, 업무조회
SELECT ename, empno, job
FROM emp
WHERE job IN ('MANAGER', 'ANALYST', 'PRESIDENT');

# Q11. 부서번호가 10, 20이 아닌 사원의 사번, 이름, 부서번호 조회
SELECT empno, ename, deptno
FROM emp
# 부서번호가 10, 20 안에 없는 
WHERE deptno NOT IN (10, 20);

# Q12. 급여가 2000이상 3000이하 인 사원의 사번, 이름, 급여조회
SELECT empno, ename, sal
FROM emp
# WHERE sal >= 2000 AND sal <= 3000; 
WHERE sal BETWEEN 2000 AND 3000 ;

# Q13. 입사일이 1981년인 직원의 사번, 이름, 입사일 조회

# Q14. 커미션인 NULL 인 사원의 사번, 이름, 커미션 조회
SELECT empno, ename, comm
FROM emp
WHERE comm is NULL;


# Q15. 커미션 NULL이 아닌 사원의 사번, 이름, 업무, 커미션 조회
SELECT empno, ename, comm
FROM emp
WHERE comm is NOT NULL;

# Q16. 이름이 M으로 시작하는 사원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE 'M%';

# Q17. 이름에 E가 포함된 사원의 사번 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE '%E%';
# Q18. 이름의 세번째 알파벳이 'A'인 사원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE '__A%';


# Q19. 모든 직원의 모든 정보를 이름을 기준으로 내림차순 정렬
SELECT *
FROM emp
ORDER BY ename DESC;

# Q20. 모든 사원의 사번 이름, 급여를 조회 (급여 내림차순)
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC;


# Q21. 20, 30번 부서에 근무하는 사원의 사번, 이름, 부서번호, 급여 조회 (부서별 오름차순, 급여순 내림차순)
SELECT empno, ename, deptno, sal
FROM emp
WHERE deptno IN (20, 30)
# 조건 2개 걸기: column 넣는 순서에 따라 기준1 / 기준 2 나뉨 
ORDER BY deptno, sal DESC;

# limit 절
SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 5, 5;
# 자바에서 db로 sql 날리는데... 변수A 변수B로 결정가능...
# 5명 넘어가서 그 다음 5명 가져오고 싶을 떄?? 앞 5개 건너뛰고 다음 5명 

# Q22. 모든 사원에 대하여 사원수, 급여총액, 평균급여, 최고급여, 최저급여 조회
# count는 null은 체크하지 않는구나~~ 그거 방지할려고 * 쓴거야
SELECT count(*), sum(sal), avg(sal), max(sal), min(sal)
FROM emp;

# Q23. 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별로 조회하고, 소수점 둘째자리 반올림

# Q24. 모든 사원에 대하여 부서, 업무, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별, 직급별로 조회

# Q25. 급여(커미션포함) 평균이 2000이상인 부서번호, 부서별 사원수, 평균급여(커미션포함) 조회 



