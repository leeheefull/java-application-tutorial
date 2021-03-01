# User Reservation Program

## 요구사항

* Basic Authentication 이용하여 Login 구현
* POST (회원 가입하기): /api/user/signup
* POST (예약 등록하기): /api/reservationInfos
* GET (주문 정보 구하기): /api/reservationInfos
* PUT (예약 취소하기): /api/reservationInfos

## 테이블

![image](https://user-images.githubusercontent.com/58816862/109178996-c9f14c80-77cc-11eb-85b2-16e26318c888.png)

![image](https://user-images.githubusercontent.com/58816862/109179172-f86f2780-77cc-11eb-80ea-0e08480e501f.png)

![image](https://user-images.githubusercontent.com/58816862/109179249-0b81f780-77cd-11eb-8740-e4d6a0eea8ef.png)

![image](https://user-images.githubusercontent.com/58816862/109179313-1ccb0400-77cd-11eb-8912-9283d78fd739.png)



## 실행 화면

#### POST (회원 가입하기): /api/user/signup

> Request

```json
{
  "name": "이희찬",
  "password": "1234",
  "email": "coolzz7@kakao.com",
  "phone": "010-3158-7605"
}
```

> Response

```Json
success
```

#### POST (예약 등록하기): /api/reservationInfos

> Request
>
> * prices : 예매를 할 때 선택한 가격과 수량 정보
>
> * productId : 상품 id
>
> * displayInfoId : 전시 정보 id
>
> * reservationYearMonthDay : 예약일 (반드시 yyyy.mm.dd 형식이어야 합니다.)
>
> * userId : 로그인한 사용자 id

```json
{
  "prices": [
    {
      "count": 2,
      "productPriceId": 3
    }
  ],
  "productId": 1,
  "displayInfoId": 1,
  "reservationYearMonthDay": "2020.01.02",
  "userId": 1
}
```

> Response
>
> * id : 예약 id (자동 생성)
> * productId : 상품 id
> * displayInfoId : 전시 정보 id
> * cancelFlag : 취소 유무 (0 : 취소 안함, 1 : 취소됨)
> * reservationDate : 예약일
> * createDate : 등록일
> * modifyDate : 수정일
> * prices : 예매를 할 때 선택한 가격과 수량 정보

```json
{
  "id": 17,
  "productId": 1,
  "cancelFlag": 0,
  "displayInfoId": 1,
  "userId": 1,
  "reservationDate": 1577890800000,
  "createDate": 1584369835893,
  "modifyDate": 1584369835893,
  "prices": [
    {
      "id": 21,
      "reservationInfoId": 17,
      "productPriceId": 3,
      "count": 2
    }
  ]
}
```

#### GET (주문 정보 구하기): /api/reservationInfos

> Response
>
> * size : 예약한 상품 수
> * items : 예약 상품 정보

```json
{
    "size": 2,
    "items": [
        {
            "id": 16,
            "productId": 1,
            "displayInfoId": 1,
            "cancelFlag": 1,
            "productDescription": "Paper, Present:너를 위한 선물",
            "productContent": "대림미술관은 오는 12월 7일부터 2018년 5월 27일까지 세계적인 아티스트들의 섬세한 감각과 아날로그적 소재인 종이가 만나 감성적인 매체로 확장되는 과정을 소개하는 전시 〈PAPER, PRESENT: 너를 위한 선물〉을 개최합니다. 이번 전시에서는 다양한 분야에서 활동하고 있는 아티스트들이 종이의 본래적 속성에 집중하여 재료 자체의 순수한 아름다움을 담은 작품들을 일곱 개의 감각적인 공간에서 선보입니다. 바람, 별빛, 햇살과 같은 자연 요소와 기억, 설렘과 같은 감정의 요소를 종이와 결합하여 구성한 공간들은, 자연 현상을 감각적으로 경험하고 아날로그적 정서를 자극하는 매체로서 종이를 경험하게 하며 종이에 감성을 입혀 예술로 만나는 특별한 시간을 선물할 것입니다.",
            "userId": 1,
            "sumPrice": 4000,
            "reservationDate": 1577890800000,
            "createDate": 1584369012000,
            "modifyDate": 1584369012000
        },
        {
            "id": 1,
            "productId": 1,
            "displayInfoId": 1,
            "cancelFlag": 0,
            "productDescription": "Paper, Present:너를 위한 선물",
            "productContent": "대림미술관은 오는 12월 7일부터 2018년 5월 27일까지 세계적인 아티스트들의 섬세한 감각과 아날로그적 소재인 종이가 만나 감성적인 매체로 확장되는 과정을 소개하는 전시 〈PAPER, PRESENT: 너를 위한 선물〉을 개최합니다. 이번 전시에서는 다양한 분야에서 활동하고 있는 아티스트들이 종이의 본래적 속성에 집중하여 재료 자체의 순수한 아름다움을 담은 작품들을 일곱 개의 감각적인 공간에서 선보입니다. 바람, 별빛, 햇살과 같은 자연 요소와 기억, 설렘과 같은 감정의 요소를 종이와 결합하여 구성한 공간들은, 자연 현상을 감각적으로 경험하고 아날로그적 정서를 자극하는 매체로서 종이를 경험하게 하며 종이에 감성을 입혀 예술로 만나는 특별한 시간을 선물할 것입니다.",
            "userId": 1,
            "sumPrice": 11000,
            "reservationDate": 1584363798000,
            "createDate": 1584363798000,
            "modifyDate": 1584363798000
        }
    ]
}
```

#### PUT (예약 취소하기): /api/reservationInfos

> Request
>
> * id : 예약 id

```json
{
  "id": 16
}
```

> Response

```json
success
```

