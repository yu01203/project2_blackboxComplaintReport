<template>
  <div>
    <h1>공지사항</h1>
    <b-table striped hover :items="noticeitems" :fields="fields"></b-table>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "NoticeBoard",
  data() {
    return {
      fields: [
        {
          key: "notice_no",
          sortable: true,
        },
        {
          key: "notice_id",
          sortable: true,
        },
        {
          key: "notice_title",
          sortable: true,
        },
        {
          key: "notice_content",
          sortable: true,
        },
        {
          key: "notice_regtime",
          sortable: true,
          //   label: "Person age",
          //   variant: "danger",
        },
      ],
    };
  },
  computed: {
    rows() {
      return this.noticeitems.length;
    },
    ...mapGetters(["noticeitems"]),
  },

  created() {
    this.$store.dispatch("getNotices");
  },
};
</script>

<style>
</style>