<template>
  <div>
    <br />
    <h1 class="text-center mb-3">사이트 이용 방법</h1>
    <div class="divdiv">
      <h2>1. 민원 처리 상태 관리</h2>
      <img src="@/assets/logos/HowToUse1.png" alt="HowToUse1" style="width: 100%;" />
      <p>
        1) 초기 상태는
        <span style="color: #6c757d">신고 미접수</span>로 아직 스마트 국민제보 사이트에 민원을 접수하기 전 단계입니다.
      </p>
      <img src="@/assets/logos/HowToUse2.png" alt="HowToUse2" style="width: 100%;" />
      <p>
        2) 스마트 국민제보 사이트에 민원을 접수하면
        <span style="color: #007bff">접수 완료</span>로 변경하고, 민원이 처리되면
        <span style="color: #28a745">처리 완료</span>로 변경합니다.
      </p>
    </div>
    <br />
    <div class="divdiv">
      <h2>2. 민원 상세정보 입력 및 제보하기</h2>
      <img src="@/assets/logos/HowToUse3.png" alt="HowToUse3" style="width: 100%;" />
      <p>1) 제보 상세보기에서는 다음의 빈칸들을 작성 후 저장하기를 누릅니다.</p>
      <img src="@/assets/logos/HowToUse4.png" alt="HowToUse4" style="width: 100%;" />
      <p>
        2) 영상을
        <span style="color: #28a745">다운로드</span> 받은 후 하단의
        <span style="color: #17a2b8">스마트 국민제보로 신고하러 가기</span> 버튼을 누릅니다.
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "HowToUse",
  components: {},
};
</script>

<style scoped>
p {
  font-size: 140%;
  margin-top: 12px;
}
</style>