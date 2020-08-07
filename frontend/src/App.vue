<template>
  <div class="wrapper1">
    <div class="wrapper2">
      <NavBar />
      <SideBar />
      <br />
      <div class="container mb-3">
        <router-view />
      </div>
      <br />
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
import SideBar from "@/components/layout/SideBar.vue";

export default {
  name: "App",
  components: {
    NavBar,
    SideBar,
  },
};
</script>

<style>
/* 타이틀 */
@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap");

.ft-bhs {
  font-family: "Black Han Sans", sans-serif;
  color: navy;
}

/* 전체 기본 폰트 */
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap");

* {
  font-family: "Do Hyeon", sans-serif;
}

/* 라우터 링크 */
p a {
  color: black;
  font-size: 120%;
}

.wrapper1 {
  position: relative;
  min-height: 85vh;
}

.wrapper2 {
  margin-top: 90px;
  padding-bottom: 2.5rem;
}

footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 2.5rem;
}
</style>
