<template>
  <div class="wrapper1 bg-light">
    <div class="wrapper2">
      <NavBar class="fixed-top" />
      <div class="d-md-none" style="margin-bottom:64px"></div>
      <div class="d-none d-md-block" style="margin-bottom:148px"></div>
      <div class="container">
        <router-view />
      </div>
    </div>

    <footer class="mastfoot m-0 border-top" style="background-color: #ffffff;">
      <div class="text-center">
        <p class="mt-3">SSAFY 3기 공통 Project 2반 11조 나도내가무섭조</p>
      </div>
    </footer>
  </div>
</template>

<script>
import NavBar from "@/components/layout/NavBar.vue";
// import NavBarBottom from "@/components/layout/NavBarBottom.vue";
// import NavBar from "@/components/layout/NavBarOrigin.vue";
// import SideBar from "@/components/layout/SideBar.vue";

export default {
  name: "App",
  components: {
    NavBar,
    // NavBarBottom,
    // SideBar,
  },
  data() {
    return {};
  },
};
</script>

<style>
/* Google Font Import */
@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700;800&Noto+Sans+KR:wght@300&Do+Hyeon&Black+Han+Sans&display=swap");

.ft-bhs {
  font-family: "Black Han Sans", sans-serif;
  color: navy;
}

@import "~@/scss/_typo.scss";

* {
  font-family: "Nanum Gothic", "Noto Sans KR", "Do Hyeon", sans-serif;
}

/* 라우터 링크 */
p a {
  color: black;
  font-size: 120%;
}

/* .wrapper1 {
  position: relative;
  min-height: 85vh;
}

.wrapper2 {
  margin-top: 130px;
  padding-bottom: 2.5rem;
}

footer.mastfoot {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 2.5rem;
} */

/* .bg-cblue {
  color: #0f4c81;
}

.bg-uviolet {
  background-color: #5f4b8b;
} */

/* .footer {
  position: fixed;
  height: 100px;
  bottom: 0;
  width: 100%;
} */

.wrapper1 {
  position: relative;
  min-height: 80vh;
}

.wrapper2 {
  margin-top: 90px;
  padding-bottom: 2.5rem;
}

footer.mastfoot {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 2.5rem;
}
</style>
