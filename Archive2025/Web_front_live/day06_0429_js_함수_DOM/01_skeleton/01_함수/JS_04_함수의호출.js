// 함수의 호출
// 정의된 함수를 호출 시 함수 값으로 넘길 수 있음 

/* 자유롭게 코드를 작성해보세요. */
// 1 출력하는 함수 정의 
function sysout(msg){
    console.log(msg)
}

function parameterFn(func){
    func("Hello SSAFY")
}

parameterFn(sysout)