### 생성 AI의 종류
- 텍스트
  - Chat GPT
- 이미지
  - Stable Diffusion
  - DALL*E 2
- 음성
  - Whisper

### 프롬프트
- 생성 AI에게 제공하는 요청
- GIGO; Garbage In Garbage Out
  - 쓰레기 값을 제공하면 쓰레기 결과가 나온다.
  - 생성 AI의 성능을 좋게 활용하기 위해서는 모호한 프롬프트보다는 좋은 프롬프트를 제공해야한다.
- 프롬프트 엔지니어라는 직업이 생길 정도!

### 프롬프트 예시
```
## 너의 역할
세계 최고의 파이썬 데이터 크롤러

## 크롤링 웹사이트
https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%ED%95%80%ED%85%8C%ED%81%AC

## 첫번째 기사 요소
<a href="https://news.naver.com/main/static/channelPromotion.html" class="spnew_af pick_link" target="_blank" onclick="return goOtherCR(this, 'a=upr.pick&amp;u='+urlencode(this.href));"> <i class="spnew ico_pick">언론사 선정</i>언론사가 선정한 주요기사 혹은 심층기획 기사입니다. </a>

## 너의 목표
위 웹사이트에서 첫번째 기사 제목을 추출하는 코드를 짜줘
```

### OpenAI Platform
- Chat GPT와 같은 생성 AI를 api형식으로 사용할 때, 어떻게 사용하는지에 대한 Documentation, Reference, Examples, Playground를 제공하는 플랫폼

### Playground
- 구분
  - system
    - 사용하는 AI에게 역할 부여하는 부분(역할 놀이)
  - user
    - AI에게 말하고 싶은 말
  - assistant
    - AI의 대답을 미리 내가 작성해서 내가 원하는 대답의 레퍼런스를 보여주는 부분
  - mode, model 등

### ChatGPT 활용법; ver.coding
- 과제
  - 네이버에서 원하는 검색어 (ex. 'SSAFY')에 해당하는 뉴스 기사 제목을 10페이지까지 크롤링한 뒤, 결과물 텍스트(.txt) 파일로 저장