<template>
  <div>
    <h1>제보 목록</h1>
    <b-container class="bv-example-row">
      <b-row>
        <!-- card1 -->
        <b-col>
          <div>
            <b-card
              no-body
              style="max-width: 20rem;"
              img-src="https://placekitten.com/380/200"
              img-alt="Image"
              img-top
            >
              <template v-slot:header>
                <h4 class="mb-0">범죄 유형</h4>
              </template>

              <b-list-group flush>
                <b-list-group-item>위치:</b-list-group-item>
                <b-list-group-item>날짜:</b-list-group-item>
                <b-list-group-item>시간:</b-list-group-item>
              </b-list-group>

              <b-card-body>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </b-card-body>
            </b-card>
          </div>
        </b-col>

        <!-- card2 -->
        <b-col>
          <div>
            <b-card
              no-body
              style="max-width: 20rem;"
              img-src="https://placekitten.com/380/200"
              img-alt="Image"
              img-top
            >
              <template v-slot:header>
                <h4 class="mb-0">범죄 유형</h4>
              </template>

              <b-list-group flush>
                <b-list-group-item>위치:</b-list-group-item>
                <b-list-group-item>날짜:</b-list-group-item>
                <b-list-group-item>시간:</b-list-group-item>
              </b-list-group>

              <b-card-body>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </b-card-body>
            </b-card>
          </div>
        </b-col>

        <b-col></b-col>

        <b-col></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "thumbnail",
};
</script>

<style></style>
