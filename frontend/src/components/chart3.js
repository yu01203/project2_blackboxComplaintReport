import { Bar } from "vue-chartjs";
import { mapGetters } from "vuex";

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
          label: "처리 현황",
          backgroundColor: "#8888ff",
          data: [
            // this.$session.get("situations")[2][0].count,
            // this.$session.get("situations")[2][1].count,
            // this.$session.get("situations")[2][2].count,
            // this.$session.get("situations")[2][3].count,
            // this.$session.get("situations")[2][4].count,
            // this.$session.get("situations")[2][5].count,
            // this.$session.get("situations")[2][6].count,
            // this.$session.get("situations")[2][7].count,
            // this.$session.get("situations")[2][8].count,
            // this.$session.get("situations")[2][9].count,
            // this.$session.get("situations")[2][10].count,
            // this.$session.get("situations")[2][11].count,
          ],
        },
      ],
    });
  },
  computed: {
    ...mapGetters(["situationitems"]),
  },

  created() {
    this.$store.dispatch("getSituations");
    this.data = this.situationitems;
  },
};
