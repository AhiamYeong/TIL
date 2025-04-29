// let 함수명 = function() { 함수 내용 }

// 익명함수로 정의가능
// 매개 변수
// 내용

/* 자유롭게 코드를 작성해보세요. */
let greeting3 = function(name){
    return `Welcome, ${name}`
}
console.log(greeting3) // 이건 변수만 호출하는거 

// 익명함수
/* 자유롭게 코드를 작성해보세요. */
// 이슈 발생 ~~ 표현식 함수는 선언 이전 사용 불가능 
console.log(greeting4('lee'))
let greeting4 = function(name){
    return `Welcome, ${name}`
}