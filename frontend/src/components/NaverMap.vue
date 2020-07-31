<template>
  <div id="app">
    <div id="map"></div>
  </div>
</template>

<script>
// import axios from "axios";

// const ClientId = "kj0kkvm3ws";
// const NmapApi = `https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${ClientId}`;

export default {
  mounted() {
    if (window.naver && window.naver.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global naver */
      script.onload = () => naver.maps.load(this.initMap);
      script.src =
        "https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=kj0kkvm3ws";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      // # alt 1
      var container = document.getElementById("map");
      // var options = {
      //   center: new naver.maps.LatLng(33.450701, 126.570667),
      //   level: 3,
      // };

      // var map = new naver.maps.Map(container, options);
      // map.setMapTypeId(naver.maps.MapTypeId.HYBRID);
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

<style>
#map {
  width: 1080px;
  height: 720px;
}
</style>
