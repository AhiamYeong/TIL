//함수를 간결하게 정의할 수 있도록 도움을 줌.
// 작성순서
// 1. function 키워드 삭제
// 2. ( ) 안에 함수가 사용할 파라미터 이름 작성 / 인자가 한개라면 괄호 생략가능  // ex) let pow = a => a**2
// 3. 화살표 ( => ) 를 붙인다.
// 4. { } 를 작성하고 블록 안에 함수가 실행할 코드 작성 / 함수가 return 문 하나라면 return 생략 가능

let add = function(a, b){
    return a + b
}

//  
/* 
1 function keyword 삭제

let add2 = (a, b){
    return a + b
}

2. ( ) 안에 함수가 사용할 파라미터 이름 작성 / 매개변수 1개라면 괄호도 생략 가능
 -> 근데 또 매개변수 아예 없으면 괄호 생략 불가넝함
3. 화살표 ( => ) 를 붙인다.
*/
let add2 = (a, b) => {
    return a + b
}

/*
4. 블록 안에 함수가 실행할 코드 작성, return 문 하나라면 return 생략가능 
*/
let add3 = (a, b) => a + b