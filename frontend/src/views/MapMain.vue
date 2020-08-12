<template>
  <div>
    <!-- <Map :items="this.items" /> -->
    <Map :items="this.$store.state.violationitems" />
  </div>
</template>

<script>
import http from "@/util/http-common";

import Map from "@/components/maps/KakaoMap.vue";
// import Map from "@/components/maps/NaverMap.vue";

export default {
  name: "MapMain",
  data() {
    return {
      // items: [],
    };
  },
  components: {
    Map,
  },
  created() {
    if (this.$session.get("email")) {
      http
        .get(`/violation/${this.$session.get("userNo")}`, {
          headers: {
            token: this.$session.get("token"),
          },
        })
        .then(({ data }) => {
          if (data) {
            // this.local_violationitems = data;
            // this.items = data;
            this.$store.state.violationitems = data;
            // alert("ㅔㅗ");
          } else {
            alert(" 실패했습니다.");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    }
    // else {
    //   alert("미로그인 사용자");
    // }
  },
};
</script>

<style></style>
