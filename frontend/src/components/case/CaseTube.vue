<template>
  <b-col cols="4">
    <div>
      <div variant="info" style="width: 100%;" class="shadow p-3 mb-4 bg-white rounded">
        <div class="m-0" no-body style="max-width: 20rem;">
          <vue-player :src="violationitem.videoUrl" poster="https://via.placeholder.com/150" title></vue-player>
          <b-list-group flush>
            <a href="javascript:void(0)">
              <b-list-group-item>
                <b-form-select
                  v-model="selected1"
                  :options="options1"
                  :class="color"
                  value-field="item"
                  text-field="name"
                  disabled-field="notEnabled"
                ></b-form-select>
              </b-list-group-item>
            </a>
            <div
              v-b-modal="modalId(violationitem.violationNo)"
              :tempNum="violationitem.violationNo"
            >
              <br />
              <div class="d-flex justify-content-between">
                <p class="mb-0" style="font-size: 1rem">{{ violationitem.date }}</p>
                <p class="mb-0">{{ violationitem.time }}</p>
              </div>
              <div>
                <p class="mb-0" style="font-size: 2rem">{{ violationitem.address }}</p>
              </div>
            </div>
          </b-list-group>
          <CaseModal :violationitem="violationitem" />
        </div>
      </div>
    </div>
  </b-col>
</template>

<script>
import vuePlayer from "@algoz098/vue-player";
import { mapGetters } from "vuex";
import moment from "moment";

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
  methods: {
    modalId(i) {
      return "modal" + i;
    },
    indexPlus(i) {
      return (i = ++i);
    },
    getFormatDate(violationitems) {
      return moment(new Date(violationitems)).format("YYYY.MM.DD");
    },
  },
  computed: {
    ...mapGetters(["violationitems"]),
  },
};
</script>

<style>
</style>