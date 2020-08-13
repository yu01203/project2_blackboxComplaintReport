<template>
  <div id="app">
    <!-- Map Division -->
    <div id="map"></div>
    <!-- Modal Division -->
    <div v-for="violationitem in items" :key="violationitem.violationNo">
      <b-button
        hidden
        :id="'modalButton' + violationitem.violationNo"
        v-b-modal="'modal'+ violationitem.violationNo"
      ></b-button>
      <b-modal
        :ref="'modalref' + violationitem.violationNo"
        :id="'modal' + violationitem.violationNo"
        title="제보 상세보기"
        hide-footer
      >
        <div class="text-center justify-content-center p-0">
          <video id="video1" style="width:100%" controls>
            <source :src="violationitem.videoUrl" type="video/mp4" />
          </video>
          <a
            :href="violationitem.videoUrl"
            download
            class="btn btn-success"
            style="width:100%"
          >영상 다운로드</a>
        </div>
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
            <input type="text" class="form-control" id="date" readonly ref="date" v-model="date" />
          </p>

          <p>
            <label>위반시간 :</label>
            <input type="text" class="form-control" id="time" readonly ref="time" v-model="time" />
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
          <!-- <div class="d-flex justify-content-between mb-3">
            <b-button variant="primary" style="width: 45%;" @click="saveHandler">저장하기</b-button>
            <b-button variant="danger" style="width: 45%;" @click="deleteHandler">삭제하기</b-button>
          </div>-->
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
  </div>
</template>

<script>
var KakaoApi = process.env.VUE_APP_KAKAO_API_KEY;

export default {
  name: "Map",
  props: {
    items: {
      type: Array,
    },
  },
  data() {
    return {
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
      date: "",
      time: "",
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${KakaoApi}`;
      document.head.appendChild(script);
    }
    this.transDateTime();
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(37.5138, 126.981),
        level: 7,
      };

      var map = new kakao.maps.Map(container, options);

      for (var i = 0; i < this.items.length; i++) {
        const violationitem = this.items[i];

        var markerPosition = new kakao.maps.LatLng(
          violationitem.lat,
          violationitem.lng
        );
        var marker = new kakao.maps.Marker({
          map: map,
          position: markerPosition,
          clickable: true,
        });

        var iwContent =
          // document.getElementById("my-modal");
          '<div style="padding:5px;">' + violationitem.item + "</div>";

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: iwContent,
          // removable: iwRemoveable,
        });

        (function (marker, infowindow) {
          kakao.maps.event.addListener(marker, "click", function () {
            document
              .getElementById("modalButton" + violationitem.violationNo)
              .click();
          });
          kakao.maps.event.addListener(marker, "mouseover", function () {
            infowindow.open(map, marker);
          });
          kakao.maps.event.addListener(marker, "mouseout", function () {
            infowindow.close();
          });
        })(marker, infowindow);
      }
    },
    transDateTime() {
      var RawDate = this.violationitem.date.split("-");
      var newDate =
        RawDate[0] + "년" + " " + RawDate[1] + "월" + " " + RawDate[2] + "일";
      this.$store.state.violationitems;
      this.date = newDate;

      var RawTime = this.violationitem.time.split(":");
      if (RawTime[0] >= 12) {
        var ApTime = RawTime[0] - 12;
        if (ApTime === 0) {
          ApTime = 12;
        }
        var newTime = "오후" + " " + ApTime + "시" + " " + RawTime[1] + "분";
        this.time = newTime;
      } else {
        var AmTime = RawTime[0].slice(0, 1);
        if (AmTime == 0) {
          AmTime = 12;
        }
        newTime = "오전" + " " + AmTime + "시" + " " + RawTime[1] + "분";
        this.time = newTime;
      }
    },
  },
  created() {},
};
</script>

<style scoped>
#map {
  width: 80vw;
  height: 80vh;
}
</style>
