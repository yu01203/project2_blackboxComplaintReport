<template>
  <b-modal id="modal-multi-3" title="회원가입" hide-footer>
    <div class="modal-body">
      <div class="form-group">
        <label>이메일 :</label>
        <div class="d-flex">
          <input
            type="text"
            class="form-control mr-3"
            id="email"
            ref="email"
            placeholder="이메일을 입력하세요"
            v-model="email"
          />
          <b-button
            id="checkbutton"
            class="border-danger"
            style="width: 30%; padding: 0px;"
            @click="validEmailCheck"
          >
            <span
              style="color: red; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
            >중</span>
            <span
              style="color: green; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
            >복</span>
            <span
              style="color: blue; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
            >확</span>
            <span
              style="color: purple; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
            >인</span>
          </b-button>
        </div>
      </div>
      <div class="form-group">
        <label>비밀번호 :</label>
        <input
          type="password"
          class="form-control"
          id="pw"
          ref="pw"
          placeholder="비밀번호를 입력하세요"
          v-model="pw"
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
        <input type="radio" id="one" value="남" v-model="gender" />
        <label for="one">남</label>
        <input type="radio" id="two" value="여" v-model="gender" />
        <label for="two">여</label>
        <!-- <input
                type="text"
                class="form-control"
                id="gender"
                ref="gender"
                placeholder="남 또는 여"
                v-model="gender"
        />-->
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
        <button
          id="signupbutton"
          class="btn btn-primary btn-lg btn-block login-btn"
          @click="checkHandlerInsert"
        >
          <span
            style="color: red; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
          >회</span>
          <span
            style="color: green; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
          >원</span>
          <span
            style="color: blue; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
          >가</span>
          <span
            style="color: purple; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;"
          >입</span>
        </button>
      </div>
    </div>
  </b-modal>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "SignUp",
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
      emailchecked: false,
    };
  },
  methods: {
    checkHandlerInsert() {
      let err = true;
      let msg = "";
      if (!this.validEmail(this.email)) {
        (msg = "이메일 형식을 지켜주세요."),
          (err = false),
          this.$refs.email.focus();
      } else if (this.pw.length <= 6) {
        (msg = "비밀번호를 7자 이상 입력해주세요."),
          (err = false),
          this.$refs.pw.focus();
      } else if (!this.validBirth(this.birth)) {
        (msg = "올바른 생년월일을 입력해주세요."),
          (err = false),
          this.$refs.birth.focus();
      } else if (this.gender == null) {
        alert("성별을 선택해 주세요.");
        (msg = "성별을 선택해 주세요."),
          (err = false),
          this.$refs.gender.focus();
      }
      err &&
        !this.phone &&
        ((msg = "핸드폰번호를 입력해주세요."),
        (err = false),
        this.$refs.phone.focus());
      err &&
        !this.name &&
        ((msg = "이름을 입력해주세요."),
        (err = false),
        this.$refs.name.focus());
      err &&
        !this.emailchecked &&
        ((msg = "이메일 중복 확인을 해주세요."),
        (err = false),
        this.$refs.checkbutton.focus());

      if (!err) alert(msg);
      else this.insertHandler();
    },
    insertHandler() {
      http
        .post(`/user`, {
          email: this.email,
          password: this.pw,
          name: this.name,
          gender: this.gender,
          birth: this.birth,
          phone: this.phone,
        })
        .then(({ data }) => {
          // 여기서부터 코딩
          let msg = "회원가입에 실패하였습니다.";
          if (data === "success") {
            msg = "회원가입이 완료되었습니다.";
            this.$router.push("/");
            this.$router.go();
          }
          alert(msg);
          this.$root.$emit("bv::hide::modal", "modal-multi-3");
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
      this.email = null;
      this.pw = null;
      this.name = null;
      this.gender = null;
      this.birth = null;
      this.phone = null;
    },
    validEmailCheck() {
      let err = true;
      let msg = "";
      if (!this.validEmail(this.email)) {
        (msg = "이메일 형식을 지켜주세요."),
          (err = false),
          this.$refs.email.focus();
      }
      if (!err) alert(msg);
      else this.emailCheck();
    },
    emailCheck() {
      http
        .get(`/user/${this.email}`)
        .then(({ data }) => {
          if (data) {
            alert("회원가입 가능한 이메일입니다.");
            this.emailchecked = true;
          } else {
            alert("이미 존재하는 이메일입니다.");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    validEmail(email) {
      var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
      return re.test(email);
    },
    validBirth(birth) {
      var re = /^\d{4}-\d{2}-\d{2}$/;
      return re.test(birth);
    },
  },
};
</script>

<style>
#checkbutton {
  background: linear-gradient(to bottom, #ff8888, white);
}

#signupbutton {
  background: linear-gradient(
    45deg,
    red,
    orange,
    yellow,
    green,
    blue,
    navy,
    purple
  );
}
</style>