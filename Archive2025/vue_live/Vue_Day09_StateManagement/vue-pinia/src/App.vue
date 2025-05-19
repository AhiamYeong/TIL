<template>
  <div>
    <h1>TodoTest</h1>
    <p>전체 todo 개수: {{ store.todos.length }}</p>
    <p>완료된 todo 개수: {{ store.doneTodoCount }}</p>
    <p>미완료된 todo 개수: {{ store.todos.length - store.doneTodoCount }}</p>
    <TodoForm />
    <TodoList />
  </div>
</template>

<script setup>
import { useTodosStore } from "./stores/todos";
const store = useTodosStore();

import TodoForm from "./components/TodoForm.vue";
import TodoList from "./components/TodoList.vue";
</script>

<style lang="scss" scoped></style>
