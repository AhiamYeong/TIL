// 함수의 리턴

// 함수의 실행 결과로 함수를 반환할 수 있음
// 함수가 특별한 값을 리턴 하지 않은 경우 undefined가 반환됨

/* 자유롭게 코드를 작성해보세요. */
function func1(){
    // 반환 결과로만 쓸 거니까 이름 없는 익명함수로 함수 반환 
    return function(num1, num2) {
        return num1 + num2;
    }
}
console.log(func1()(10, 20))

// 내부적으로 이 작업이 이루어지는거얌 
let returnFn = func();
console.log(returnFn(10, 20))

function func2() {}
console.log(func2()) // undefined

