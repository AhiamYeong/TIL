import { ref, computed } from "vue";
import { defineStore } from "pinia";

// persistedstate 추가
export const useTodosStore = defineStore("todos", () => {
  let id = 0;

  const todos = ref([
    { id: id++, text: "비빔밥 먹기", isDone: true },
    { id: id++, text: "잠자기", isDone: false },
    { id: id++, text: "놀러 가기", isDone: false },
  ]);

  const updateTodo = function (id) {
    // todo values 뜯어보고 찾기
    const findTodo = todos.value.find((todo) => todo.id === id);

    // 방법 n가지 ~~
    if (findTodo) {
      findTodo.isDone = !findTodo.isDone;
    }
  };

  // 원본의 내용물 쏙 빼기
  // const deleteTodo = function (id) {
  //   const idx = todos.value.findIndex((todo) => {
  //     return todo.id == id;
  //   });

  //   todos.value.splice(idx, 1);
  //   // 지금은 동일하지만 idx는 배열의 순서, id는 ref 배열 안의 id값임
  // };

  // filter method 이용: 만족하는 결과 모아 새 배열 만들어서 '덮어씌우기'
  const deleteTodo = function (id) {
    todos.value = todos.value.filter((todo) => todo.id !== id);
  };

  const addTodo = function (text) {
    todos.value.push({
      id: id++,
      text: text,
      idDone: false,
    });
  };

  const doneTodoCount = computed(() => {
    // todo.isDone = true인 경우의 length만 모아서 새 배열 만들어 반환
    return todos.value.filter((todo) => todo.isDone).length;
  });

  return { todos, updateTodo, deleteTodo, addTodo, doneTodoCount };
});
