<template>
  <div>
    <h2>App.vue</h2>

    <RouterLink to="/">Home</RouterLink> |
    <RouterLink to="/about">About</RouterLink> |
    <RouterLink :to="{ name: 'home' }">HomeName</RouterLink> |
    <RouterLink :to="{ name: 'about' }">AboutName</RouterLink> |
    <RouterLink :to="{ name: 'user', params: { id: 'godqhr' } }"
      >양띵균</RouterLink
    >
    |
    <RouterLink :to="{ name: 'user', params: { id: 'ssafy' } }"
      >김싸피</RouterLink
    >
    |
    <RouterLink :to="{ name: 'login' }">Login</RouterLink> |
    <RouterLink :to="{ name: 'board' }">Board</RouterLink> |

    <RouterView />
  </div>
</template>

<script setup>
// 아래의 import는 생략해도 동작한다.
// import { RouterLink, RouterView } from 'vue-router';
</script>

<style scoped></style>
