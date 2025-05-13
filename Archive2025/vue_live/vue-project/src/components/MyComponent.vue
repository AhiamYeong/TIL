<template>
  <div>
    <h2>MyComponent</h2>

    <!-- v-for로 반복문 돌릴 수 있지: 해당 컴포넌트에 데이터 같이 내려줘야 함 -->
    <MyComponentItem />
    <my-component-item></my-component-item>
  </div>
</template>

<script setup>
import MyComponentItem from "./MyComponentItem.vue";
</script>

<style lang="scss" scoped></style>
