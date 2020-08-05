<template>
  <div>
    <br />
    <h1 class="text-center mb-3">공지사항</h1>
    <div v-if="this.$session.get('email') == 'admin'">
      <router-link to="/noticeWrite" class="nav-link" align="right"
        >글쓰기</router-link
      >
    </div>
    <b-table
      bordered
      outlined
      hover
      :items="noticeitems"
      :fields="fields"
      @row-clicked="rowClicked"
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
  methods: {
    //rowClicked(item, index) {
    rowClicked(item) {
      //alert("Index: " + index + "\n\nItem: " + JSON.stringify(item) + item.articleno + " " + index); //너무 힘들게 찾음 ㅡㅡ

      this.$session.set("notice_no", item.notice_no);
      this.$session.set("notice_id", item.notice_id);
      this.$session.set("notice_title", item.notice_title);
      this.$session.set("notice_content", item.notice_content);
      this.$router.push("/noticeDetail");
    },
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
