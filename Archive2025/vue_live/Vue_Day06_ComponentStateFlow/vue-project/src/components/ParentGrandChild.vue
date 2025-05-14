<template>
  <div>
    <h2>자손 컴포넌트</h2>
    <p>자손: {{ myMsg }}</p>
    <input type="text" v-model="name" />
    <!-- 이름바꿔 이벤트 수신하기기 -->
    <button @click="updateName">이름바꾸기</button>
  </div>
</template>

<script setup>
import { ref } from "vue";

defineProps({
  myMsg: String,
});

// updateName이라는 event 발생하는걸 'emit' 변수에 담아서 저장
const emit = defineEmits(["updateName"]);
const name = ref("");

const updateName = function () {
  emit("updateName", name.value); //'updateName' 이벤트로, 이벤트의 payload를 'name.value'로
  name.value = "";
};
</script>

<style lang="scss" scoped></style>
