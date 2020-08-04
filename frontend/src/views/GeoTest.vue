<template>
  <div id="container">
    <h1>Where Am I</h1>
    <h2>당신의 위치!</h2>
    <h3 id="LatLng"></h3>
  </div>
</template>

<script>
export default {
  name: "GeoTest",
  mounted() {
    function getLocation() {
      if (navigator.geolocation) {
        // GPS를 지원하면
        navigator.geolocation.getCurrentPosition(
          function (position) {
            // alert(position.coords.latitude + " " + position.coords.longitude);
            // 성공했다면
            var LocText =
              "위도: " +
              position.coords.latitude +
              " " +
              "경도: " +
              position.coords.longitude;
            var container = document.getElementById("LatLng");
            container.innerText = LocText;
          },
          function (error) {
            console.error(error);
          },
          {
            enableHighAccuracy: false,
            maximumAge: 0,
            timeout: Infinity,
          }
        );
      } else {
        alert("GPS를 지원하지 않습니다");
      }
    }
    getLocation();
  },
};
</script>

<style>
</style>