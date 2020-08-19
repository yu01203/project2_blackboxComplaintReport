<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="5000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        img-src="https://picsum.photos/1024/480/?image=52"
        caption="최근 5개 항목"
        text="지금의 분노를 빠르게 정의구현으로 연결해보세요."
      >
        <b-container class="bv-example-row">
          <b-row>
            <Case
              v-for="violationitem in this.$store.state.violationitems.slice(0, 3).reverse()"
              :key="violationitem.violationNo"
              :violationitem="violationitem"
            />
          </b-row>
        </b-container>
      </b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
        <h1>Hello world!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <template v-slot:img>
          <img
            class="d-block img-fluid w-100"
            width="1024"
            height="480"
            src="https://picsum.photos/1024/480/?image=55"
            alt="image slot"
          />
        </template>
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
      <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eros felis, tincidunt
          a tincidunt eget, convallis vel est. Ut pellentesque ut lacus vel interdum.
        </p>
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
import http from "@/util/http-common";
import Case from "@/components/case/CaseTube.vue";

export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  components: {
    Case,
  },
  created() {
    http
      .get(`/violation/${this.$session.get("userNo")}`, {
        headers: {
          token: this.$session.get("token"),
        },
      })
      .then(({ data }) => {
        if (data != null) {
          this.local_violationitems = data;
          this.$store.state.violationitems = data;
        } else {
          alert(" 실패했습니다.");
        }
      })
      .catch(() => {
        alert("에러가 발생했습니다.");
      });
  },
  methods: {
    // onSlideStart(slide) {
    //   this.sliding = true;
    // },
    // onSlideEnd(slide) {
    //   this.sliding = false;
    // },
  },
};
</script>