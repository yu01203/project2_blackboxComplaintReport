import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home.vue";
import CaseList from "../views/CaseList.vue";
import ReportInfo from "../views/ReportInfo.vue";
import MapMain from "../views/MapMain.vue";
import NoticeBoard from "../views/NoticeBoard.vue";

import GeoTest from "../views/GeoTest.vue";

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
  {
    path: "/noticeboard",
    name: "NoticeBoard",
    component: NoticeBoard,
  },
  {
    path: "/geotest",
    name: "GeoTest",
    component: GeoTest,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
