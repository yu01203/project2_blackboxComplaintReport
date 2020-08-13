<template>
  <b-sidebar id="sidebar-1" title shadow>
    <div id="sidebar-content" class="d-flex flex-column px-4 py-0">
      <p>
        <router-link to="/">
          <img
            src="@/assets/logos/Logo_solid.png"
            alt="logo"
            style="width:100%; margin-bottom: 10px;"
          />
        </router-link>
      </p>
      <p>
        <router-link
          to="/noticeboard"
          style="text-decoration: none; color: navy; margin-left: 20px;"
        >공지사항</router-link>
      </p>
      <p v-if="this.$store.state.violationitems.length != 0">
        <router-link
          to="/caselist"
          style="text-decoration: none; color: navy; margin-left: 20px;"
        >제보목록</router-link>
      </p>
      <p>
        <router-link
          to="/reportinfo"
          style="text-decoration: none; color: navy; margin-left: 20px;"
        >제보현황</router-link>
      </p>
      <p>
        <router-link
          to="/mapmain"
          style="text-decoration: none; color: navy; margin-left: 20px;"
        >지도보기</router-link>
      </p>
      <p v-if="this.$session.get('email') == 'admin'">
        <router-link
          to="/usermanagement"
          style="text-decoration: none; color: navy; margin-left: 20px;"
        >회원관리</router-link>
      </p>
      <!-- <p>
        <router-link to="/geotest" style="text-decoration: none; color: navy;">죠로케이션 테스트</router-link>
      </p>-->
    </div>
  </b-sidebar>
</template>

<script>
export default {
  name: "SideBar",
};
</script>

<style scoped>
#sidebar-1 {
  padding: 15px;
}
</style>