<template>
  <div>
    <KakaoMap />
    <!-- <NaverMap /> -->
  </div>
</template>

<script>
import KakaoMap from "@/components/KakaoMap.vue";
// import NaverMap from "@/components/NaverMap.vue";

export default {
  name: "MapMain",
  components: {
    KakaoMap,
    // NaverMap,
  },
};
</script>

<style></style>
