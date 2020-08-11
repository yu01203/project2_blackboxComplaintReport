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
          data: [
            this.$session.get("situation")[1][0].count,
            this.$session.get("situation")[1][1].count,
            this.$session.get("situation")[1][2].count,
            this.$session.get("situation")[1][3].count,
            this.$session.get("situation")[1][4].count,
            this.$session.get("situation")[1][5].count,
            this.$session.get("situation")[1][6].count,
            this.$session.get("situation")[1][7].count,
            this.$session.get("situation")[1][8].count,
            this.$session.get("situation")[1][9].count,
            this.$session.get("situation")[1][10].count,
            this.$session.get("situation")[1][11].count,
          ],
        },
      ],
    });
  },
};