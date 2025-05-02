const registBtn = document.querySelector("#regist");
const inputTag = document.querySelector("#todo-value");
const ulTag = document.querySelector("#todo-list");

let todoList; // 실행되며 값 변경되므로로

// 함수 표현식!
const registTodo = () => {
  const content = inputTag.value;

  if (!content.trim()) {
    // 입력된게 없다면
    alert("입력해줘잉");
  } else {
    const todoItem = {
      todo: content,
      done: false,
    };

    inputTag.value = ""; // value 초기화
    inputTag.focus();

    todoList.push(todoItem);
    localStorage.setItem("todoList", JSON.stringify(todoList));
  }
};

const createTodoItem = (toDoItem) => {
  const liTag = document.createElement("li");
  const spanTag = document.createElement("span");
  spanTag.innerText = toDoItem.todo;
  liTag.appendChild(spanTag);
  ulTag.appendChild(liTag);
};

registBtn.addEventListener("click", registTodo);

// 초기 세팅
window.addEventListener("load", function () {
  todo = localStorage.getItem("todoList");
  if (todoList != null) {
    todoList = JSON.parse(todoList); // 배열로 다시 원복

    for (let i = 0; i < todoList.length; i++) {
      createTodoItem(todoList[i]);
    }
  } else {
    todoList = [];
  }
});
