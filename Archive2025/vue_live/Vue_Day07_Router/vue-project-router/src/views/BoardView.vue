<template>
  <div>
    <h2>boardview</h2>

    <!-- <RouterLink to="/board">게시글 목록</RouterLink>
    <RouterLink to="/board/create">게시글 등록</RouterLink> -->
    <RouterLink :to="{ name: 'boardList' }">게시글 목록</RouterLink>
    <RouterLink :to="{ name: 'boardCreate' }">게시글 등록</RouterLink>

    <RouterView />
  </div>
</template>

<script setup></script>

<style lang="scss" scoped></style>
