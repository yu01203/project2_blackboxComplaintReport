import { Bar } from "vue-chartjs";

export default {
  extends: Bar,
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
          label: "교통 사고 현황",
          backgroundColor: "#ff8888",
          data: [
            this.$session.get("situation")[0][0].count,
            this.$session.get("situation")[0][1].count,
            this.$session.get("situation")[0][2].count,
            this.$session.get("situation")[0][3].count,
            this.$session.get("situation")[0][4].count,
            this.$session.get("situation")[0][5].count,
            this.$session.get("situation")[0][6].count,
            this.$session.get("situation")[0][7].count,
            this.$session.get("situation")[0][8].count,
            this.$session.get("situation")[0][9].count,
            this.$session.get("situation")[0][10].count,
            this.$session.get("situation")[0][11].count,
          ],
        },
      ],
    });
  },
  // created() {
  //   // Overwriting base render method with actual data.
  //   this.renderChart({
  //     labels: [
  //       "1월",
  //       "2월",
  //       "3월",
  //       "4월",
  //       "5월",
  //       "6월",
  //       "7월",
  //       "8월",
  //       "9월",
  //       "10월",
  //       "11월",
  //       "12월",
  //     ],
  //     datasets: [
  //       {
  //         label: "교통 사고 현황",
  //         backgroundColor: "#ff8888",
  //         data: [
  //           this.$session.get("situations")[0][0].count,
  //           this.$session.get("situations")[0][1].count,
  //           this.$session.get("situations")[0][2].count,
  //           this.$session.get("situations")[0][3].count,
  //           this.$session.get("situations")[0][4].count,
  //           this.$session.get("situations")[0][5].count,
  //           this.$session.get("situations")[0][6].count,
  //           this.$session.get("situations")[0][7].count,
  //           this.$session.get("situations")[0][8].count,
  //           this.$session.get("situations")[0][9].count,
  //           this.$session.get("situations")[0][10].count,
  //           this.$session.get("situations")[0][11].count,
  //         ],
  //       },
  //     ],
  //   });
  // },
  // updated() {
  //   // Overwriting base render method with actual data.
  //   this.renderChart({
  //     labels: [
  //       "1월",
  //       "2월",
  //       "3월",
  //       "4월",
  //       "5월",
  //       "6월",
  //       "7월",
  //       "8월",
  //       "9월",
  //       "10월",
  //       "11월",
  //       "12월",
  //     ],
  //     datasets: [
  //       {
  //         label: "교통 사고 현황",
  //         backgroundColor: "#ff8888",
  //         data: [
  //           this.$session.get("situations")[0][0].count,
  //           this.$session.get("situations")[0][1].count,
  //           this.$session.get("situations")[0][2].count,
  //           this.$session.get("situations")[0][3].count,
  //           this.$session.get("situations")[0][4].count,
  //           this.$session.get("situations")[0][5].count,
  //           this.$session.get("situations")[0][6].count,
  //           this.$session.get("situations")[0][7].count,
  //           this.$session.get("situations")[0][8].count,
  //           this.$session.get("situations")[0][9].count,
  //           this.$session.get("situations")[0][10].count,
  //           this.$session.get("situations")[0][11].count,
  //         ],
  //       },
  //     ],
  //   });
  // },
};
