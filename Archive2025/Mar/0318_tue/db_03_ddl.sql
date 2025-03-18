# Q1. ssafy DB를 생성해보자.
# 새 db 생성됨 (백틱은 선택)
CREATE DATABASE ssafy;

# Q2. DB 목록을 조회해보자.
SHOW DATABASES;

# Q3. ssafy DB를 사용해보자.
USE ssafy;

# Q4. ssafy DB를 삭제해보자.
# 2번 수행했을 때 이미 지워져 있으므로 재수행X
DROP DATABASE ssafy;

# IF EXIST 통한 예외처리 
DROP DATABASE IF EXISTS ssafy;

# Q5. 문자집합 설정해보자.
ALTER DATABASE ssafy 
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
# mb4는 emoji까지 포함~~
