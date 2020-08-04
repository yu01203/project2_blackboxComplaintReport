import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    violationitems: [],
    violationitem: {},
    noticeitems: [],
    noticeitem: {},
  },
  getters: {
    violationitems(state) {
      return state.violationitems;
    },
    violationitem(state) {
      return state.violationitem;
    },
    noticeitems(state) {
      return state.noticeitems;
    },
    noticeitem(state) {
      return state.noticeitem;
    },
  },
  mutations: {
    setViolations(state, payload) {
      state.violationitems = payload;
    },
    setViolation(state, payload) {
      state.violationitem = payload;
    },
    setNotices(state, payload) {
      state.noticeitems = payload;
    },
    setNotice(state, payload) {
      state.noticeitem = payload;
    },
  },
  actions: {
    getViolations(context) {
      http
        .get(`/violation/1`)
        .then(({ data }) => {
          context.commit("setViolations", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getViolation(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit("setViolations", data);
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
