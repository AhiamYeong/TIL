<template>
  <div>
    <h2>Main</h2>
    <TheHeaderNav />
    <router-view></router-view>
  </div>
</template>

<script setup>
import TheHeaderNav from "@/components/common/TheHeaderNav.vue";
</script>

<style scoped></style>
