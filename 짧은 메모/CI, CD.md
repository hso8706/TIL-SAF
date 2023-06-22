# CI/ CD 파이프라인

### CI
- Continuous Integration, 지속적 통합
- 애플리케이션 코드의 변경 사항이 생기면 정기적으로 빌드 및 테스트를 거쳐 공유 레포지토리에 병합하는 방식
- 여러 명의 개발자가 동시에 애플리케이션 개발과 관련된 코드 작업을 할 경우 서로 충돌하는 문제를 이 방법으로 해결할 수 있음

### CI 요약
- 빌드, 테스트, 레포지토리 merge 과정의 자동화

### CD
- Continuous Delivery, 지속적 서비스 제공
- Continuous Deployment, 지속적인 배포
- 두 용어를 혼용하여 사용함
- 파이프라인의 추가 단계에 대한 자동화를 의미하는 용어들
- 혹은 얼마나 많은 자동화가 이루어지고 있는지를 설명하기 위한 용어
- 개발 코드 변경사항에 대한 버그 테스트를 마치고 자동으로 레포지토리에 업로드 및 배포하는 것
- 최소한의 노력으로 새로운 코드를 배포하는 것이 CD의 목표

### CD 요약
- release(delivery)와 deployment의 자동화

### 기타 설명
- shipping
  - build + test + release + deployment
  - 위 프로세스가 묶인 통합 프로세스
- release
  - 배포할 준비가 된 상태의 스냅샷, 명사로 사용
  - 패키지화 되어있음
  - 릴리즈들이 반드시 배포되진 않음, 내부 테스트 혹은 versioning(여러 버전으로 만드는 작업)등을 목표로하는 릴리즈들도 존재
- deployment
  - AWS와 같은 프로덕션 인프라에 릴리즈를 적용하는 것
- rollback
  - 이전의 릴리즈로 돌리는 것
  - 배포의 일종

### CI/CD 흐름도
![image](https://github.com/hso8706/TIL-SAF/assets/103169947/d99d9316-0cbd-40bf-8980-22ef32c1dc50)
<출처 Red hat>

### Jenkins
- CI/CD 파이프라인 구축에 사용되는 오픈 소스 툴
- jenkins 자동화 서버가 가장 유명

### Jenkins 외 open source tools
- Tekton Pipelines
- Spinnaker
- GoCD
- Concourse
- Screwdriver