<template>
  <div>
    <h1 class="text-center mb-3">공지사항</h1>
    <b-table
      bordered
      outlined
      hover
      :items="noticeitems"
      :fields="fields"
    ></b-table>
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
          label: "글 번호",
          sortable: true,
        },
        {
          key: "notice_id",
          label: "작성자",
        },
        {
          key: "notice_title",
          label: "제목",
        },
        {
          key: "notice_content",
          label: "내용",
        },
        {
          key: "notice_regtime",
          label: "작성일자",
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
th {
  background: #17a2b8;
}

th > div {
  color: white;
  font-size: 120%;
  font-weight: normal;
}
</style>
