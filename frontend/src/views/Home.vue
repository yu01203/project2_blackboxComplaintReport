<template>
  <div>
    <div v-if="this.$session.get('email') != null">
      <CaseList />
      <br />
    </div>
    <ReportInfo />
  </div>
</template>

<script>
import CaseList from "@/views/CaseList.vue";
import ReportInfo from "@/views/ReportInfo.vue";

export default {
  name: "Home",
  components: {
    CaseList,
    ReportInfo,
  },
};
</script>

<style></style>
