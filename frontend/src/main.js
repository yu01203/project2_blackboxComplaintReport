import Vue from "vue";
import App from "./App.vue";
import router from "./router";
// 로그인 복붙하면서 import
import store from "./store";
import VModal from "vue-js-modal";
import VueSession from "vue-session";
//
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
// selectbox
import vSelect from "vselect-component";
//사라져라 vue video 제발
Vue.use(vSelect);

Vue.use(BootstrapVue);

//로그인 복붙
Vue.use(VModal);
Vue.use(VueSession, sessionOptions);

Vue.config.productionTip = false;

var sessionOptions = {
  persist: true,
};

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
