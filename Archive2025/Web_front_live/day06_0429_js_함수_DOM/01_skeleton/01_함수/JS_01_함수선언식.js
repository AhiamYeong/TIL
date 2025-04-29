// function 함수명() { 함수 내용 }

// 함수의 이름과 함께 정의하는 방식
// 함수의 이름
// 매개 변수
// 내용
// 호이스팅 됨


// 일반적 함수 선언 & 호출 
function greeting(name){
    return `Welcome, ${name}`
}
console.log(greeting('ssafy'))


// Hoisting 가능 
console.log(greeting2('ssafy'))
function greeting2(name){
    return `Welcome, ${name}`
}
