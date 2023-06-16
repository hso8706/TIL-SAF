### 브랜치 전략
[참고 링크](https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-github-flow-git-flow-%F0%9F%93%88-%EB%B8%8C%EB%9E%9C%EC%B9%98-%EC%A0%84%EB%9E%B5)

# git-flow
## branch
### 상시 유지
- main
- develop
### 필요시 생성
- feature
- release
- hotfix
- 작업자 이름 붙여서 개인 local을 구분할까?
### 참고 이미지
![캡처](https://user-images.githubusercontent.com/103169947/235562501-36e50688-9b7c-4851-b500-9848c7ace1d9.PNG)
- master : 라이브 서버에 제품으로 출시되는 브랜치.
- develop : 다음 출시 버전을 대비하여 개발하는 브랜치.
- feature : 추가 기능 개발 브랜치. develop 브랜치에 들어간다.
- release : 다음 버전 출시를 준비하는 브랜치. develop 브랜치를 release 브랜치로 옮긴 후 QA, 테스트를 진행하고 master 브랜치로 합친다.
- hotfix : master 브랜치에서 발생한 버그를 수정하는 브랜치.