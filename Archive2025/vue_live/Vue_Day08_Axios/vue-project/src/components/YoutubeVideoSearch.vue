<template>
  <div>
    <h4>검색</h4>
    <input type="text" v-model="keyword" />
    <button @click="search">검색</button>
  </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";

// 1 keyword와 바인딩
const keyword = ref("");

// 3 이벤트 올려보내기
const emit = defineEmits(["search"]);

// 2 search 함수 만들기: youtube 검색 API rkwudhrl
const search = function () {
  const youtube_api = "https://www.googleapis.com/youtube/v3/search";
  axios({
    url: youtube_api,
    method: "get",
    // 매개변수들은: youtubeAPI 문서 확인하기
    params: {
      part: "snippet",
      maxResults: 10,
      q: keyword.value,
      type: "video",
      key: import.meta.env.VITE_YOUTUBE_API_KEY,
    },
  }).then((response) => {
    console.log(response.data);
    emit("search", response.data.items);
  });
};
</script>

<style lang="scss" scoped></style>
