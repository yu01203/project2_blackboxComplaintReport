# 서울 2반 11조

## GIT Branch 변경

```bash
$ git checkout <브랜치 이름>
```



## NPM 패키지 인스톨

- npm install
  - 평소랑 같이 해주면 됩니다.

## 현재 인스톨된 NPM 패키지 리스트 만들기

```bash
$ npm shrinkwarp
```

- 현재 경로에 npm-shrinkwrap.json 작성
  - shrinkwarp: 현재 인스톨된 npm 패키지 json 목록으로 작성하는 패키지

- 해당 npm을 공유받는 사람은 

  ```bash
  $ npm install
  ```

  다음의 명령어로 작성된 패키지 리스트대로 설치 가능