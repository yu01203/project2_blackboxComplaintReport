<template>
  <b-sidebar id="sidebar-1" title="" shadow>
    <div id="sidebar-content" class="d-flex flex-column px-4 py-0">
      <p style="font-size: 150%">
        <router-link to="/" style="text-decoration: none;"
          >분노의 민원</router-link
        >
      </p>
      <p>
        <router-link to="/caselist" style="text-decoration: none;"
          >제보 목록</router-link
        >
      </p>
      <p>
        <router-link to="/reportinfo" style="text-decoration: none;"
          >제보 현황</router-link
        >
      </p>
      <p>
        <router-link to="/mapmain" style="text-decoration: none;"
          >지도 보기</router-link
        >
      </p>
    </div>
  </b-sidebar>
</template>

<script>
export default {
  name: 'SideBar'
}
</script>

<style>
#sidebar-1 {
  padding: 15px;
}
</style>