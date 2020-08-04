<template>
  <div>
    <h1 class="text-center mb-3">제보목록</h1>
    <b-container class="bv-example-row">
      <b-row>
        <!-- card1 -->
        <b-col cols="4" v-for="violationitem in violationitems" :key="violationitem.etag">
          <div>
            <b-card class="mb-3" no-body style="max-width: 20rem;">
              <vue-player
                src="http://d1xevv8xa9hsha.cloudfront.net/abcd.mp4"
                poster="https://via.placeholder.com/150"
                title="this is a title"
                v-model="playing"
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

              <b-card-body :items="noticeitems">
                <div class="text-center">
                  <b-button
                    v-b-modal="modalId(violationitem.violationNo)"
                    variant="info"
                    style="width: 100%;"
                  >상세보기 및 신고하기</b-button>
                  <!-- 모달 -->
                  <b-modal :id="'modal' + violationitem.violationNo" title="제보 상세보기" hide-footer>
                    <!-- 동영상 -->
                    <!-- 이거 자주 접속하면 요금폭탄맨~~~ -->
                    <vue-player
                      src="http://d1xevv8xa9hsha.cloudfront.net/abcd.mp4"
                      poster="https://via.placeholder.com/150"
                      title="this is a title"
                      v-model="playing"
                    ></vue-player>
                    <hr />
                    <!-- 세부사항 -->
                    <div>
                      <p>
                        위반항목 :
                        <b-form-select
                          v-model="violationitem.item"
                          :options="options2"
                          class="mb-0"
                          value-field="item"
                          text-field="name"
                          disabled-field="notEnabled"
                        ></b-form-select>
                      </p>
                      <p>
                        <label>위반일자 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="date"
                          readonly
                          ref="date"
                          v-model="violationitem.date"
                        />
                      </p>

                      <p>
                        <label>위반시간 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="time"
                          readonly
                          ref="time"
                          v-model="violationitem.time"
                        />
                      </p>
                      <p>
                        <label>위반차량번호 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="item"
                          ref="item"
                          v-model="violationitem.carNum"
                        />
                      </p>
                      <p>
                        <label>위반장소 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="item"
                          ref="item"
                          v-model="violationitem.spot"
                        />
                      </p>
                      <p>
                        <label>위반위치 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="item"
                          readonly
                          ref="item"
                          v-model="violationitem.address"
                        />
                      </p>
                      <p>
                        <label>신고내용 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="item"
                          ref="item"
                          v-model="violationitem.contents"
                        />
                      </p>
                      <hr />
                      <div class="d-flex justify-content-between mb-3">
                        <b-button variant="primary" style="width: 45%;" @click="saveHandler">저장하기</b-button>
                        <b-button variant="danger" style="width: 45%;" @click="saveHandler">삭제하기</b-button>
                      </div>
                      <b-button
                        variant="info"
                        style="width: 100%;"
                        href="http://onetouch.police.go.kr/"
                        onclick="window.open(this.href);return false;"
                        target="_blank"
                      >스마트 국민제보로 신고하러 가기</b-button>
                    </div>
                  </b-modal>
                </div>
              </b-card-body>
            </b-card>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import http from "@/util/http-common";
import vuePlayer from "@algoz098/vue-player";
import { mapGetters } from "vuex";
import moment from "moment";

export default {
  name: "CaseList",
  components: {
    vuePlayer,
  },
  props: {
    type: { type: String },
  },
  data() {
    return {
      // selectbox-1
      selected1: "신고 미접수",
      options1: [
        { item: "신고 미접수", name: "신고 미접수" },
        { item: "접수 완료", name: "접수 완료" },
        { item: "처리 완료", name: "처리 완료" },
      ],
      // selectbox-2
      selected2: "신호위반",
      options2: [
        { item: "신호위반", name: "신호위반" },
        { item: "끼어들기 금지 위반", name: "끼어들기 금지 위반" },
        { item: "통행의 금지 및 제한 위반", name: "통행의 금지 및 제한 위반" },
        {
          item: "교차로 통행방법위반(꼬리물기)",
          name: "교차로 통행방법위반(꼬리물기)",
        },
        {
          item: "제차 신호 조작 불이행(방향지시등)",
          name: "제차 신호 조작 불이행(방향지시등)",
        },
        { item: "중앙선침범", name: "중앙선침범" },
        { item: "적재물 추락방지 조치위반", name: "적재물 추락방지 조치위반" },
        { item: "적재중량, 적재용량초과", name: "적재중량, 적재용량초과" },
        { item: "지정차로 위반", name: "지정차로 위반" },
        { item: "진로변경 위반", name: "진로변경 위반" },
        { item: "교차로 통행방법 위반", name: "교차로 통행방법 위반" },
        { item: "고속도로 갓길통행 위반", name: "고속도로 갓길통행 위반" },
        { item: "기타", name: "기타" },
      ],

      //DB에서 가져온 내용 여기 저장할거임. 변수선언
      // violation_no: "",
      // user_no: "",
      // item: "",
      // date: "",
      // time: "",
      // car_num: "",
      // address: "",
      // spot: "",
      // contents: "",
      // video_url: "",
    };
  },
  mounted: function () {
    this.getFormatDate();
  },
  created() {
    this.$store.dispatch("getViolations");
  },
  computed: {
    ...mapGetters(["violationitems"]),
  },
  methods: {
    // customHandlers() {
    //   http
    //     .get(`/violation/${this.$session.get("user_no")}`)
    //     .then(({ data }) => {
    //       if (data != null) {
    //         //alert로 단위테스트 1회  => data.x  는 DB에서 받아온 Object를 data에 넣고 data.x로 그 data에 들어간 object 중 x라는 json에 접근
    //         // alert("바이오번호! " + data.violationNo);
    //         this.violation_no = data.violationNo;
    //         this.user_no = data.userNo;
    //         this.item = data.item;
    //         this.date = data.date;
    //         this.time = data.time;
    //         this.car_num = data.carNum;
    //         this.address = data.address;
    //         this.spot = data.spot;
    //         this.contents = data.contents;
    //         this.video_url = data.videoUrl;
    //       } else {
    //         alert("모든 동영상 정보 불러오기 실패했습니다.");
    //       }
    //     })
    //     .catch(() => {
    //       alert("에러가 발생했습니다.");
    //     });
    // },
    // customHandler() {
    //   http
    //     .get(`/violation/${this.$session.get("user_no")}/${violationNo}`)
    //     .then(({ data }) => {
    //       if (data != null) {
    //         //alert로 단위테스트 1회  => data.x  는 DB에서 받아온 Object를 data에 넣고 data.x로 그 data에 들어간 object 중 x라는 json에 접근
    //         // alert("바이오번호! " + data.violationNo);
    //         this.violation_no = data.violationNo;
    //         this.user_no = data.userNo;
    //         this.item = data.item;
    //         this.date = data.date;
    //         this.time = data.time;
    //         this.car_num = data.carNum;
    //         this.address = data.address;
    //         this.spot = data.spot;
    //         this.contents = data.contents;
    //         this.video_url = data.videoUrl;
    //         //이건 내부변수에 값이 제대로 들어갔나 확인하는 단위테스트
    //         // alert("차번호! " + this.car_num);
    //       } else {
    //         alert("동영상 정보 불러오기 실패했습니다.");
    //       }
    //     })
    //     .catch(() => {
    //       alert("에러가 발생했습니다.");
    //     });
    // },
    modalId(i) {
      return "modal" + i;
    },
    getFormatDate(violationitems) {
      return moment(new Date(violationitems)).format("YYYY.MM.DD HH:mm:ss");
    },
    saveHandler() {
      http
        .put(`/violation`, {
          violationNo: this.violation_no,
          userNo: this.user_no,
          item: this.item,
          carNum: this.car_num,
          spot: this.spot,
          contents: this.contents,
        })
        .then(({ data }) => {
          let msg = "저장에 실패하였습니다.";
          if (data === "success") {
            msg = "저장이 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    deleteHandler() {
      http
        .post(
          `del`,
          JSON.stringify({
            email: this.$session.get("email"),
          })
        )
        .then(({ data }) => {
          let msg = "회원삭제에 실패하였습니다..";
          if (data === "success") {
            msg = "회원삭제가 완료되었습니다.";
          }
          this.$root.$emit("bv::hide::modal", "modal-memberInfo");
          alert(msg);
          this.$session.destroy();
          this.$router.go();
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
};
</script>

<style></style>
