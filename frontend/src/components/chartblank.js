import { Bar } from "vue-chartjs";

export default {
  extends: Bar,
  mounted() {
    // Overwriting base render method with actual data.
    console.log("저는 chartblank에요");
    this.renderChart({
      labels: [
        "1월",
        "2월",
        "3월",
        "4월",
        "5월",
        "6월",
        "7월",
        "8월",
        "9월",
        "10월",
        "11월",
        "12월",
      ],
      datasets: [
        {
          label: "교통 사고 현황",
          backgroundColor: "#ff8888",
          data: [12, 5, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0],
        },
      ],
    });
  },
};
