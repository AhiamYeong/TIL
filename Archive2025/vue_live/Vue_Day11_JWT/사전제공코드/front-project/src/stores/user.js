/** @format */

import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";

const REST_API_URL = `http://localhost:8080/api-user`;

// base64url 디코딩 함수 (한글 깨짐 방지)
function base64UrlDecode(str) {
  // base64url -> base64로 변환
  str = str.replace(/-/g, "+").replace(/_/g, "/");
  // 패딩 추가
  while (str.length % 4) {
    str += "=";
  }
  // 디코딩 (한글 지원)
  try {
    return decodeURIComponent(
      Array.prototype.map
        .call(
          atob(str),
          (c) => "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2)
        )
        .join("")
    );
  } catch (e) {
    return atob(str);
  }
}

export const userStore = defineStore("user", () => {
  const loginUser = ref(null);
  const userlogin = function (id, password) {
    axios
      .post(`${REST_API_URL}/login`, {
        id,
        password,
      })
      .then((Response) => {
        console.log(Response.data);

        // loginUser 이름ㅇㅔ 사람 이름 넘기기
        // 이렇게 갖고오면 한글 다깨지고 힘듬 그니깐 백 단에서 이름 주기가 젤 베스트
        const token = Response.data["access-token"].split(".");
        // token 3등분 / header, payload, data

        const payLoad = JSON.parse(base64UrlDecode(token[1]));
        const name = payLoad;
        console.log(name);
        // const name = JSON.parse(atob(token[1])); // 'name' 추출
        // console.log(name);

        // 이름 중간에 - 하이픈 들어가서 .으로 저장 뷸가능
        // access token 이름으로 저장
        sessionStorage.setItem("access-token", Response.data["access-token"]);
        router.push({ name: "boardList" });
      })
      .catch((err) => {
        console.log(err);
        router.push({ name: "home" });
      });
  };
  return { userlogin };
});
