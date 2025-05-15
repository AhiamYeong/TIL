<template>
  <div>
    <h2>UserView</h2>
    <!-- id에 직접 접근: 비권장 -->
    <h3>{{ $route.params.id }}</h3>

    <!-- 권장 -->
    <h3>{{ userId }}</h3>
    <h3>{{ userId2 }}</h3>

    <button @click="goHome">홈으로</button>
  </div>
</template>

<script setup>
import { onBeforeUpdate, ref, watch } from "vue";
import {
  onBeforeRouteLeave,
  onBeforeRouteUpdate,
  useRoute,
  useRouter,
} from "vue-router";

const route = useRoute();

// route 갖고와서 뜯어서 쓰는방식이 권장댐
const userId = ref(route.params.id);
const userId2 = ref(route.params.id);
watch(
  () => route.params.id,
  (newId) => {
    userId.value = newId;
  }
);

// router.push
const router = useRouter();

// home 이동 버튼
const goHome = function () {
  // router.push("/about");
  router.push({ name: "home" }); // name으로 접근: 권장
};

// 3 Navigation Guard
onBeforeRouteLeave(() => {
  const answer = confirm("진짜 떠나요? ");
  // if (!answer) return false;
  return answer;
});

// 3.1 Navigation Guard
onBeforeRouteUpdate((to) => {
  userId2.value = to;
});
</script>

<style scoped></style>
