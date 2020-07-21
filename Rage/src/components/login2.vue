<template>
  <div>
    <b-button v-b-modal.modal-1>회원가입</b-button>

    <b-modal id="modal-1" title="BootstrapVue">
      <p class="my-4">회원가입</p>
      <form action>
        <input type="id(e-mail)" />
        <br />
        <input type="pw" />
        <br />
        <input type="pw2" />
        <br />
        <input type="name" />
        <br />
        <input type="sex" />
        <br />
        <input type="birth" />
        <br />
        <input type="phone_number" />
        <br />
      </form>
    </b-modal>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",

    };
  },
  methods: {
  }
</script>