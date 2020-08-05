import Vue from "vue";
import App from "./App.vue";
import router from "./router";

// 로그인 복붙하면서 import
import store from "./store";
import VModal from "vue-js-modal";
import VueSession from "vue-session";

// bootstrap
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
Vue.use(BootstrapVue);

// selectbox
import vSelect from "vselect-component";
Vue.use(vSelect);

// vue-player
import vuePlayer from "@algoz098/vue-player";
Vue.component(vuePlayer);

// session
import VueSessionStorage from "vue-sessionstorage";
Vue.use(VueSessionStorage);

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
