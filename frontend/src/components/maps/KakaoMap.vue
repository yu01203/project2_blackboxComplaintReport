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
// import http from "@/util/http-common";

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
      // items: this.$store.state.violationitems,
      // items: [],
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
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(37.5138, 126.981),
        level: 7,
      };

      var map = new kakao.maps.Map(container, options);
      // map.setMapTypeId(kakao.maps.MapTypeId.HYBIRD);

      // Make Markers Ver. 1
      // var positions = new Array();
      // for (var i = 0; i < this.DummyLoc.length; i++) {
      //   positions.push({
      //     latlng: new kakao.maps.LatLng(
      //       this.DummyLoc[i]["lat"],
      //       this.DummyLoc[i]["lng"]
      //     ),
      //   });
      // }
      // for (var j = 0; j < positions.length; j++) {
      //   var marker = new kakao.maps.Marker({
      //     map: map,
      //     position: positions[j].latlng,
      //     clickable: true,
      //   });

      //   // kakao.maps.event.addListener(marker, "click", function () {
      //   //   alert(this.DummyLoc[j]["violationNo"]);
      //   // });
      // }
      // marker.setMap(map);
      // ver1 필수 코드
      // var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
      //   iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

      // // 인포윈도우를 생성합니다
      // var infowindow = new kakao.maps.InfoWindow({
      //   content: iwContent,
      //   removable: iwRemoveable,
      // });

      // Make Markers Ver. 2
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

        // 도전 원본
        (function (marker, infowindow) {
          // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다
          kakao.maps.event.addListener(marker, "click", function () {
            // infowindow.open(map, marker);
            document
              .getElementById(
                //     //     // 이거는 1만 된단 말이지
                "modalButton" + violationitem.violationNo
              )
              .click();
            // this.$ref["modalref" + violationitem.violationNo].show();
          });
          kakao.maps.event.addListener(marker, "mouseover", function () {
            infowindow.open(map, marker);
          });

          // // 마커에 mouseout 이벤트를 등록하고 마우스 아웃 시 인포윈도우를 닫습니다
          kakao.maps.event.addListener(marker, "mouseout", function () {
            infowindow.close();
          });
        })(marker, infowindow);
      }
    },
  },
  created() {
    // http
    //   .get(`/violation/${this.$session.get("userNo")}`)
    //   .then(({ data }) => {
    //     if (data) {
    //       // this.local_violationitems = data;
    //       this.items = data;
    //       // alert("ㅔㅗ");
    //     } else {
    //       alert(" 실패했습니다.");
    //     }
    //   })
    //   .catch(() => {
    //     alert("에러가 발생했습니다.");
    //   });
  },
};
</script>

<style scoped>
#map {
  width: 80vw;
  height: 80vh;
}
</style>
