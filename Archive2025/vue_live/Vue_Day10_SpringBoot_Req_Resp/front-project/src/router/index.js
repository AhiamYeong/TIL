import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/board",
      component: BoardView,
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
  ],
});

export default router;
