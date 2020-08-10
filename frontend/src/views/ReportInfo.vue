<template>
  <div>
    <div v-if="this.$session.get('email') == null">
      <br />
      <h1 class="text-center mb-3">전체 유저 제보현황</h1>
      <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row align-v="stretch">
          <b-col>
            <h2 class="text-center">신고 미접수 현황</h2>
            <Chart1 />
          </b-col>
          <b-col>
            <h2 class="text-center">접수완료 현황</h2>
            <Chart2 />
          </b-col>
          <b-col>
            <h2 class="text-center">처리완료 현황</h2>
            <Chart3 />
          </b-col>
        </b-row>
      </b-container>
    </div>

    <div v-if="this.$session.get('email') != null">
      <br />
      <h1 class="text-center mb-3">개인 제보현황</h1>
      <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row align-v="stretch">
          <b-col>
            <h2 class="text-center">신고 미접수 현황</h2>
            <ChartPersonal1 />
          </b-col>
          <b-col>
            <h2 class="text-center">접수완료 현황</h2>
            <ChartPersonal2 />
          </b-col>
          <b-col>
            <h2 class="text-center">처리완료 현황</h2>
            <ChartPersonal3 />
          </b-col>
        </b-row>
      </b-container>
    </div>
  </div>
</template>


<script>
import Chart1 from "@/components/chart1";
import Chart2 from "@/components/chart2";
import Chart3 from "@/components/chart3";
import ChartPersonal1 from "@/components/chartpersonal1";
import ChartPersonal2 from "@/components/chartpersonal2";
import ChartPersonal3 from "@/components/chartpersonal3";
import http from "@/util/http-common";

export default {
  name: "ReportInfo",
  components: {
    Chart1,
    Chart2,
    Chart3,
    ChartPersonal1,
    ChartPersonal2,
    ChartPersonal3,
  },
  created() {
    if (this.$session.get("email") == null) {
      this.$store.dispatch("getSituations");
      if (this.$store.state.situationitems != null) {
        this.$session.set("situations", this.$store.state.situationitems);
      }
    } else {
      http
        .get(`/situation/${this.$session.get("userNo")}`)
        .then(({ data }) => {
          if (data != null) {
            this.$session.set("situation", data);
          } else {
            alert(" 실패했습니다.");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    }
    // alert(this.$session.get("situations")[0][0].count + " created");
  },
  // mounted() {
  //   if (this.$session.get("email") == null) {
  //     this.$store.dispatch("getSituations");
  //     if (this.$store.state.situationitems != null) {
  //       this.$session.set("situations", this.$store.state.situationitems);
  //     }
  //   } else {
  //     http
  //       .get(`/situation/${this.$session.get("userNo")}`)
  //       .then(({ data }) => {
  //         if (data != null) {
  //           this.$session.set("situation", data);
  //         } else {
  //           alert(" 실패했습니다.");
  //         }
  //       })
  //       .catch(() => {
  //         alert("에러가 발생했습니다.");
  //       });
  //   }
  //   alert(this.$session.get("situations")[0][0].count + " mounted");
  // },
  // updated() {
  //   if (this.$session.get("email") == null) {
  //     this.$store.dispatch("getSituations");
  //     if (this.$store.state.situationitems != null) {
  //       this.$session.set("situations", this.$store.state.situationitems);
  //     }
  //   } else {
  //     http
  //       .get(`/situation/${this.$session.get("userNo")}`)
  //       .then(({ data }) => {
  //         if (data != null) {
  //           this.$session.set("situation", data);
  //         } else {
  //           alert(" 실패했습니다.");
  //         }
  //       })
  //       .catch(() => {
  //         alert("에러가 발생했습니다.");
  //       });
  //   }
  // },
};
</script>

<style></style>
