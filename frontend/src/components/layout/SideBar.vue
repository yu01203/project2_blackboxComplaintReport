<template>
  <b-sidebar id="sidebar-1" title shadow>
    <div id="sidebar-content" class="d-flex flex-column px-4 py-0">
      <p style="font-size: 150%">
        <router-link to="/" style="text-decoration: none; color: navy;">
          <img src="@/assets/Logo_3.png" alt="logo" style="width:100%" />
        </router-link>
      </p>
      <p>
        <router-link to="/noticeboard" style="text-decoration: none; color: navy;">공지사항</router-link>
      </p>
      <p>
        <router-link to="/caselist" style="text-decoration: none; color: navy;">제보목록</router-link>
      </p>
      <p>
        <router-link to="/reportinfo" style="text-decoration: none; color: navy;">제보현황</router-link>
      </p>
      <p>
        <router-link to="/mapmain" style="text-decoration: none; color: navy;">지도보기</router-link>
      </p>
      <p>
        <router-link to="/geotest" style="text-decoration: none; color: navy;">죠로케이션 테스트</router-link>
      </p>
    </div>
  </b-sidebar>
</template>

<script>
export default {
  name: "SideBar",
};
</script>

<style>
#sidebar-1 {
  padding: 15px;
}
</style>