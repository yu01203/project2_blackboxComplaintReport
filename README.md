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
![블랙박스사진](/uploads/6685176ae4b93b95b1da5d4343df6272/블랙박스사진.jpg)
![홈페이지사진1](/uploads/2a1e9e39a5b5c8348fa73b85d6551aab/홈페이지사진1.PNG)

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