<template>
  <div>
    <h1>제보현황</h1>
    <b-container class="bv-example-row bv-example-row-flex-cols">
      <b-row align-v="stretch">
        <b-col>
          <h2>교통 사고 현황</h2>
          <Chart1 />
        </b-col>
        <b-col>
          <h2>분노의 민원 신고 현황</h2>
          <Chart2 />
        </b-col>
        <b-col>
          <h2>분노의 민원 처리 현황</h2>
          <Chart3 />
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import Chart1 from "@/components/chart1";
import Chart2 from "@/components/chart2";
import Chart3 from "@/components/chart3";

export default {
  name: "ReportInfo",
  components: {
    Chart1,
    Chart2,
    Chart3,
  },
};
</script>

<style></style>
