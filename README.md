# 서울 2반 11조

<img src = "/uploads/b5b24fcf568201fe27804b5194574274/logo.jpg" width="50%" height="50%">


# 프로젝트 소개
## 분노의민원
원 버튼 간편 교통 민원 DB 플랫폼
차량 주행 중 한번의 버튼 클릭으로 관련 영상 및 정보를
웹 서버에 전송되어 민원

## 서비스 목적
안전하고 간편하게 위반 상황 기록

## 핵심 기능
버튼 한번으로 지난 20초 상황에 대한 기록

# 프로젝트 사용법
### Import
```bash
git clone https://lab.ssafy.com/s03-webmobile3-sub2/s03p12a211.git
```

### Vue.js
```bash
cd s03p12a211/frontend
npm install
npm run serve
```

### Deploy
#### Install NGINX
```bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install nginx
```

#### Environment Setting
```bash
cd /etc/nginx/sites-available
vi default
```

```linux
# Front-End Setting
root <Front 빌드 파일 위치>;
<index 파일명>;
server_namㄷ <서버 도메인>;

# Back-End Setting
proxy_pass <웹 사이트 URL>
```

#### Nginx Start
```bash
sudo service nginx start
or
sudo systemctl start nginx
```

#### Deploy
##### Front-End
```json
// package.json
"script": {
    "build": "vue-cli-service build"
}
```
```bash
npm run build
```
dist 폴더 생성 => index.html => src 경로 앞에 . 추가

##### Back-End
``` xml
<!-- pom.xml-->

<packaging>jar</packaging>
```
Run as -> Maven clean > install > package 순으로 실행

Project -> target -> .jar 파일 생성

##### Local -> AWS File Send & Service Run
```bash
scp -i <pem 파일> <파일> ubuntu@<URL>:<파일>
sudo mv <파일> /var/www/html
sudo java -jar <파일>.jar
sudo service nginx restart
```

# 서비스 설명
```bash
저희 서비스는 자동차에 설치되는 블랙박스와 개인이 업로드한 블랙박스 영상을 저장하고 관리할 수 있는 웹페이지로 이루어져 있습니다.
```

![블랙박스사진](/uploads/6685176ae4b93b95b1da5d4343df6272/블랙박스사진.jpg)
```bash
차량 운행중에 교통법규 위반사례를 목격했다면 블랙박스와 연결된 버튼을 눌러 지난 20초 상황에 대해서만 영상을 본인 웹페이지 계정으로 전송합니다.
```
![홈페이지사진1](/uploads/6257cc270385159ba96fc4fa4b759f54/홈페이지사진1.PNG)
![카드첫클릭](/uploads/362e2c28926b53b0f90a647b94729b38/카드첫클릭.PNG)
```bash
보내온 영상 썸내일을 클릭하게 되면 블랙박스 내 센서로 영상 및 영상정보들이 자동으로 저장되어진 것을 확인할 수 있습니다.
```
![HowToUse1](/uploads/a619d391934835822510474ee01f0c6f/HowToUse1.png)
```bash
초기 상태는 신고 미접수로 아직 스마트 국민제보 사이트에 민원을 접수하기 전 단계입니다
```
![HowToUse3](/uploads/e6106f6af23ffd75004c29b9e82b0ac7/HowToUse3.png)
```bash
제보 상세보기에서는 다음의 빈칸들을 작성 후 저장하기를 누릅니다
```
![HowToUse4](/uploads/272fc6084d8f72fc3f3901116929f22b/HowToUse4.png)
```bash
영상을 다운로드 받은 후 하단의 스마트 국민제보로 신고하러 가기 버튼을 누릅니다.
```
![HowToUse5](/uploads/bda41e62d757f5b8e0e352dd5b0b95c2/HowToUse5.png)
```bash
스마트 국민제보 사이트에서 회원가입 후 로그인을 합니다
```
![HowToUse6](/uploads/730aee4a420384124fd2fc319fe8d7df/HowToUse6.png)
```bash
스마트 국민제보 사이트에서 회원가입 후 로그인을 합니다
```
![HowToUse7](/uploads/433d79f597f4f08d72f273e3389d07d4/HowToUse7.png)
```bash
메인화면에 보이는 교통위반 버튼을 누릅니다.
```
![HowToUse8](/uploads/d0fd8751c1746ce1f51c77a3dc7ef70b/HowToUse8.png)
```bash
분노의 민원 제보목록에 저장된카드 를 보면서 1~8번 순서대로 교통위반신고 항목을 기입하고 신고하기 버튼을 누릅니다.
```

```bash
신고가 완료됐다면 분노의 민원 사이트로 돌아와 사진처럼 신고 미접수 상태를 접수 완료 상태로 바꿔줍니다.
```


# 컨트리뷰터

# 라이센스
[MIT License 2.0](https://lab.ssafy.com/s03-webmobile3-sub2/s03p12a211/blob/develop/LICENSE)
# 기타(디벨롭 룰, 개발 일정, 개발자 소개, 자랑하고 싶은 것, 변화된 이슈 등)

# 개발 규칙

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

# 팀 소개
### 나도내가무섭조
- 팀장 : 조원빈 (Front-End)
    
    Git : 
- 팀원
    - 김남규 (Back-End)
        
        Git : 
    - 김보성 (IoT)
    
        Git : 
    - 박세종 (Front-End)
    
        Git : 
    - 최재빈 (Back-End)
    
        Git : https://lab.ssafy.com/justin613
    - 최정원 (IoT & Front-End)
    
        Git : 







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