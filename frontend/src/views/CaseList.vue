<template>
  <div>
    <h1 class="text-center mb-3">제보목록</h1>
    <b-container class="bv-example-row">
      <b-row>
        <!-- card1 -->
        <b-col>
          <div>
            <!-- <b-card
              no-body
              style="max-width: 20rem;"
              img-src="https://placekitten.com/380/200"
              img-alt="Image"
              img-top
            >-->
            <b-card no-body style="max-width: 20rem;">
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
                <b-list-group-item>위반일자 :</b-list-group-item>
                <b-list-group-item>위반시간 :</b-list-group-item>
                <b-list-group-item>위반장소 :</b-list-group-item>
              </b-list-group>

              <b-card-body :items="noticeitems">
                <div class="text-center">
                  <b-button
                    v-b-modal.modal-2
                    variant="info"
                    style="width: 100%;"
                    @click="customHandler"
                  >상세보기 및 신고하기</b-button>
                  <!-- 모달 -->
                  <b-modal id="modal-2" title="제보 상세보기" hide-footer>
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
                          v-model="selected2"
                          :options="options2"
                          class="mb-0"
                          value-field="item"
                          text-field="name"
                          disabled-field="notEnabled"
                        ></b-form-select>
                      </p>
                      <p>
                        <label>아이디 :</label>
                        <input
                          type="text"
                          class="form-control"
                          id="item"
                          ref="item"
                          v-model="car_num"
                        />
                      </p>
                      <p>
                        <label>위반일자 :</label>
                        <input type="text" class="form-control" id="date" ref="date" v-model="date" />
                      </p>

                      <p>
                        <label>위반시간 :</label>
                        <input type="text" class="form-control" id="time" ref="time" v-model="time" />
                      </p>
                      <div class="mb-2">
                        <div class="mb-2">위반차량번호 : {{ text1 }}</div>
                        <b-form-input v-model="text1" placeholder="위반차량번호를 정확하게 입력해주세요."></b-form-input>
                      </div>
                      <p>위반장소 :</p>
                      <div class="mb-2">
                        <div class="mb-2">위반위치 : {{ text2 }}</div>
                        <b-form-input v-model="text2" placeholder="위반위치를 입력해주세요. 최대 20자까지 입력가능합니다."></b-form-input>
                      </div>
                      <div class="mb-2">
                        <div class="mb-2">신고내용 : {{ text3 }}</div>
                        <b-form-input
                          v-model="text3"
                          placeholder="자세한 신고내용을 입력해주세요. 예) 신호 위반 시 상황, 차량 색상 등"
                        ></b-form-input>
                      </div>
                      <hr />
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
// import { mapGetters } from "vuex";

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
      // 제보 내용
      text1: "",
      text2: "",
      text3: "",

      //DB에서 가져온 내용 여기 저장할거임. 변수선언
      violation_no: "",
      user_no: "",
      item: "",
      date: "",
      time: "",
      car_num: "",
      address: "",
      spot: "",
      contents: "",
      video_url: "",
    };
  },
  methods: {
    customHandler() {
      http
        .get(`/violation/1/1`)
        .then(({ data }) => {
          if (data != null) {
            //alert로 단위테스트 1회  => data.x  는 DB에서 받아온 Object를 data에 넣고 data.x로 그 data에 들어간 object 중 x라는 json에 접근
            // alert("바이오번호! " + data.violationNo);
            this.violation_no = data.violationNo;
            this.user_no = data.userNo;
            this.item = data.item;
            this.date = data.date;
            this.time = data.time;
            this.car_num = data.carNum;
            this.address = data.address;
            this.spot = data.spot;
            this.contents = data.contents;
            this.video_url = data.videoUrl;

            //이건 내부변수에 값이 제대로 들어갔나 확인하는 단위테스트
            alert("차번호! " + this.car_num);
          } else {
            alert("동영상 정보 불러오기 실패했습니다.");
          }
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
};
</script>

<style></style>
