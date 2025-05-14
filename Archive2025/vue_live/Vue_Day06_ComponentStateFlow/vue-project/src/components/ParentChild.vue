<template>
  <div>
    <h2>자식컴포넌트</h2>
    <p>자식: {{ myMsg }}</p>
    <p>동적프롭스: {{ dynamicProps }}</p>
    <hr />

    <!-- 이벤트 emit: 부모의 귀 달기기 -->
    <button @click="$emit('someEvent')">클릭</button>
    <!-- event listener 달기 method -->
    <button @click="buttonClick">클릭2</button>
    <button @click="emitArgs">클릭3</button>

    <!-- 이게 동적 전달?! 받은걸 냅다 토스  -->
    <!-- update-name 메소드가 들어오는 경우 발생할 콜백함수 정의 -->
    <!-- event 수신부에서  -->
    <parent-grand-child :my-msg="myMsg" @update-name="updateNameee" />
  </div>
</template>

<script setup>
import ParentGrandChild from "./ParentGrandChild.vue";
// defineProps(["myMsg"]);
const props = defineProps({
  myMsg: String,
  dynamicProps: String,
});

//
const emit = defineEmits(["someEvent", "emitArgs", "updateNameee"]);
const buttonClick = function () {
  emit("someEvent");
};

// 'emitArgs' 이름을 바꿀 필요가 없다..?!  함수이름이랑 내부변수 얘기하는건가
// emitArgs로 이벤트 변화 전달
const emitArgs = function () {
  emit("emitArgs", 1, 2, 3); // 'emitArgs' 이벤트 이름과 1, 2, 3이라는 payload
};

// name 인자 추가 => 얘도 부모에 같이 던지기
const updateNameee = function (name) {
  console.log(name);
  emit("updateName", name); // updateName 요청 날리기
};
</script>

<style lang="scss" scoped></style>
