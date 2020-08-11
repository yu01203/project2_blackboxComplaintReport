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
    situationitems: [],
    situationitem: {},
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
    situationitems(state) {
      return state.situationitems;
    },
    situationitem(state) {
      return state.situationitem;
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
    setSituations(state, payload) {
      state.situationitems = payload;
    },
    setSituation(state, payload) {
      state.situationitem = payload;
    },
  },
  actions: {
    getViolations(context) {
      // const userNo = this.$session.get("userNo");
      // console.log(userNo);
      // var userData = sessionStorage.getItem("vue-session-key");
      // console.log(this.$session.getAll());
      http
        // .get(`/violation/1`)
        // .get(`/violation/${this.$session.get("userNo")}`)
        .get(`/violation`)
        // .get(`/violation/${userNo}`)
        // .get(`/violation/${this.violationitem.userNo}`)
        .then(({ data }) => {
          context.commit("setViolations", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다-getViolations.");
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
    getSituations(context) {
      http
        .get("/situation")
        .then(({ data }) => {
          context.commit("setSituations", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getSituation(context, payload) {
      http.get(payload).then(({ data }) => {
        context.commit("setSituation", data);
      });
    },
  },
  modules: {},
});
