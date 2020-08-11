<template>
  <div>
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
    <div>
      <h1 v-if="local_violationitems.length != 0" class="text-center mb-3">제보목록 서치</h1>

      <input type="text" v-model="searchText" @keydown.enter="searchOnlist" />
      <b-container class="bv-example-row">
        <b-row>
          <Case
            v-for="violationitem in searchviolationitems"
            :key="violationitem.violationNo"
            :violationitem="violationitem"
          />
        </b-row>
      </b-container>
    </div>
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
      searchText: "",
      searchviolationitems: [],
    };
  },
  created() {
    http
      .get(`/violation/${this.$session.get("userNo")}`)
      .then(({ data }) => {
        if (data != null) {
          this.local_violationitems = data;
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
    searchOnlist() {
      const emptyItems = new Array();
      this.searchviolationitems = emptyItems;
      for (var i in this.local_violationitems) {
        console.log(this.local_violationitems[i]);
        if (
          this.local_violationitems[i].contents.indexOf(this.searchText) !=
            -1 ||
          this.local_violationitems[i].item.indexOf(this.searchText) != -1 ||
          this.local_violationitems[i].spot.indexOf(this.searchText) != -1 ||
          this.local_violationitems[i].carNum.indexOf(this.searchText) != -1 ||
          this.local_violationitems[i].address.indexOf(this.searchText) != -1
        ) {
          this.searchviolationitems.push(this.local_violationitems[i]);
        }
      }
    },
  },
};
</script>

<style></style>
