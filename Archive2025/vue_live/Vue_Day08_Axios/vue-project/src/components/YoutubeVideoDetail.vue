<template>
  <div>
    <h4>영상 자세히 보기</h4>
  </div>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  video: {
    type: Object,
  },
});

const videoURL = computed(() => {
  const videoId = props.video.id.videoId;
  // return 'https://videos'
});
</script>

<style lang="scss" scoped></style>
