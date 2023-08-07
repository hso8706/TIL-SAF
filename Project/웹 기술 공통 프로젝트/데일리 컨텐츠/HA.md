
### Consistency
- 금융권 키워드

### Partition tolerance
- 장애에 대한 키워드

### HA
- High Availability, 고 가용성
- 서버, 네트워크, 프로그램 등의 정보 시스템이 오랜 기간 동안 지속적으로 정상 운영이 가능한 성질 
  - 같은 의미로, 시스템에서 이슈 발생 시 얼마나 빠른 시간 내에 복구가 가능한지에 대한 척도

### HA 관련 추가 용어
- Active
- Standby
- Master
- Slave
  - traffic을 많이 발생시키는 부분
  - read를 하는 부분
- Backup(Standby랑 동일한 용어)

### cache server
- 보통 미러링 서버를 구성하여 캐시 서버 다운 시에 대비함
- heartbeat: 캐시 버서가 살아있는지 확인하는 개념
- 이중화: 클러스터링, 미러링과 조금 다른 개념

### 로드 밸런서
- 부하분산의 목적
- n개의 active server로 구성

### VRRP 구성