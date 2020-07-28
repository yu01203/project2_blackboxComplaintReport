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
//동영상 스트뤼밍
import VueCoreVideoPlayer from "vue-core-video-player";

Vue.use(vSelect);

Vue.use(BootstrapVue);

//로그인 복붙
Vue.use(VModal);
Vue.use(VueSession, sessionOptions);
//
Vue.use(VueCoreVideoPlayer);

Vue.config.productionTip = false;

var sessionOptions = {
  persist: true,
};

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
