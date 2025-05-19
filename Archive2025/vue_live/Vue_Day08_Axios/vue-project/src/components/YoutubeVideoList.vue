<template>
  <div>
    <h4>검색된 비디오 목록</h4>
    <ul>
      <YoutubeVideoListItem
        v-for="video in videos"
        :key="video.id.videoId"
        :video="video"
        @click="clickVideo"
      />
    </ul>
  </div>
</template>

<script setup>
import YoutubeVideoListItem from "./YoutubeVideoListItem.vue";
defineProps({
  videos: {
    type: Array,
  },
});

const emit = defineEmits(["click"]);

const clickVideo = function (video) {
  console.log(video);
};
</script>

<style lang="scss" scoped></style>
