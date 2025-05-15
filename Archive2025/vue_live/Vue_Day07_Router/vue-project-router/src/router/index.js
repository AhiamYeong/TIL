import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "@/views/AboutView.vue";
import UserView from "@/views/UserView.vue";
import LoginView from "@/views/LoginView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";
import BoardView from "@/views/BoardView.vue";

const isAuth = true; // 로그인 성공 가정

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // 2 Per-route Guard: beforeEnter
  // 로그인이 되어있는 상태라면 -> 로그인뷰 진입 막고 홈뷰 이동 필요
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/about",
      name: "about",
      component: AboutView,
    },
    {
      path: "/user/:id",
      name: "user",
      component: UserView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
      // board 아래 소속된 친구들 경로 적기 - board, 하위에
      children: [
        {
          path: "",
          name: "boardList",
          component: BoardList,
        },
        {
          path: "create",
          name: "boardCreate",
          component: BoardCreate,
        },
      ],
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("이미 로그인댐");
          return { name: "home" };
        }
      },
    },
  ],
});

// 1 Globally Guard: beforeEach
// router.beforeEach((to, from) => {
//   console.log(to);
//   console.log(from);

//   const isAuth = false; // 로그인 안 됐으면
//   if (!isAuth && to.name !== "login") {
//     console.log("로그인 필요");
//     return { name: "login" };
//   }
// });

export default router;
