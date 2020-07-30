import { Line } from "vue-chartjs";

export default {
  extends: Line,
  mounted() {
    // Overwriting base render method with actual data.
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
          label: "신고 현황",
          backgroundColor: "#ffff88",
          data: [28, 20, 15, 32, 20, 40, 18, 45, 40, 20, 12, 20],
        },
      ],
    });
  },
};
