import { Bar } from "vue-chartjs";
import http from "@/util/http-common";

export default {
  extends: Bar,
  data() {
    return {
      items: [],
    };
  },

  mounted() {
    // Overwriting base render method with actual data.
    console.log("chart1 mounted data 받아옴");
    http
      .get(`/situation`)
      .then(({ data }) => {
        if (data != null) {
          this.$store.state.situations = data;
          this.items = data;
          this.makegraph();
        } else {
          alert(" 실패했습니다.");
        }
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    makegraph() {
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
              this.items[2][0].count,
              this.items[2][1].count,
              this.items[2][2].count,
              this.items[2][3].count,
              this.items[2][4].count,
              this.items[2][5].count,
              this.items[2][6].count,
              this.items[2][7].count,
              this.items[2][8].count,
              this.items[2][9].count,
              this.items[2][10].count,
              this.items[2][11].count,
            ],
          },
        ],
      });
    },
  },
};
