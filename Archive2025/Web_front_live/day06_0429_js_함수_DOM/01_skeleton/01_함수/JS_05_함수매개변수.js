// 함수 매개변수

// 함수는 호출 시 매개변수의 영향을 받지 않음
// arguments 라는 함수 내부의 프로퍼티를 이용하여 매개변수의 처리가 가능

// 기본 인자 (default arguments)를 사용할 수 있음
function funcA(num){
    console.log("fnA: ", num)
}

funcA()
funcA(10) // 10
funcA(10, 20) // 10 
// 요상하다 요상해

function funcB(){
    console.log(arguments.length)
    for (let i = 0; i < arguments.length; i++){
        console.log(arguments[i])
    }
}

funcB(1)
funcB(1, 2, 3, 4, 5)

// 자바스크립트의 함수는 오버로딩 개념을 지원하지 않음
// 하나씩 했을 때는 되는데 둘다 한 번에 하면 에라 모르겠다 undefined