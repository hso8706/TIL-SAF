### node.js 설치
- SSR 방식
- .js 파일을 단독으로 실행할 수 있음
  - 이전에는 html에 import해서 실행
- npm이 같이 깔림
  - npm: node package manager
  - maven, gradle 와 비슷한 역할
  - `npm i -g @vue/cli`
    - i: install
    - g: global(작업하는 환경 외에서도 사용 가능)

### Project 생성
- command : `vue create vuecli-1`
- 사진
  ![image](https://user-images.githubusercontent.com/103169947/237000264-74e60b13-2d04-4c51-8c91-fc968bc5a0eb.png)
    - babel : 작성한 코드의 언어 버젼을 클라이언트(?) 실행 환경에 맞게 맞춰주는 역할
    - eslint : 자바 스크립트 문법 체크해주는 부분
- 다음 진행 사항 - 파란 글씨
- command : `npm run serve`

### npmjs.com
- dependency 찾는 사이트

### Project 공유
- node_modules 빼고 제공
  - 라이브러리를 빼고 제공하는 것
  - 어떤 라이브러리가 필요한지는 package.json에 적혀있음
  - 공유받은 이용자는 `npm i`를 입력하여 필요한 dependencies를 받을 수 있음.

### axios
- command : `npm i --save axios`

### dependency
- devDependencies: 개발에만 필요한 라이브러리

### SPA
- Singel Page Application
  - CLI Project는 index.html라는 하나의 페이지만 존재한다.
  - 하나의 페이지에 모든 기능이 존재함
  - 필요한 부분만 바꿔낌. 즉, Component를 사용한다
  - SPA를 만들기 위해서 SFC를 사용한다.
    - Single File Component
- SPA 장점
  - 속도가 빠름

### srt/components
- .vue 파일
- components를 모아놓는 공간

### .vue
- 한 개의 component를 구현하는 파일
  - component이기 때문에 반드시 export를 해줘야한다.
- 3개의 구성 요소
  - `<template>`
    - template는 .vue 파일 한 개에 하나만 작성 가능
    - HTML(화면) 담당
  - `<script>`
    - script는 .vue 파일 한 개에 하나만 작성 가능
    - JS 담당
  - `<style>`
    - style은 .vue 파일 한 개에 여러번 작성 가능
    - CSS 담당
- App.vue
  - components 내 모든 .vue 파일들을 가지고 있음(import)

### 흐름도
- Components
  - component(.vue) : 반드시 export 해야함
- App.vue 
  - 모든 컴포넌트를 import해서 화면 정보를 가지고 있음
- main.js 
  - Vue 객체 생성해서 el을 지정함(#app)
  - import한 App.vue 내용으로 tag(element)를 생성함. ==> DOM 구성(렌더링 담당)
- index.html
  - #app

### main.js의 render
- `src/assets/render.txt` 참고

### package.json의 "scripts"
- serve
  - `npm run serve`의 serve
  - 긴 명령어를 단축
  - server를 실행시키는 명령어
- build
  - 각각의 component의 내용을 뽑아내고, 그 내부에 영역들인 template, script, style을 따로 모아서 묶은 파일을 만들어낸다.
  - `/dist`를 만들고 내부에 html, css, js 파일을 하나씩 만든다.
  - build된 파일만 있으면 서버를 운영할 수 있음

### 실습 과정
0. vue cli 설치(command 창에서)
  - npm install -g @vue/cli

1. project 생성
  - vue create project-name

2. project 폴더로 이동
  - cd project-name

3. 서버시작
  - npm run serve

4. dependency 설치
  - npm install

5. 추가 디펜던시 설치(vue 외부 라이브러리)
  - npm i --save axios