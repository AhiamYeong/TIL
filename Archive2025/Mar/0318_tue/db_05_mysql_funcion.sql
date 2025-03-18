# Q1. 숫자관련 함수 사용
-- 2의 3제곱
SELECT pow(2, 3) AS "2^3" FROM dual;

-- 8 나누기 3의 나머지
SELECT mod(8, 3) FROM dual;

-- 최대값, 최솟값
SELECT greatest(8, 17, 30, 44, 55), least(8, 17, 30, 44, 55);

-- 반올림
SELECT round(pi(), 3);

# Q2. 문자 관련 함수
-- 아스키 코드값 얻기
-- '0', 'a', 'A' 정도는 외우고 있기
SELECT ascii('0'), ascii('A'), ascii('a');

-- concat 메서드를 써보자.
SELECT concat(ename, "님 반갑습니당") AS 인사말 from emp;

-- 이름의 길이가 5인 직원의 이름을 조회
SELECT ename FROM emp WHERE length(ename) = 4;



-- 김싸피
SELECT length('김싸피'), char_length('김싸피');

-- 문자열 변경
SELECT replace('Hello abc abc', 'abc', 'ssafy');

-- 문자열 인덱스
SELECT instr("hello ssafy", "ssafy");

-- 모든 직원의 이름 3자리조회
SELECT substr(ename, 1, 3)
FROM emp;

-- LPAD RPAD
-- left padding, right padding 
SELECT lpad('ssafy', 10, '*'), 
rpad('ssafy', 10, '*');

-- REVERSE
SELECT reverse("hello ssafy");

# Q3. 날짜 관련함수

-- 2초 더하기
SELECT addtime('2025-03-18 10:48:30', '2');

-- 날짜차이

-- 오늘은?


# Q4. 트랜잭션 사용해보기
-- autocommit 끄기 
SET autocommit = 0;
CREATE TABLE test_table (val VARCHAR(20));

START TRANSACTION;
-- 이후부터 작업들은 한 개의 작업단위로 묶임

INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('B');
INSERT INTO test_table VALUES ('C');
INSERT INTO test_table VALUES ('D');
INSERT INTO test_table VALUES ('E');

ROLLBACK;

INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('F');
INSERT INTO test_table VALUES ('Y');

COMMIT;


SELECT * FROM test_table;

