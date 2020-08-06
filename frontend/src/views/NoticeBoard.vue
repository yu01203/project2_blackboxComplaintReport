<template>
  <div>
    <br />
    <h1 class="text-center mb-0">공지사항</h1>
    <br />
    <div v-if="this.$session.get('email') == 'admin'" class="float-right mb-3">
      <router-link to="/noticeWrite" class="nav-link" align="right">
        <b-button class="float-left bg-info border-info">글쓰기</b-button>
      </router-link>
    </div>
    <b-table
      bordered
      outlined
      hover
      :items="noticeitems"
      :fields="fields"
      @row-clicked="rowClicked"
      :per-page="perPage"
      :current-page="currentPage"
    ></b-table>

    <b-pagination
      v-model="currentPage"
      pills
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
      align="center"
    ></b-pagination>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "NoticeBoard",
  data() {
    return {
      perPage: 10,
      currentPage: 1,
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

.page-item .page-link {
  color: #17a2b8;
}

.page-item.active .page-link {
  background-color: #17a2b8 !important;
  border-color: #17a2b8 !important;
}
</style>
