<template>
  <div>
    <Thumbnail />
    <br />
    <Status />
  </div>
</template>

<script>
import Thumbnail from "@/components/thumbnail.vue";
import Status from "@/components/status.vue";

export default {
  name: "Home",
  components: {
    Thumbnail,
    Status,
  },
};
</script>

<style></style>
