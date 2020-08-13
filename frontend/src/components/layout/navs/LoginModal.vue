<template>
  <b-modal id="modal-1" title="로그인" style="padding: 16px 32px;" hide-footer>
    <div class="modal-body">
      <form @submit.prevent>
        <div class="form-group">
          <input
            type="text"
            class="form-control"
            id="email"
            ref="email"
            placeholder="이메일을 입력하세요"
            v-model="email"
          />
        </div>
        <div class="form-group">
          <input
            @keypress.enter="checkHandlerLogin"
            type="password"
            class="form-control"
            id="pw"
            ref="pw"
            placeholder="비밀번호를 입력하세요"
            v-model="pw"
          />
        </div>
        <div class="form-group">
          <!-- 로그인 버튼 -->
          <a
            class="btn btn-primary text-decoration-none m-auto"
            @click="checkHandlerLogin"
            style="width: 100%; height: 50px;"
          >
            <p style="color: white; font-size: 20px; margin-top: 4px;">로그인</p>
          </a>
          <br />
          <hr />
          <!-- 네이버 로그인 버튼 -->
          <div class="text-center">
            <img
              @click="naverLogin"
              width="60%"
              style="cursor: pointer;"
              src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"
            />
          </div>
        </div>
      </form>
    </div>

    <div class="d-flex justify-content-around">
      <b-button class="btn btn-primary" v-b-modal.modal-multi-1>이메일 찾기</b-button>
      <b-button class="btn btn-primary" v-b-modal.modal-multi-2>비밀번호 찾기</b-button>
      <b-button class="btn btn-primary" v-b-modal.modal-multi-3 style="margin: 0px 10px;">회원가입</b-button>
    </div>
  </b-modal>
</template>

<script>
import http from "@/util/http-common";

var CLIENT_ID = process.env.VUE_APP_NAVER_CLIENT_ID;

export default {
  name: "LoginModal",

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

  created() {
    // 네이버 로그인
    if (this.access_token != null) {
      this.$session.set("userNo", this.jwt.decode(this.access_token).userNo);
      this.$session.set("email", this.jwt.decode(this.access_token).email);
      this.$session.set("name", this.jwt.decode(this.access_token).name);
      this.$session.set("gender", this.jwt.decode(this.access_token).gender);
      this.$session.set("birth", this.jwt.decode(this.access_token).birth);
      this.$session.set("token", this.access_token);
    }
  },
  methods: {
    checkHandlerLogin() {
      let err = true;
      let msg = "";
      !this.email && ((msg = "아이디를 입력해주세요"), (err = false)),
        this.$refs.email.focus();
      err && !this.pw && ((msg = "비밀번호를 입력해주세요"), (err = false)),
        this.$refs.pw.focus();

      console.log(this.email + " " + this.pw);
      if (!err) alert(msg);
      else this.loginHandler();
    },
    loginHandler() {
      http
        .post(`/user/login`, {
          email: this.email,
          password: this.pw,
        })
        .then(({ data }) => {
          // JSON 형태
          let msg = "로그인에 실패하였습니다.";

          if (data.success === "success") {
            msg = "로그인이 완료되었습니다.";
            //alert(data.userinfo.userNo);
            this.$session.set("email", this.email);
            this.$session.set("userNo", data.userinfo.userNo);
            this.$session.set("name", data.userinfo.name);
            this.$session.set("gender", data.userinfo.gender);
            this.$session.set("birth", data.userinfo.birth);
            this.$session.set("phone", data.userinfo.phone);
            this.$session.set("token", data.token);
            // sessionStorage.setItem("vue-session-key", "this.email");
            // sessionStorage.setItem("vue-session-key", "data.userinfo.userNo");

            // this.$store.dispatch("getViolations");
            // console.log("로그인 데이터");
            // console.log(this.$session.get("email"));
            console.log(this.$session.get("name"));
            this.$router.push("/");
            this.$router.go();
          }
          alert(msg);
          // this.getVio();
        })
        .catch(() => {
          alert("에러가 발생했습니다-login.");
        });
    },
    naverLogin() {
      // this.naverLoginURL += "&client_id=" + this.CLIENT_ID;
      this.naverLoginURL += "&client_id=" + CLIENT_ID;
      this.naverLoginURL += "&redirect_uri=" + this.redirectURI;
      this.naverLoginURL += "&state=" + this.state;

      location.href = this.naverLoginURL;
    },
  },
};
</script>

<style>
</style>