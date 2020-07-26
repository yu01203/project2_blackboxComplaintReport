<template>
  <div>
    <CaseList />
    <br />
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
