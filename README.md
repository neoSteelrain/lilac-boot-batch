# 유튜브 배치

#### 목적
    - Lilac 에서 사용할 영상데이터를 Youtube 에서 가져오기 위함
    - DB에 영상데이터를 영구적으로 저장할 필요가 있음

#### 기능
    - Youtube Data API를 이용해 Youtube 재생목록, 영상, 댓글, 채널 정보를 DB에 저장
    - 유튜브 API의 정해진 할당량(10000)을 넘지 않도록 1번에 가져올 재생목록 개수 지정
    - 특정 채널에 있는 재생목록은 검색결과에서 제외
    - 구글 감정분석을 적용여부 설정

#### 사용기술 및 라이브러리
    - Spring batch
    - Youtube Data V3 Liabary

#### 배치의 구성
    - 1 개의 Job, 1개의 Step, 1개의 Tasklet 으로 단순구성

#### 스케쥴러
    - Jenkins
    - 매일 새벽 04시에 1번 실행

#### 배포
    - AWS EC2


