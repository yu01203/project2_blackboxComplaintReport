import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    items: [],
    item: {},
    noticeitems: [],
    noticeitem: {},
  },
  getters: {
    items(state) {
      return state.items;
    },
    item(state) {
      return state.item;
    },
    noticeitems(state) {
      return state.noticeitems;
    },
    noticeitem(state) {
      return state.noticeitem;
    },
  },
  mutations: {
    setBoards(state, payload) {
      state.items = payload;
    },
    setBoard(state, payload) {
      state.item = payload;
    },
    setNotices(state, payload) {
      state.noticeitems = payload;
    },
    setNotice(state, payload) {
      state.noticeitem = payload;
    },
  },
  actions: {
    getBoards(context) {
      http
        .get("/member")
        .then(({ data }) => {
          context.commit("setBoards", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getBoard(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit("setBoard", data);
      });
    },
    getNotices(context) {
      http
        .get("/notice")
        .then(({ data }) => {
          context.commit("setNotices", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getNotice(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit("setNotice", data);
      });
    },
  },
  modules: {},
});
