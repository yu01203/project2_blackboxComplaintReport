<template>
  <div class="container">
    <br />
    <h1 class="text-center mb-3">공지사항</h1>
    <!-- <div v-if="this.$session.get('email') == 'admin'" class="float-right mb-3"> -->
    <div v-if="this.$session.get('email') == 'admin'">
      <router-link to="/noticeWrite" class="btn btn-warning m-3">글쓰기</router-link>
    </div>
    <!-- <b-table
      id="noticeBoard"
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
    ></b-pagination>-->
    <div>
      <b-container class="bv-example-row">
        <b-row>
          <Notice
            v-for="noticeitem in this.$store.state.noticeitems"
            :key="noticeitem.noticeNo"
            :noticeitem="noticeitem"
            @click="rowClicked"
          />
        </b-row>
      </b-container>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

import Notice from "@/components/notice/Notice.vue";

export default {
  name: "NoticeBoard",
  components: {
    Notice,
  },
  data() {
    return {
      // perPage: 10,
      // currentPage: 1,
      // fields: [
      //   {
      //     key: "notice_no",
      //     label: "글 번호",
      //     sortable: true,
      //     tdClass: "notice_no",
      //   },
      //   {
      //     key: "notice_title",
      //     label: "제목",
      //     tdClass: "notice_title",
      //   },
      //   {
      //     key: "notice_date",
      //     label: "작성일자",
      //     tdClass: "notice_date",
      //   },
      //   {
      //     key: "notice_time",
      //     label: "작성시간",
      //     tdClass: "notice_time",
      //   },
      // ],
    };
  },
  // methods: {
  //   rowClicked() {
  //     this.$session.set("notice_no", this.noticeitem.notice_no);
  //     this.$session.set("notice_id", this.noticeitem.notice_id);
  //     this.$session.set("notice_title", this.noticeitem.notice_title);
  //     this.$session.set("notice_content", this.noticeitem.notice_content);
  //     this.$router.push("/noticeDetail");
  //   },
  // },
  computed: {
    // rows() {
    //   return this.noticeitems.length;
    // },
    ...mapGetters(["noticeitems"]),
  },

  created() {
    this.$store.dispatch("getNotices");
  },
};
</script>

<style>
/* #noticeBoard > thead {
  background: #17a2b8;
}

#noticeBoard > thead > tr > th > div {
  color: white;
  font-size: 120%;
  font-weight: normal;
} */

/* .page-item .page-link {
  color: red;
}

.page-item.active .page-link {
  background-color: red !important;
  border-color: red !important;
}

.notice_no {
  width: 150px;
}

.notice_date {
  width: 200px;
}

.notice_time {
  width: 200px;
} */
</style>