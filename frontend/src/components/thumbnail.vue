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
                <h4 class="mb-0 text-center">범죄 유형</h4>
              </template>

              <b-list-group flush>
                <b-list-group-item>
                  <div class="mb-3">
                    상태 : <strong>{{ selected }}</strong>
                  </div>
                  <b-form-select
                    v-model="selected"
                    :options="options"
                    class="mb-0"
                    value-field="item"
                    text-field="name"
                    disabled-field="notEnabled"
                  ></b-form-select>
                </b-list-group-item>
                <b-list-group-item>위치 :</b-list-group-item>
                <b-list-group-item>날짜 :</b-list-group-item>
                <b-list-group-item>시간 :</b-list-group-item>
              </b-list-group>

              <b-card-body>
                <div class="text-center">
                  <b-button
                    v-b-modal.modal-2
                    variant="info"
                    style="width: 100%;"
                    >상세보기 및 신고</b-button
                  >

                  <b-modal id="modal-2" title="제보 상세보기">
                    <!-- 동영상 -->
                    <div>
                      <b-embed
                        type="iframe"
                        aspect="16by9"
                        src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0"
                        allowfullscreen
                      ></b-embed>
                    </div>
                    <hr />
                    <!-- 세부사항 -->
                    <div>
                      <p>범죄 유형</p>
                      <p>위치</p>
                      <p>날짜</p>
                      <p>시간</p>
                    </div>
                    <hr />
                    <!-- 제보내용 -->
                    <div>
                      <div class="mb-2">-{{ text }}</div>
                      <b-form-input
                        v-model="text"
                        placeholder="Enter your name"
                      ></b-form-input>
                    </div>
                  </b-modal>
                </div>
              </b-card-body>
            </b-card>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "thumbnail",

  data() {
    return {
      // selectbox
      selected: "신고 미접수",
      options: [
        { item: "신고 미접수", name: "신고 미접수" },
        { item: "접수 완료", name: "접수 완료" },
        { item: "처리 완료", name: "처리 완료" },
      ],
      // 제보 내용
      text: "",
    };
  },
};
</script>

<style></style>
