/** @format */

import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_API_URL = `http://localhost:8080/api-board/board`;

export const useBoardStore = defineStore("board", () => {
  const boardList = ref([]); //게시글 목록 관리
  const board = ref({}); //상세게시글 정보

  const getBoardList = function () {
    axios
      .get(REST_API_URL, {
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
      .then((response) => {
        // console.log(response.data);
        boardList.value = response.data;
      })
      .catch(() => {
        //필요시 작성
      });
  };

  //게시글 검색 조회
  const searchBoardList = function (searchInfo) {
    axios
      .get(REST_API_URL, {
        params: searchInfo,
      })
      .then((response) => {
        boardList.value = response.data;
      });
  };

  //게시글 등록
  const createBoard = function (board) {
    // axios.post()
    axios({
      url: REST_API_URL,
      method: "POST",
      data: board,
      //Content-type : 지정하지 않았는데 application/json 날아가더라!
    })
      .then((res) => {
        console.log("게시글 등록 완료!");
        router.push({ name: "boardList" });
        // return "완료했대";
      })
      .catch(() => {
        console.log("게시글 등록 실패");
      });
  };

  //게시글 상세 조회
  const getBoard = function (id) {
    axios
      .get(`${REST_API_URL}/${id}`)
      .then((response) => {
        board.value = response.data;
        // console.log(response.data);
      })
      .catch(() => {
        console.log("이슈발생");
        //에러페이지로 router를 바꿔라!
      });
  };

  //게시글 수정
  const updateBoard = function () {
    axios
      .put(REST_API_URL, board.value)
      .then(() => {
        //정상 수정 후
        router.push({ name: "boardList" });
      })
      .catch(() => {
        //비정상 수정 후
      });
  };

  return {
    boardList,
    board,
    getBoardList,
    searchBoardList,
    createBoard,
    getBoard,
    updateBoard,
  };
});
