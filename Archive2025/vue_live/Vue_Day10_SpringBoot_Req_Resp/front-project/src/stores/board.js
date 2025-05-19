/** @format */

import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const REST_API_URL = `http://localhost:8080/api-board/board`;

export const useBoardStore = defineStore("board", () => {
  const boardList = ref([]); //게시글 목록 관리

  const getBoardList = function () {
    axios
      .get(REST_API_URL)
      .then((response) => {
        // console.log(response.data);
        boardList.value = response.data;
      })
      .catch(() => {
        //필요시 작성
      });
  };

  const searchBoardList = function (searchInfo) {
    axios
      .get(REST_API_URL, {
        params: searchInfo,
      })
      .then((response) => {
        boardList.value = response.data;
      });
  };

  // 게시글 등록
  const createBoard = function (board) {
    axios({
      url: REST_API_URL,
      method: "POST",
      data: board,
    });
  };
  return { boardList, getBoardList, searchBoardList, createBoard };
});
