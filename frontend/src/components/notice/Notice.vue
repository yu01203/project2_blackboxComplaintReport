<template>
  <b-col cols="12" md="6" lg="4">
    <div>
      <b-card class="shadow mb-4 bg-white rounded p-1" style="width: 100%;" @click="rowClicked">
        <b-card-body>
          <p>{{ noticeitem.notice_title }}</p>
          <p>{{ noticeitem.notice_date }}</p>
        </b-card-body>
      </b-card>
    </div>
  </b-col>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Notice",
  props: {
    noticeitem: {
      type: Object,
    },
  },
  methods: {
    rowClicked() {
      this.$session.set("notice_no", this.noticeitem.notice_no);
      this.$session.set("notice_id", this.noticeitem.notice_id);
      this.$session.set("notice_title", this.noticeitem.notice_title);
      this.$session.set("notice_content", this.noticeitem.notice_content);
      this.$router.push("/noticeDetail");
    },
  },
  computed: {
    ...mapGetters(["noticeitems"]),
  },
};
</script>

<style>
</style>