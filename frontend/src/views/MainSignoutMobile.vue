<template>
  <div id="content" style="height:100%;margin-top:-64px">
    <div class="h-100 d-flex align-items-center">
      <div class="mx-auto text-center">
        <h3 class="text-white">가운데로 넣자</h3>
        <img src="@/assets/logos/Logo_ico.png" alt="Logo-iconic-image" />
        <h5 class="text-white">이미지도 가운데로 넣자</h5>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainSignoutPC",
};
</script>

<style scoped>
#content {
  position: relative;
  background-color: rgba(13, 35, 68, 0.781);
  width: 100vw;
  height: 100vh;
}

#content:after {
  background-image: url("~@/assets/images/home-bg-mobile.jpg");
  /* background-size: 100%; */

  background-attachment: fixed;
  background-position: center;
  background-size: cover;

  content: "";
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: -1;
}
</style>