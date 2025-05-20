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


export const useUserStore = defineStore("user", () => {

  const loginUser = ref(null)
  const userLogin = function(id, password){
    axios.post(`${REST_API_URL}/login`,{
      id,
      password
    })
    .then((response)=>{
      console.log(response.data)
      //loginUser 변수에는 사람의 이름을 넣겠다!
      //-> 부트에서 이름을 같이 응답에 넣어서 저장하면 끝
      const token = response.data["access-token"].split(".")
      console.log(token)

      const payload = JSON.parse(base64UrlDecode(token[1]))
      const name = payload["name"]

      console.log(name)
      //이렇게 가져오면.... 한글 다 깨져~~
      // const name = JSON.parse(atob(token[1]))["name"]
      // console.log(name)
      sessionStorage.setItem("access-token", response.data["access-token"]) 

      loginUser.value = name



      router.push({name:"boardList"})
    })
    .catch((err)=>{
      console.log(err)
      router.push({name: "home"})
    })
  }
  return { loginUser, userLogin };
});
