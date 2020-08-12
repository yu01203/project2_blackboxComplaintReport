<template>
  <b-modal id="modal-multi-2" title="비밀번호 찾기" hide-footer>
    <div class="modal-body">
      <div class="form-group">
        <label>이메일 :</label>
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
        <label>이름 :</label>
        <input
          type="text"
          class="form-control"
          id="name"
          ref="name"
          placeholder="이름을 입력하세요"
          v-model="name"
        />
      </div>
      <div class="form-group">
        <label>성별 :</label>
        <input
          type="text"
          class="form-control"
          id="gender"
          ref="gender"
          placeholder="남 또는 여"
          v-model="gender"
        />
      </div>
      <div class="form-group">
        <label>생년월일 :</label>
        <input
          type="text"
          class="form-control"
          id="birth"
          ref="birth"
          placeholder="2020-01-01"
          v-model="birth"
        />
      </div>
      <div class="form-group">
        <label>핸드폰 번호 :</label>
        <input
          type="text"
          class="form-control"
          id="phone"
          ref="phone"
          placeholder="핸드폰 번호를 입력하세요"
          v-model="phone"
        />
      </div>
      <div class="form-group">
        <button class="btn btn-primary btn-lg btn-block login-btn" @click="findPassword">비밀번호 찾기</button>
      </div>
    </div>
  </b-modal>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "SearchPassword",
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
  methods: {
    findPassword() {
      http
        .post(`/user/findPassword`, {
          email: this.email,
          name: this.name,
          gender: this.gender,
          birth: this.birth,
          phone: this.phone,
        })
        .then(({ data }) => {
          if (data == "fail") {
            alert("잘못된 정보입니다.");
          }
          if (data != "fail") {
            alert(
              "임시 비밀번호 입니다. 로그인 후 비밀번호를 수정해 주세요." + data
            );
            this.$root.$emit("bv::hide::modal", "modal-multi-2");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
};
</script>

<style>
</style>