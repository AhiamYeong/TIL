// Array Helper 배열의 친구 
const nums = [1, 2, 3, 4, 5];

// 1. forEach - 각 요소를 하나씩 출력 (반환값 없음 / undefined)
nums.forEach(
    (x) => { console.log(x) } // 화살표 함수 이용 정의 
)

// 2. map - 각 요소에 대해 연산 처리 -> 리턴값들 모아 새로운 배열 반환
const double = nums.map(
    (x) => { return x * 2}
)
console.log(double)

// 3. filter - 3보다 큰 값만 필터링하여 새로운 배열 반환
const filtered = nums.filter( (x) => { return x > 3} )
console.log(filtered)

// 4. find - 3보다 큰 첫 번째 값을 반환

// 5. findIndex - 3보다 큰 첫 번째 값의 인덱스를 반환

// 6. some - 하나라도 4보다 큰 값이 있는지 여부 (true/false)

// 7. every - 모든 값이 0보다 큰지 여부 (true/false)

// 8. reduce - 모든 값을 누적해서 합산
const sum = nums.reduce( (acc, x) => acc+x, 0 )
console.log(sum)

// 9. includes - 배열에 특정 값(3)이 포함되어 있는지 여부

// 10. sort - 배열을 오름차순으로 정렬 (원본 배열 변경됨!)
nums.sort((a, b) => b - a)