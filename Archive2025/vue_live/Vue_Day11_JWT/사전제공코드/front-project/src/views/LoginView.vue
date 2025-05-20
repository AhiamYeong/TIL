<!-- @format -->

<template>
  <div>
    <h4>login</h4>
    <input type="text" placeholder="아이디 입력하쇼" v-model.trim="id" />
    <input
      type="password"
      placeholder="비번 입력하쇼"
      v-model.trim="password"
    />
    <button @click="login">로그인</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const id = ref("");
const password = ref("");

const login = function () {};
</script>

<style lang="scss" scoped></style>
