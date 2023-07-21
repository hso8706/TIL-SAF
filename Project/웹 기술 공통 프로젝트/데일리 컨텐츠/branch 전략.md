### git-flow
- versioning 때문에 많이 사용
- 병렬적인 작업 진행을 위해서 사용
- dev에서는 개발자 testing 진행 후 release에 올리기
- release 브랜치는 qa 하는 공간, only bug fix, 안정화의 공간
- hotfix, release 브랜치에서 안정화를 시킨 후 해당 코드가 다음 개발 및 배포에도 필요하다면 dev에도 옮겨야 한다.

### github-flow
- master branch에 때려박기
- pull requeset를 믿는 방식

### git-flow 사용 이유와 장단점
- 을 알고 쓸 것.
- release와 hotfix는 보통은 배포가 live한 상태일 때 사용하는 브랜치

### rebase
- 는 권장하지 않음.
- rebase를 명확히 알고 log를 구분해서 남길 줄 아는 실력이면 사용할 것