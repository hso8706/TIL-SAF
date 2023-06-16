### 참고 링크
1. [https://meetup.nhncloud.com/posts/122]
2. [https://im-developer.tistory.com/182]

## merge 종류
### Merge
![image](https://user-images.githubusercontent.com/103169947/235568973-bf4e2fe5-8e1e-4ff2-9dbc-e2843f4c1ae7.png)
- merge 후, 다른 branch에서의 커밋 기록도 모두 남고 merge 된 기록도 남음

### Squash and Merge
![image](https://user-images.githubusercontent.com/103169947/235569086-5df12091-37f8-467e-a5c8-e8e13df9d76b.png)
- merge 후, 다른 branch에서의 커밋 기록은 따로 남지 않고 merge 된 기록만 남음
- merge된 기록에 다른 branch 커밋 기록이 전부 기록됨

### Rebase and Merge
![image](https://user-images.githubusercontent.com/103169947/235569126-f988800d-4c13-43bb-a314-0abf6424ce9d.png)
- merge 후, 다른 branch에서의 커밋 기록이 따로 남지 않고 merge 된 브랜치 기록에 같이 남음


## merge 전략
### develop - feature branch
- Squash and Merge
- 깔끔
### master - develop
- Rebase and Merge
### hotfix - develop
- Merge 또는 Squash and Merge