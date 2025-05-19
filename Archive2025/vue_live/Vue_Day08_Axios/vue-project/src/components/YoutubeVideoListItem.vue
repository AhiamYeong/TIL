<template>
  <div>
    <li @click="clickVideo">
      <h4>아이템</h4>
      <div>{{ video.snippet.title }}</div>
      <div>{{ videoTitle }}</div>
    </li>
  </div>
</template>

<script setup>
import _ from "lodash";
import { computed } from "vue";
const props = defineProps({
  video: {
    type: Object,
  },
});

const videoTitle = computed(() => {
  return _.unescape(props.video.snippet.title);
});

const emit = defineEmits(["click"]);
const clickVideo = function () {
  emit("click", props.video);
};
</script>

<style lang="scss" scoped></style>
