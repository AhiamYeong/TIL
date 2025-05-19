<template>
    <div>
        <h3>TodoList</h3>
        <!-- v-for의 'todo'를 todo 이름으로 props 내려보내기  -->
        <TodoListItem v-for="todo in store.todos" :todo="todo" />
    </div>
</template>

<script setup>
import TodoListItem from "./TodoListItem.vue";

import { useTodosStore } from "@/stores/todos";
const store = useTodosStore();
</script>

<style lang="scss" scoped></style>
