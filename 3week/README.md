# Community Board (Console version)

## 요구사항

* 간단한 로그인 및 회원가입이 가능하다.
* 원하는 게시판을 선택할 수 있다.
* 해당 게시판에는 글을 삽입, 삭제, 조회가 가능하다.

## 테이블

* USER (**ID**, NAME, PASSWORD)
* BOARD (**BOARD_NO**, NAME, POST_LIST)
* POST (**POST_NO**, TITLE, ID, DATE, CONTENT)