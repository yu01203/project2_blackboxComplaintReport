<template>
  <div>
    <br />
    <h1 v-if="this.$store.state.violationitems.length != 0" class="text-center mb-3">제보목록</h1>
    <b-container class="bv-example-row">
      <b-row>
        <Case
          v-for="violationitem in this.$store.state.violationitems.slice().reverse()"
          :key="violationitem.violationNo"
          :violationitem="violationitem"
        />
      </b-row>
    </b-container>
  </div>
</template>

<script>
import http from "@/util/http-common";

// 기존 폼
// import Case from "@/components/case/Case.vue";
// 유튜브 폼
import Case from "@/components/case/CaseTube.vue";

export default {
  name: "CaseList",
  components: {
    Case,
  },
  props: {},
  data() {
    return {
      // local_violationitems: [],
    };
  },
  created() {
    http
      .get(`/violation/${this.$session.get("userNo")}`)
      .then(({ data }) => {
        if (data != null) {
          // this.local_violationitems = data;
          this.$store.state.violationitems = data;
        } else {
          alert(" 실패했습니다.");
        }
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    getVio() {
      this.$store.dispatch("getViolations");
    },
  },
  computed: {},
};
</script>

<style></style>
