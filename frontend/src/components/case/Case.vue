<template>
  <b-col cols="4">
    <div>
      <b-card class="mb-3" no-body style="max-width: 20rem;">
        <vue-player
          src="http://d1xevv8xa9hsha.cloudfront.net/abcd.mp4"
          poster="https://via.placeholder.com/150"
          title="this is a title"
        ></vue-player>
        <template v-slot:header>
          <h4 class="mb-0 text-center">위반 항목</h4>
        </template>

        <b-list-group flush>
          <b-list-group-item>
            <div class="mb-3">
              상태 :
              <strong>{{ selected1 }}</strong>
            </div>
            <b-form-select
              v-model="selected1"
              :options="options1"
              class="mb-0"
              value-field="item"
              text-field="name"
              disabled-field="notEnabled"
            ></b-form-select>
          </b-list-group-item>
          <b-list-group-item>위반일자 : {{ violationitem.date }}</b-list-group-item>
          <b-list-group-item>위반시간 : {{ violationitem.time }}</b-list-group-item>
          <b-list-group-item>위반위치 : {{ violationitem.address }}</b-list-group-item>
        </b-list-group>

        <b-card-body>
          <div class="text-center">
            <b-button
              v-b-modal="modalId(violationitem.violationNo)"
              variant="info"
              style="width: 100%;"
              :tempNum="violationitem.violationNo"
            >상세보기 및 신고하기</b-button>
            <!-- 모달 -->
            <CaseModal :violationitem="violationitem" />
          </div>
        </b-card-body>
      </b-card>
    </div>
  </b-col>
</template>

<script>
import vuePlayer from "@algoz098/vue-player";
import moment from "moment";
import { mapGetters } from "vuex";

import CaseModal from "@/components/case/CaseModal.vue";

export default {
  name: "Case",
  components: {
    vuePlayer,
    CaseModal,
  },
  props: {
    violationitem: {
      type: Object,
    },
  },
  data() {
    return {
      selected1: "신고 미접수",
      options1: [
        { item: "신고 미접수", name: "신고 미접수" },
        { item: "접수 완료", name: "접수 완료" },
        { item: "처리 완료", name: "처리 완료" },
      ],
    };
  },
  mounted: function () {
    this.getFormatDate();
  },
  computed: {
    ...mapGetters(["violationitems"]),
  },
  methods: {
    modalId(i) {
      return "modal" + i;
    },
    getFormatDate(violationitems) {
      return moment(new Date(violationitems)).format("YYYY.MM.DD HH:mm:ss");
    },
  },
};
</script>

<style>
</style>