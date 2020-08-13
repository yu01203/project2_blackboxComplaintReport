<template>
  <div id="app">
    <div id="map"></div>
  </div>
</template>

<script>
var NaverApiKey = process.env.VUE_APP_NAVER_API_KEY;

export default {
  mounted() {
    if (window.naver && window.naver.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global naver */
      script.onload = () => naver.maps.onJSContentLoaded(this.initMap);
      script.src = `https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${NaverApiKey}&callback=initMap`;
      document.head.appendChild(script);
    }
    // if (document.readyState === "complete") {
    //   this.initMap();
    // } else {
    //   document.body.onload = function () {
    //     this.initMap();
    //   };
    // }
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399),
        zoom: 10,
      };

      var map = new naver.maps.Map(container, mapOptions);
      map.setMapTypeId(naver.maps.MapTypeId.HYBRID);
    },
  },
};
</script>

<style scoped>
#map {
  width: 1080px;
  height: 720px;
}
</style>
