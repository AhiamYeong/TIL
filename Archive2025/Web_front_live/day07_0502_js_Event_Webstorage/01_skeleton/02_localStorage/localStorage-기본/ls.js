//////// 페이지에 처음 들어왔을 때
window.addEventListener("load", function () {
  let data = localStorage.getItem("data");
  if (data != null) {
    document.querySelector("#saved > li").innerText = JSON.parse(data);
  } else {
    document.querySelector("#saved > li").innerText = "저장된 내용이 없습니다.";
  }
});

//////// 등록 #create

// 1. 등록 버튼 선택(접근)
const createBtn = document.querySelector("#create");

// 2. 등록 버튼에 클릭 이벤트 추가
createBtn.addEventListener("click", function () {
  // 2-a. input 태그  || input 아이디 선택
  const inputTag = document.querySelector("#input");

  // 2-b. input에서 가져온 value를 json문자열으로 바꾸기
  let jsonData = JSON.stringify(inputTag.value);

  // 2-c. localStorage에 "data" 이름으로 값 추가 > key, value로 추가
  localStorage.setItem("data", jsonData);

  // (중요) 2-d. input태그의 value값 초기화/빈 문자열로 날려주기기
  inputTag.value = "";
});

//////// 조회 #read
// 코드를 작성하세요.
document.querySelector("#read").addEventListener("click", function () {
  const liTag = document.querySelector("#saved > li");
  const jsonData = localStorage.getItem("data");

  if (jsonData != null) {
    liTag.innerText = JSON.parse(jsonData); // 문자열 > JSON 원복하기
  }
});

//////// 삭제 #delete
// 코드를 작성하세요.
document.querySelector("#delete").addEventListener("click", function () {
  localStorage.removeItem("data").innerText = "저장된 내용이 없습니다.";

  // 화면에서 날려주기
});
