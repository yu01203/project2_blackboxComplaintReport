<template>
  <b-col cols="4">
    <div>
      <div
        v-b-modal="modalId(violationitem.violationNo)"
        variant="info"
        style="width: 100%;"
        class="shadow mb-4 bg-white rounded p-1"
      >
        <div class="mx-auto" no-body style="max-width: 20rem;">
          <div style="pointer-events: none">
            <video style="width:100%">
              <source :src="violationitem.videoUrl" type="video/mp4" />
            </video>
          </div>

          <b-list-group flush>
            <b-list-group-item class="mt-1 p-0" @click="clickPrevent">
              <b-form-select
                v-model="selected1"
                :options="options1"
                :class="classes"
                value-field="item"
                text-field="name"
                disabled-field="notEnabled"
                style="width:100% "
              ></b-form-select>
            </b-list-group-item>
            <div class="d-flex justify-content-between text-secondary">
              <p class="mb-0">{{ date }} {{ time }}</p>
            </div>
            <div>
              <p class="mb-0" style="font-size: 18px">{{ violationitem.address }}</p>
            </div>
          </b-list-group>
          <CaseModal :violationitem="violationitem" :date="date" :time="time" />
        </div>
      </div>
    </div>
  </b-col>
</template>

<script>
import { mapGetters } from "vuex";
import moment from "moment";

import CaseModal from "@/components/case/CaseModal.vue";

export default {
  name: "Case",
  components: {
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
      classes: "",
      date: "",
      time: "",
    };
  },
  mounted: function () {
    this.getFormatDate(this.violationitem);
    this.dummyColor();
    this.changeColor();
    this.DateTransform();
  },
  updated() {
    this.changeColor();
  },
  methods: {
    modalId(i) {
      return "modal" + i;
    },
    indexPlus(i) {
      return (i = ++i);
    },
    getFormatDate(violationitem) {
      return moment(new Date(violationitem.date)).format("YYYY.MM.DD");
    },
    // Function for a test
    dummyColor() {
      if (this.violationitem.violationNo % 2 == 0) {
        this.selected1 = "신고 미접수";
      } else if (this.violationitem.violationNo % 2) {
        this.selected1 = "접수 완료";
      }
      if (this.violationitem.violationNo > 7) {
        this.selected1 = "처리 완료";
      }
    },
    changeColor() {
      var selected = this.selected1;
      if (selected == "신고 미접수") {
        this.classes = "bg-secondary text-light";
      } else if (selected == "접수 완료") {
        this.classes = "bg-primary text-white";
      } else if (selected == "처리 완료") {
        this.classes = "bg-success text-white";
      }
    },
    clickPrevent(event) {
      event.stopPropagation();
    },
    DateTransform() {
      var date =
        this.violationitem.date.slice(0, 4) +
        "년 " +
        this.violationitem.date.slice(5, 7) +
        "월 " +
        this.violationitem.date.slice(8, 10) +
        "일 ";
      var time =
        this.violationitem.time.slice(0, 2) +
        "시 " +
        this.violationitem.time.slice(3, 5) +
        "분";
      this.date = date;
      this.time = time;
    },
  },
  computed: {
    ...mapGetters(["violationitems"]),
  },
};
</script>

<style>
</style>