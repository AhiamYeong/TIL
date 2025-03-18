# Q1. ssafydb1 데이터 베이스 생성 및 사용
CREATE DATABASE ssafydb1;

# 이 db 사용할거얌
USE ssafydb1;

# Q2. ssafy_user 테이블 생성
CREATE TABLE ssafy_user (
    user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_email VARCHAR(30),
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

# table scheme 보기 
DESC ssafy_user;

# Q3. INSERT 쿼리를 사용해보자.
# 빈 db에 값 넣기 
INSERT INTO ssafy_user
-- 몽땅 작성하기 
VALUES (10, "godqhr", "양씨", "0000", "godqhr@gmail.com", now());
# pk 중복되면 안댐 
# 1-5번 갖고 있고, 바로 다음에 10번등록하고 다른 애를 한번 더 등록하게 되면 11번 됨 ! 
# 1-5 있고, 10 지우고 11 지우면 다음에 등록하는 사람은 6번? 12번? => 12번!
# 한 번 지나간 자리는 돌아오지 않음 

-- 원하는 컬럼만 작성하기: 각 1:1 대응되도록 값 넣기 
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("kimssafy", "김싸피", "1234");

-- 여러 데이터 넣기
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("leessafy1", "리싸피", "1234"), 
 ("leessafy2", "리싸피", "1234"), 
  ("leessafy3", "리싸피", "1234");
        
        
# Q4. 데이터를 수정해보자
-- 데이터 수정 조건x(safe mode 해제) Edit -> preferences -> SQLEditor
UPDATE ssafy_user
SET user_name = 'anonymous';

-- userno: 3의 비번 수정하자
UPDATE ssafy_user
SET user_password = '1111'
WHERE user_num = 3;

# Q5. 데이터를 삭제해보자
DELETE FROM ssafy_user
WHERE user_num = 4;

SELECT * FROM ssafy_user;
