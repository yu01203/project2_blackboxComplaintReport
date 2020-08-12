<template>
  <!-- <nav
    class="d-flex justify-content-around navbar navbar-light fixed-top border-bottom border-danger p-1"
    style="padding: 16px; background-color: #ffffff;"
  >-->
  <nav
    class="container navbar navbar-light fixed-top border-bottom p-1"
    style="padding: 16px; background-color: #ffffff;"
  >
    <!-- 1 -->
    <b-button v-b-toggle.sidebar-1 class="float-left bg-danger border-danger">MENU</b-button>
    <div v-if="this.$session.get('email') != null"></div>

    <!-- 2 -->
    <div class="text-center">
      <router-link to="/" style="text-decoration: none;">
        <!-- <h1 class="ft-bhs" style="margin: 0px;">분노의 민원</h1> -->
        <img
          src="@/assets/logos/Logo_1.png"
          alt="logo-image"
          style="width: 40%; margin-bottom: 10px;"
        />
      </router-link>
    </div>

    <!-- 3 -->
    <div>
      <div>
        <b-button
          v-if="this.$session.get('email') == null"
          v-b-modal.modal-1
          class="float-right bg-danger rounded border-danger"
          style="padding: 7px 13px;"
        >
          <div>
            <a style="color: white; text-decoration: none;">로그인</a>
          </div>
        </b-button>

        <div>
          <b-button
            v-if="this.$session.get('email') != null && !this.$session.get('isSNS')"
            v-b-modal.modal-memberInfo
            class="bg-danger rounded border-danger"
            style="padding: 7px 13px;"
          >
            <div>
              <a style="color: white; text-decoration: none;">회원정보</a>
            </div>
          </b-button>&nbsp;
          <b-button
            v-if="this.$session.get('email') != null"
            v-on:click="sessionDistroy"
            class="bg-danger rounded border-danger"
            style="padding: 7px 13px;"
          >
            <div>
              <a style="cursor: pointer; color: white; text-decoration: none;">로그아웃</a>
            </div>
          </b-button>
        </div>
      </div>

      <!-- 모달 -->
      <div>
        <!-- 로그인 -->
        <LoginModal />
        <!-- 이메일 찾기 -->
        <SearchEmail />
        <!-- 비밀번호 찾기 -->
        <SearchPassword />
        <!-- 회원가입 -->
        <SignUp />
        <!-- 회원정보 -->
        <MemberInfo />
      </div>
    </div>
  </nav>
</template>

<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";

import LoginModal from "@/components/layout/navs/LoginModal.vue";
import SearchEmail from "@/components/layout/navs/SearchEmail.vue";
import SearchPassword from "@/components/layout/navs/SearchPassword.vue";
import SignUp from "@/components/layout/navs/SignUp.vue";
import MemberInfo from "@/components/layout/navs/MemberInfo.vue";

export default {
  name: "NavBar",
  props: {
    type: { type: String },
  },
  components: {
    LoginModal,
    SearchEmail,
    SearchPassword,
    SignUp,
    MemberInfo,
  },
  data: function () {
    return {
      // 백엔드에서 필요로 하는 데이터
      email: this.$session.get("email"),
      pw: "", // 백엔드로 보낼 때 password 변수에 담아서 ex) password: this.pw
      pw_re: "",
      name: this.$session.get("name"),
      gender: this.$session.get("gender"),
      birth: this.$session.get("birth"),
      phone: this.$session.get("phone"),

      // 토큰 관리
      jwt: module.require("jsonwebtoken"),
      access_token: this.$route.query.token,
      redirectURI: "http://localhost:8399/ssafy/api/sns/login",
      state: 123,
      naverLoginURL:
        "https://nid.naver.com/oauth2.0/authorize?response_type=code",
    };
  },
  mounted: function () {
    // this.$store.dispatch("getViolations");
    // console.log("여기는 마운티드");
    // console.log(this.$session.get("email"));
    // console.log(this.$session.get("userNo"));
  },
  computed: {
    ...mapGetters(["violationitems"]),
  },
  methods: {
    // getVio() {
    //   this.$store.dispatch("getViolations");
    // },
    // 세션 삭제
    sessionDistroy() {
      if (this.access_token != null) {
        alert("네이버 로그아웃");
        http.post(`/sns/logout`).then(({ data }) => {
          if (data == "success") {
            alert("로그아웃 " + data);
            location.href = "http://localhost:8080/";
          }
        });
      }
      this.$session.destroy();
      this.jwt = "";
      this.access_token = "";
      this.email = "";
      this.pw = "";
      this.name = "";
      this.birth = "";
      this.phone = "";
      this.joindate = "";
      this.$router.push("/");
      this.$router.go();
    },
  },
};
</script>

<style>
/* 로그인 모달 */
#modal-1___BV_modal_header_ {
  padding: 16px 16px 16px 32px;
}
</style>
