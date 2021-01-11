# Lotto (Console version)

## 조건
* 숫자 범위: 1~42

* 개수: 기본 번호 6개, 보너스 번호 1개

* 당첨 기준
  - 1등: 기본 번호 6개 일치
  - 2등: 기본 번호 5개 일치 + 보너스 번호 1개 일치
  - 3등: 기본 번호 5개 일치
  - 4등: 기본 번호 4개 일치
  - 5등: 기본 번호 3개 일치
  
* 시뮬레이션 프로세스
  - n개의 로또 자동 생성
  - 당첨 번호 생성
  - n개의 로또 당첨 여부를 통게내어 출력

## 학습 포인트
* 메소드는 한 가지 작업만 한다.
* class의 instance 변수는 3개이상 두지 않는다.
* model 위주의 설계를 먼저 진행한다.

## 실행 화면

![Lotto](https://user-images.githubusercontent.com/58816862/104042506-f00f5d00-521d-11eb-879a-f100b1862dbc.png)

## Class diagram

![classDiagram](https://user-images.githubusercontent.com/58816862/104125966-5a9ad700-539d-11eb-9882-e4dfc5923d37.png)