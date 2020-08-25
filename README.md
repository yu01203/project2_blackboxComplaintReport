# 서울 2반 11조

<img src = "/uploads/b5b24fcf568201fe27804b5194574274/logo.jpg" width="50%" height="50%">


# 프로젝트 소개
## 분노의민원
원 버튼 간편 교통 민원 DB 플랫폼

## 서비스 목적
안전하고 간편하게 위반 상황 기록

## 핵심 기능
버튼 한번으로 지난 20초 상황에 대한 기록

# 프로젝트 사용법

# 서비스 설명

# 컨트리뷰터

# 라이센스

# 기타(디벨롭 룰, 개발 일정, 개발자 소개, 자랑하고 싶은 것, 변화된 이슈 등)


## GIT Branch 변경

```bash
$ git checkout <브랜치 이름>
```

## GIT 특정 Branch 클론

```bash
$ git clone -b <브랜치 이름> --single-branch <레퍼지토리 주소>
```
```bash
$ git clone -b develop --single-branch https://lab.ssafy.com/s03-webmobile3-sub2/s03p12a211.git
```
## GIT Workflow

#### Git Bash의 브랜치 상태를 통해 항상 선택된 브랜치를 확인합니다.

1. (Master) 혹은 (develop)일 때, 특정 브랜치 생성 명령어 `branch` (feature-구현하는 기능)
	```bash
   $ git branch feature-mainpage
   ```
	이미 생성된 브랜치가 있는 경우의 브랜치 변경 명령어는 `checkout` 입니다.
	
	```bash
	$ git checkout feature-mainpage
	```
	
2. 작업 완료 후 평소와 같이 push 워크플로우를 진행합니다.

   ```bash
   $ git add <작업한 디렉토리 경로>
   $ git commit -m "S03P12A211 | Front-end > Layout > Sidebar Modified"
   $ git push
   ```

3. Git Lab 프로젝트로 이동하여 Develop 브랜치와 Merge합니다.

## NPM 패키지 인스톨

- npm install
  - 평소랑 같이 해주면 됩니다.

## 현재 인스톨된 NPM 패키지 리스트 만들기

```bash
$ npm shrinkwrap
```

- 현재 경로에 npm-shrinkwrap.json 작성
  
- shrinkwrap: 현재 인스톨된 npm 패키지 json 목록으로 작성하는 패키지
  
- 해당 npm을 공유받는 사람은 

  ```bash
  $ npm install
  ```

  다음의 명령어로 작성된 패키지 리스트대로 설치 가능