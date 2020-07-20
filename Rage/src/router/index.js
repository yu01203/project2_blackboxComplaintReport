import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Mapp from "../components/map.vue";
import Mypage from "../components/mypage.vue";
import Status from "../components/status.vue";
import Thumbnail from "../components/thumbnail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/map",
    name: "map",
    component: Mapp,
  },
  {
    path: "/mypage",
    name: "mypage",
    component: Mypage,
  },
  {
    path: "/status",
    name: "status",
    component: Status,
  },
  {
    path: "/thumbnail",
    name: "thumbnail",
    component: Thumbnail,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
