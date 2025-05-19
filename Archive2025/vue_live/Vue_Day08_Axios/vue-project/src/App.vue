<template>
  <div>
    <h2>youtubeView</h2>
    <YoutubeVideoSearch @search="search" />

    <hr />
    <YoutubeVideoDetail :video="selectedVideo" />
    <hr />
    <!-- search에서 받아온 데이터 동적으로 내려보내기 -->
    <YoutubeVideoList :videos="videos" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import YoutubeVideoSearch from "./components/YoutubeVideoSearch.vue";
import YoutubeVideoList from "./components/YoutubeVideoList.vue";
import YoutubeVideoDetail from "./components/YoutubeVideoDetail.vue";
const videos = ref([]); // 전체 가져온 배열
const selectedVideo = ref(null); // 클릭했을 때 넘길 새 비디오

const search = function (searchVideos) {
  videos.value = searchVideos;
};
</script>

<style lang="scss" scoped></style>
