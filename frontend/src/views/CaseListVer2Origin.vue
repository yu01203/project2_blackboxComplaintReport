<template>
  <div>
    <h1 v-if="local_violationitems.length != 0" class="text-center mb-3">제보목록</h1>
    <b-container class="bv-example-row">
      <b-row>
        <Case
          v-for="violationitem in local_violationitems"
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
      local_violationitems: [],
    };
  },
  created() {
    http
      .get(`/violation/${this.$session.get("userNo")}`)
      .then(({ data }) => {
        if (data != null) {
          this.local_violationitems = data;
          // this.$store.state.violationitems = data;
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
};
</script>

<style></style>
