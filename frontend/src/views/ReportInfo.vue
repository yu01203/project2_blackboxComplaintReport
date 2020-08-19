<template>
  <div class="container">
    <div v-if="this.$session.get('email') == null">
      <br />
      <h1 class="text-center mb-3">전체 유저 제보현황</h1>
      <b-container class="bv-example-row bv-example-row-flex-cols">
        <b-row align-v="stretch">
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
            <h2 class="text-center">신고 미접수 현황</h2>
            <Chart1 />
          </b-col>
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
            <h2 class="text-center">접수완료 현황</h2>
            <Chart2 />
          </b-col>
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
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
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
            <h2 class="text-center">신고 미접수 현황</h2>
            <ChartPersonal1 />
          </b-col>
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
            <h2 class="text-center">접수완료 현황</h2>
            <ChartPersonal2 />
          </b-col>
          <b-col class="mx-auto mb-3 col-12 col-md-4" style="max-width: 25rem;">
            <h2 class="text-center">처리완료 현황</h2>
            <ChartPersonal3 />
          </b-col>
        </b-row>
      </b-container>
    </div>
  </div>
</template>


<script>
import Chart1 from "@/components/charts/chart1";
import Chart2 from "@/components/charts/chart2";
import Chart3 from "@/components/charts/chart3";
import ChartPersonal1 from "@/components/charts/chartpersonal1";
import ChartPersonal2 from "@/components/charts/chartpersonal2";
import ChartPersonal3 from "@/components/charts/chartpersonal3";

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
};
</script>

<style></style>
