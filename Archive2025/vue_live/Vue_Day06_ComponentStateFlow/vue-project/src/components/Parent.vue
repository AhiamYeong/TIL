<template>
  <div>
    <h2>부모컴포넌트</h2>
    <!-- 1. 정적바인딩 key="value": 전달할 리터럴 바로 명시 -->
    <!-- 2. 동적바인딩(v-bind로 'dynamic-props 이름으로
    'name' 만들고, ref로 바인딩 한 후, 실제 가지고있는 데이터 내려보내기 ) -->
    <!-- input에 'name' ref와 동적바인딩 할 수도 잇슴  -->
    <input type="text" v-model="name" />
    <!-- some-event 발생 시 실행할 콜백함수 달기기 -->
    <!-- emit-args라는 이벤트 발생 시 수신해 실행할 콜백 함수가 getNumber -->
    <parent-child my-msg="hello2" :dynamic-props="name" @some-event="someCallback" @emit-args="getNumber" @update-name="updatNameeee"></parent-child>
  </div>
</template>

<script setup>
import ParentChild from "./ParentChild.vue";

import { ref } from "vue";
const name = ref("Lee");

const someCallback = function () {
  alert("자식 이벤트 발생했슴");
};

// 인자 여러 개 전달하고 싶으면 앞에 ... 붙여야댐!

const getNumber = function (...args) {
  console.log(args);
};

const updatNameeee = function (newName) {
  //   name.value = "Kim";
  name.value = newName;
};
</script>

<style lang="scss" scoped></style>
