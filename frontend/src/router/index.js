import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home.vue";
import CaseList from "../views/CaseList.vue";
import ReportInfo from "../views/ReportInfo.vue";
import MapMain from "../views/MapMain.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/caselist",
    name: "CaseList",
    component: CaseList,
  },
  {
    path: "/reportinfo",
    name: "ReportInfo",
    component: ReportInfo,
  },
  {
    path: "/mapmain",
    name: "MapMain",
    component: MapMain,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
