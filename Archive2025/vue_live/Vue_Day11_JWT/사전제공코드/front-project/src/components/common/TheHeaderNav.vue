<!-- @format -->

<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link>
      |
      <router-link :to="{ name: 'boardList' }">BoardList</router-link>
      |
      <router-link :to="{ name: 'boardCreate' }">BoardCreate</router-link>
      |
      <router-link :to="{ name: 'login' }">Login</router-link>
      |
    </nav>
  </div>
</template>

<script setup></script>

<style scoped></style>
