<template>
  <div class="container">
    <h1 class="text-center mb-3">사이트 이용 방법</h1>
    <div class="divdiv shadow p-3 mb-5 bg-white rounded">
      <div class="mx-auto" style="width:auto;">
        <h2 style="background-color: #FFFFF0; width:auto">1. 민원 처리 상태 관리</h2>
      </div>
      <hr />
      <img src="@/assets/logos/HowToUse1.png" alt="HowToUse1" style="width: 100%;" />
      <p>
        1) 초기 상태는
        <span style="color: #6c757d">신고 미접수</span>로 아직 스마트 국민제보 사이트에 민원을 접수하기 전 단계입니다.
      </p>
      <hr />
      <img src="@/assets/logos/HowToUse2.png" alt="HowToUse2" style="width: 100%;" />
      <p>
        2) 스마트 국민제보 사이트에 민원을 접수하면
        <span style="color: #007bff">접수 완료</span>로 변경하고, 민원이 처리되면
        <span style="color: #28a745">처리 완료</span>로 변경합니다.
      </p>
    </div>

    <div class="divdiv shadow p-3 mb-5 bg-white rounded">
      <h2 style="background-color: #FFFFF0;">2. 민원 상세정보 입력 및 저장</h2>
      <hr />
      <img src="@/assets/logos/HowToUse3.png" alt="HowToUse3" style="width: 100%;" />
      <p>1) 제보 상세보기에서는 다음의 빈칸들을 작성 후 저장하기를 누릅니다.</p>
      <hr />
      <img src="@/assets/logos/HowToUse4.png" alt="HowToUse4" style="width: 100%;" />
      <p>
        2) 영상을
        <span style="color: #28a745">다운로드</span> 받은 후 하단의
        <span style="color: #17a2b8">스마트 국민제보로 신고하러 가기</span> 버튼을 누릅니다.
      </p>
    </div>
    <br />

    <div class="divdiv shadow p-3 mb-5 bg-white rounded">
      <h2 style="background-color: #FFFFF0;">3. 스마트 국민제보에서 신고하기</h2>
      <hr />
      <img src="@/assets/logos/HowToUse5.png" alt="HowToUse5" style="width: 100%;" />
      <p>
        1) 스마트 국민제보 사이트에서 회원가입 후
        <span style="color: #28a745">로그인</span>을 합니다.
      </p>
      <hr />
      <img src="@/assets/logos/HowToUse6.png" alt="HowToUse6" style="width: 100%;" />
      <p>
        2) 메인화면에 보이는
        <span style="color: #28a745">교통위반</span> 버튼을 누릅니다.
      </p>
      <hr />
      <img src="@/assets/logos/HowToUse7.png" alt="HowToUse7" style="width: 100%;" />
      <p>
        3) 분노의민원 사이트 제보목록에
        <span style="color: #28a745">저장된 카드</span>
        를 보면서 1~8번 순서대로 교통위반신고 항목을 기입하고
        <span style="color: #17a2b8">신고하기</span> 버튼을 누릅니다.
      </p>
      <hr />
      <img src="@/assets/logos/HowToUse8.png" alt="HowToUse8" style="width: 100%;" />
      <p>
        4) 신고가
        <span style="color: #28a745">완료</span>됐다면 분노의민원 사이트로 돌아와 사진처럼
        <span style="color: #17a2b8">신고 미접수</span> 상태를
        <span style="color: #17a2b8">접수 완료</span> 상태로 바꿔줍니다.
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