<template>
  <div>
    <button class="btn btn-info" @click="MapGet">{{ message }}</button>
    <div id="map" style="width:100%;height:400px;"></div>
  </div>
</template>

<script>
import axios from "axios";

const ClientId = "kj0kkvm3ws";
const NmapApi = `https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${ClientId}`;

// var mapOptions = {
//   center: new naver.maps.LatLng(37.3595704, 127.105399),
//   zoom: 10,
// };
// var map = new naver.maps.Map("map", mapOptions);

export default {
  name: "NaverMap",
  components: {},
  data() {
    return {
      message: "Map Please!",
      map: null,
    };
  },
  methods: {},
  mounted() {
    axios
      .get(NmapApi)
      .then((res) => {
        console.log(res);
        console.log("성공!");
      })
      .catch((err) => {
        console.log(err);
        console.log("대실패!");
      });
  },
};
</script>

<style></style>
