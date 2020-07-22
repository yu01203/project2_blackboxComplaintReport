<template>
  <div>
    <b-button v-b-modal.modal-1>회원가입</b-button>

    <b-modal id="modal-1" title="BootstrapVue" hide-header hide-footer>
      <p class="my-4">회원가입</p>

      <h5>
        ID :
        <input v-model="infoJoin.id" type="text" placeholder="이메일을 입력해주세요" />
      </h5>
      <br />
      <h5>
        PW :
        <input v-model="infoJoin.pw" type="text" />
      </h5>
      <br />
      <h5>
        PW 확인 :
        <input v-model="infoJoin.pw2" type="text" />
      </h5>
      <br />
      <h5>
        이름 :
        <input v-model="infoJoin.name" type="text" />
      </h5>
      <br />
      <h5>
        성별 :
        <input v-model="infoJoin.sex" type="checkbox" />남자
        <input v-model="infoJoin.sex" type="checkbox" />여자
      </h5>
      <br />
      <h5>
        생년월일 :
        <input v-model="infoJoin.birth" type="text" />
      </h5>
      <br />
      <h5>
        휴대전화 :
        <input v-model="infoJoin.phone_number" type="text" />
      </h5>
      <br />
      <button>취소</button> |
      <button @click="joinUs">회원가입</button>
    </b-modal>
  </div>
</template>

<script>
export default {
  name: "join",
  data() {
    return {
      infoJoin: {
        id: "",
        pw: "",
        pw2: "",
        name: "",
        sex: "",
        birth: "",
        phone_number: ""
      }
    };
  },
  methods: {
    joinUs() {
      // 이 정보를 백에 보내기?
      console.log(this.infoJoin);
    }
  }
};
</script>