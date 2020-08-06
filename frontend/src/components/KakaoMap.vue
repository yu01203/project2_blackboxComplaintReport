<template>
  <div id="app">
    <div id="map"></div>
  </div>
</template>

<script>
// import CaseModalVue from "@/components/case/CaseModal.vue";
var KakaoApi = process.env.VUE_APP_KAKAO_API_KEY;

// this.$store.state.violationitems

export default {
  name: "Map",
  data() {
    return {
      DummyLoc: [
        { lat: "37.4938", lng: "126.981", violationNo: "4" },
        { lat: "37.540936", lng: "126.969477", violationNo: "5" },
        { lat: "37.53879", lng: "127.009477", violationNo: "9" },
        { lat: "37.49979", lng: "127.039477", violationNo: "10" },
      ],
    };
  },
  components: {
    // CaseModalVue,
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

      //   kakao.maps.event.addListener(marker, "click", function () {
      //     alert(this.DummyLoc[j]["violationNo"]);
      //   });
      // }
      // marker.setMap(map);

      // Make Markers Ver. 2
      for (var i = 0; i < this.DummyLoc.length; i++) {
        var markerPosition = new kakao.maps.LatLng(
          this.DummyLoc[i].lat,
          this.DummyLoc[i].lng
        );
        var marker = new kakao.maps.Marker({
          position: markerPosition,
          // clickable: true,
        });
        marker.setMap(map);

        // var infowindow = new kakao.maps.InfoWindow({
        //   content: CaseModalVue,
        // });
        // var CaseModalVue = new kakao.maps.InfoWindow({
        //   content: this.CaseModalVue("modal" + this.DummyLoc[i].violationNo),
        //   // removable: iwRemoveable,
        // });
        // kakao.maps.event.addListener(marker, "click", function () {
        //   CaseModalVue.open();
        // this.$bvModal.show(id);
        // });
      }
    },
  },
  testConsole() {
    alert("Hello!");
  },
};
</script>

<style>
#map {
  width: 1080px;
  height: 720px;
}
</style>
