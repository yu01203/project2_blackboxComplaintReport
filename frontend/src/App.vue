<template>
  <div>
    <nav
      class="d-flex justify-content-around navbar navbar-light"
      style="margin: 10px 0px"
    >
      <b-button v-b-toggle.sidebar-1>MENU</b-button>
      <h1 style="margin: 0px;">분노의 민원</h1>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <div v-if="this.$session.get('email') != null">
                <a v-b-modal.modal-memberInfo>회원정보</a>
              </div>
            </li>
            <li class="nav-item">
              <div>
                <div v-if="this.$session.get('email') == null">
                  <a v-b-modal.modal-1>로그인</a>
                </div>
                <div v-else-if="this.$session.get('email') != null">
                  <a v-on:click="sessionDistroy" style="cursor:pointer;"
                    >로그아웃</a
                  >
                </div>

                <b-modal id="modal-1" title="로그인" hide-footer>
                  <div class="modal-body">
                    <form @submit.prevent>
                      <div class="form-group">
                        <input
                          type="text"
                          class="form-control"
                          id="email"
                          ref="email"
                          placeholder="Email을 입력하세요"
                          v-model="email"
                        />
                      </div>
                      <div class="form-group">
                        <input
                          type="passward"
                          class="form-control"
                          id="pw"
                          ref="pw"
                          placeholder="PW를 입력하세요"
                          v-model="pw"
                        />
                      </div>
                      <div class="form-group">
                        <button
                          class="btn btn-primary btn-lg btn-block login-btn"
                          @click="checkHandlerLogin"
                        >
                          로그인
                        </button>
                      </div>
                    </form>
                  </div>

                  <b-button class="btn btn-primary" v-b-modal.modal-multi-1
                    >아이디 찾기</b-button
                  >
                  <b-button class="btn btn-primary" v-b-modal.modal-multi-2
                    >비밀번호 찾기</b-button
                  >
                  <b-button class="btn btn-primary" v-b-modal.modal-multi-3
                    >회원가입</b-button
                  >
                </b-modal>
                <b-modal id="modal-multi-1" title="아이디찾기" hide-footer>
                  <p class="my-2">아이디찾기</p>
                </b-modal>
                <b-modal id="modal-multi-2" title="비밀번호찾기" hide-footer>
                  <p class="my-2">비밀번호찾기</p>
                </b-modal>
                <b-modal id="modal-multi-3" title="회원가입" hide-footer>
                  <div class="modal-body">
                    <div class="form-group">
                      <label>이메일 :</label>
                      <input
                        type="text"
                        class="form-control"
                        id="email"
                        ref="email"
                        placeholder="email을 입력하세요"
                        v-model="email"
                      />
                    </div>
                    <div class="form-group">
                      <label>비밀번호 :</label>
                      <input
                        type="password"
                        class="form-control"
                        id="pw"
                        ref="pw"
                        placeholder="PW를 입력하세요"
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
                        placeholder="name을 입력하세요"
                        v-model="name"
                      />
                    </div>
                    <div class="form-group">
                      <label>핸드폰번호 :</label>
                      <input
                        type="text"
                        class="form-control"
                        id="phone"
                        ref="phone"
                        placeholder="phone을 입력하세요"
                        v-model="phone"
                      />
                    </div>
                    <div class="form-group">
                      <button
                        class="btn btn-primary btn-lg btn-block login-btn"
                        @click="checkHandlerInsert"
                      >
                        회원가입
                      </button>
                    </div>
                  </div>
                </b-modal>

                <b-modal id="modal-memberInfo" title="회원정보" hide-footer>
                  <div class="form-group">
                    <label>아이디 :</label>
                    <br />
                    <div v-text="this.$session.get('id')"></div>
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
                    <label>비밀번호 확인 :</label>
                    <input
                      type="password"
                      class="form-control"
                      id="pw_re"
                      ref="pw_re"
                      placeholder="비밀번호 한번 더 입력하세요"
                      v-model="pw_re"
                    />
                  </div>
                  <div class="form-group">
                    <label>이름 :</label>
                    <input
                      type="text"
                      class="form-control"
                      id="name"
                      ref="name"
                      placeholder="name을 입력하세요"
                      v-model="name"
                    />
                  </div>
                  <div class="form-group">
                    <label>이메일 :</label>
                    <input
                      type="text"
                      class="form-control"
                      id="email"
                      ref="email"
                      placeholder="email을 입력하세요"
                      v-model="email"
                    />
                  </div>
                  <div class="form-group">
                    <label>핸드폰번호 :</label>
                    <input
                      type="text"
                      class="form-control"
                      id="phone"
                      ref="phone"
                      placeholder="phone을 입력하세요"
                      v-model="phone"
                    />
                  </div>
                  <div class="form-group">
                    <button class="btn btn-primary" @click="checkHandlerModify">
                      회원정보수정
                    </button>
                  </div>
                  <div class="form-group">
                    <button class="btn btn-primary" @click="deleteHandler">
                      회원탈퇴
                    </button>
                  </div>
                </b-modal>
              </div>
            </li>
          </ul>
        </div>
      </nav>
    </nav>

    <b-sidebar id="sidebar-1" title="분노의 민원" shadow>
      <div id="sidebar-content" class="d-flex flex-column px-5 py-4">
        <p>
          <router-link to="/">Home</router-link>
        </p>
        <p>
          <router-link to="/thumbnail">제보목록</router-link>
        </p>
        <p>
          <router-link to="/status">교통 안전 현황</router-link>
        </p>
        <p>
          <router-link to="/map">지도로 보기</router-link>
        </p>
      </div>
    </b-sidebar>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "App",
  props: {
    type: { type: String },
  },
  data: function() {
    return {
      // 백엔드에서 필요로 하는 데이터
      email: this.$session.get("email"),
      pw: "", // 백엔드로 보낼 때 password 변수에 담아서 ex) password: this.pw
      pw_re: "",
      name: this.$session.get("name"),
      gender: this.$session.get("gender"),
      birth: this.$session.get("birth"),
      phone: this.$session.get("phone"),
    };
  },
  methods: {
    // 로그인
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
        .post(`/login`, {
          email: this.email,
          password: this.pw,
        })
        //.data({
        //})
        .then(({ data }) => {
          let msg = "로그인에 실패하였습니다.";
          if (data === "success") {
            msg = "로그인이 완료되었습니다.";
          }
          this.$router.push("/");
          alert(msg);
          this.$router.go();
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },

    // 회원가입
    checkHandlerInsert() {
      let err = true;
      let msg = "";
      !this.email &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.email.focus());
      err &&
        !this.pw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw.focus());
      err &&
        !this.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.gender &&
        ((msg = "성별을 입력해주세요"),
        (err = false),
        this.$refs.gender.focus());
      err &&
        !this.brith &&
        ((msg = "생년월일을 입력해주세요"),
        (err = false),
        this.$refs.brith.focus());
      err &&
        !this.phone &&
        ((msg = "핸드폰번호를 입력해주세요"),
        (err = false),
        this.$refs.phone.focus());

      if (!err) alert(msg);
      else this.insertHandler();
    },
    insertHandler() {
      http
        .post(``, {
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

    // 회원수정
    checkHandlerModify() {
      let err = true;
      let msg = "";
      !this.pw &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw.focus());
      err &&
        !this.pw_re &&
        ((msg = "재입력 비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pw_re.focus());
      err &&
        !this.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.email &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.email.focus());
      err &&
        !this.phone &&
        ((msg = "핸드폰번호를 입력해주세요"),
        (err = false),
        this.$refs.phone.focus());
      err &&
        this.pw != this.pw_re &&
        ((msg = "비밀번호와 재입력 비밀번호가 다릅니다."),
        (err = false),
        this.$refs.pw_re.focus());

      if (!err) alert(msg);
      else this.modifyHandler();
    },
    modifyHandler() {
      http
        .put(``, {
          email: this.$session.get("email"),
          password: this.pw,
          name: this.name,
          gender: this.gender,
          birth: this.birth,
          phone: this.phone,
        })
        .then(({ data }) => {
          // 여기서부터 코딩
          let msg = "회원수정에 실패하였습니다.";
          if (data === "success") {
            msg = "회원수정이 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },

    // 세션 삭제
    sessionDistroy() {
      this.$session.destroy();
      this.$router.go();
      this.email = "";
      this.pw = "";
      this.name = "";
      this.gender = "";
      this.birth = "";
      this.phone = "";
      this.joindate = "";
    },

    // 회원삭제
    deleteHandler() {
      http
        .delete(``)
        .then(({ data }) => {
          let msg = "회원삭제에 실패하였습니다..";
          if (data === "success") {
            msg = "회원삭제가 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
          this.$session.destroy();
          this.$router.go();
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
};
</script>

<style>
#sidebar-1 {
  padding: 10px;
}

#sidebar-content {
  padding: 10px;
}
</style>
