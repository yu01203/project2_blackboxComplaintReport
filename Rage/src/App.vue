<template>
  <div>
    <nav
      class="d-flex justify-content-around navbar navbar-light"
      style="margin: 10px 0px"
    >
      <b-button v-b-toggle.sidebar-1>MENU</b-button>
      <h1 style="margin: 0px;">분노의 민원</h1>
      <p style="margin: 0px;">로그인</p>
    </nav>

    <b-sidebar id="sidebar-1" title="분노의 민원" shadow>
      <div class="px-3 py-2">
        <router-link to="/">Home</router-link><br />
        <router-link to="/thumbnail">제보목록</router-link><br />
        <router-link to="/status">교통 안전 현황</router-link><br />
        <router-link to="/map">지도로 보기</router-link>
      </div>
    </b-sidebar>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<style></style>
