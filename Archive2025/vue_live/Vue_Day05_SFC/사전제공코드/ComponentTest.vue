<template>
  <div>
    <h2>Component TEST</h2>
    <input type="text" v-model="message">
    <div :class="message">{{message}}</div>
  </div>
</template>

<script setup>
  import {ref} from 'vue'

  const message = ref("orange")


</script>

<style scoped>
  .orange {
    color: orange;
  }
  .red {
    color: red;
  }
</style>
